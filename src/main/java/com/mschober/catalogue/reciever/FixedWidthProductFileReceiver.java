package com.mschober.catalogue.reciever;


import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.data.ProcessProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;

public class FixedWidthProductFileReceiver implements ProductReceiver {
    private final DirectoryWatcher directoryWatcher;
    private final EventProcessor eventProcessor;

    public FixedWidthProductFileReceiver(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue) {
        //TODO should this class own this? Dep. Inj?
        this.directoryWatcher = new DirectoryWatcher(receivingQueue);
        this.eventProcessor = new EventProcessor(receivingQueue, sendingQueue);
    }

    @Override
    public void start() {
        System.out.println("Starting fixed width file receiver...");
        this.directoryWatcher.start();
        this.eventProcessor.start();
    }

    class EventProcessor extends Thread {
        private final EventProcessingQueue queue;
        private final EventProcessingQueue sendingQueue;

        public EventProcessor(EventProcessingQueue productReceiverQueue, EventProcessingQueue sendingQueue) {
            this.queue = productReceiverQueue;
            this.sendingQueue = sendingQueue;
        }

        @Override
        public void run() {
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = this.queue.take();
                    System.out.println("Process Event Data : Type : " + eventData.getEventContext());
                    //TODO convert file data to update event
                    this.sendingQueue.putEventInQueue(new ProcessProductUpdateEvent(eventData.getEventContext()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
