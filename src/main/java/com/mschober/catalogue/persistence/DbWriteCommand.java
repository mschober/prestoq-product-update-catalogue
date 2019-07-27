package com.mschober.catalogue.persistence;

import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DbWriteCommand implements ProductWriteCommand {

    private final DbWriteEventProcessor dbWriteEventProcessor;

    public DbWriteCommand(EventProcessingQueue saveProductQueue) {
        this.dbWriteEventProcessor = new DbWriteEventProcessor(saveProductQueue);
    }

    @Override
    public void run() {
        System.out.println("Starting db writer...");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(this.dbWriteEventProcessor);
        executor.shutdown();
    }

    private class DbWriteEventProcessor extends Thread implements EventProcessor {

        private boolean running;
        private EventProcessingQueue queue;

        DbWriteEventProcessor(EventProcessingQueue saveProductsQueue) {
            this.running = false;
            this.queue = saveProductsQueue;
        }

        @Override
        public void start() {
            if (!this.running) {
                System.out.println("Starting save event processor...");
                super.start();
            }
        }

        public void run() {
            this.running = true;
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = this.queue.take();
                    System.out.println("Save Event Data : Type : " + eventData.getEventContext());
                    //TODO convert file data to update event
//                    this.sendingQueue.putEventInQueue(new ProcessProductUpdateEvent(eventData.getEventContext()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
