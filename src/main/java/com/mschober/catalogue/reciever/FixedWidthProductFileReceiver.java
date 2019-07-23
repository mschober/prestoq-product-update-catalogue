package com.mschober.catalogue.reciever;


import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.SingleThreadedBlockingQueue;

public class FixedWidthProductFileReceiver implements ProductReceiver {
    private final DirectoryWatcher directoryWatcher;
    private final EventProcessor eventProcessor;
    private final EventProcessingQueue productReceiverQueue;

    public FixedWidthProductFileReceiver(EventProcessingQueue productReceiverQueue) {
        if (productReceiverQueue != null) {
            this.productReceiverQueue = productReceiverQueue;
        }
        else {
            //TODO should this class own this? Dep. Inj?
            this.productReceiverQueue = new SingleThreadedBlockingQueue();
        }
        this.directoryWatcher = new DirectoryWatcher(this.productReceiverQueue);
        this.eventProcessor = new EventProcessor(this.productReceiverQueue);
    }

    @Override
    public void start() {
        System.out.println("Starting fixed width file receiver...");
        this.directoryWatcher.start();
        this.eventProcessor.start();
    }

    class EventProcessor extends Thread {
        private final EventProcessingQueue queue;

        public EventProcessor(EventProcessingQueue productReceiverQueue) {
            this.queue = productReceiverQueue;
        }

        @Override
        public void run() {
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = this.queue.take();
                    System.out.println("Process Event Data : Type : " + eventData.getEventContext());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
