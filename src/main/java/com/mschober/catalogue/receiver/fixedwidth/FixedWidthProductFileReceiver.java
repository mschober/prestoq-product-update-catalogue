package com.mschober.catalogue.receiver.fixedwidth;


import com.mschober.catalogue.data.ProcessProductUpdateEvent;
import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;
import com.mschober.catalogue.receiver.DirectoryWatcher;
import com.mschober.catalogue.receiver.ProductReceiver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedWidthProductFileReceiver implements ProductReceiver {
    private final DirectoryWatcher directoryWatcher;
    private final EventProcessor eventProcessor;

    public FixedWidthProductFileReceiver(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue) {
        //TODO should this class own this? Dep. Inj?
        this.directoryWatcher = new DirectoryWatcher(receivingQueue, "/tmp/productchanges");
        this.eventProcessor = new RawFileEventProcessor(receivingQueue, sendingQueue);
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

        public RawFileEventProcessor(EventProcessingQueue productReceiverQueue, EventProcessingQueue sendingQueue) {
            this.queue = productReceiverQueue;
            this.sendingQueue = sendingQueue;
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
                    this.sendingQueue.putEventInQueue(new ProcessProductUpdateEvent(eventData.getEventContext()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}