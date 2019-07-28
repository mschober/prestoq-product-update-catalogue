package com.mschober.catalogue.receiver.file.fixedwidth;


import com.mschober.catalogue.data.ProcessProductUpdateEvent;
import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;
import com.mschober.catalogue.receiver.DirectoryWatcher;
import com.mschober.catalogue.receiver.ProductReceiver;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedWidthProductFileReceiver implements ProductReceiver {
    private final DirectoryWatcher directoryWatcher;
    private final EventProcessor eventProcessor;

    public FixedWidthProductFileReceiver(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue) {
        //TODO should this class own this? Dep. Inj?
        String watchDir = "/tmp/productchanges";
        this.directoryWatcher = new DirectoryWatcher(receivingQueue, watchDir);
        this.eventProcessor = new RawFileEventProcessor(receivingQueue, sendingQueue, watchDir);
    }

    public void run() {
        System.out.println("Starting fixed width file receiver...");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(this.directoryWatcher);
        executor.shutdown();
        this.directoryWatcher.register(this.eventProcessor);
    }

    class RawFileEventProcessor extends Thread implements EventProcessor {
        private final EventProcessingQueue queue;
        private final EventProcessingQueue sendingQueue;
        private boolean running;
        private String watchDir;

        public RawFileEventProcessor(EventProcessingQueue productReceiverQueue, EventProcessingQueue sendingQueue, String watchDir) {
            this.queue = productReceiverQueue;
            this.sendingQueue = sendingQueue;
            this.watchDir = watchDir;
            this.running = false;
        }

        @Override
        public void start() {
            if (!this.running) {
                System.out.println("Starting raw file event processor...");
                super.start();
            }
        }

        @Override
        public void run() {
            this.running = true;
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = this.queue.take();
                    System.out.println("Process Raw File Event Data : Type : " + eventData.getEventContext());
                    //TODO convert file data to update event
                    FixedWithProductUpdateFileParser fixedWithProductUpdateFileParser = new FixedWithProductUpdateFileParser();
                    List<String[]> parse = fixedWithProductUpdateFileParser.parse(new File(this.watchDir + "/" + eventData.getEventContext()));
                    this.sendingQueue.putEventInQueue(new ProcessProductUpdateEvent(eventData.getEventContext()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
