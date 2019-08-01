package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.data.SaveProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplyRulesUpdateStrategy implements ProductUpdateStrategy {

    private final EventProcessor updateProductEventProcessor;

    public ApplyRulesUpdateStrategy(EventProcessingQueue updateProductsQueue, EventProcessingQueue productQueue) {
        this.updateProductEventProcessor = new ApplyRulesEventProcessor(updateProductsQueue, productQueue);
    }

    @Override
    public void run() {
        System.out.println("Starting apply rules update strategy...");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(this.updateProductEventProcessor);
        executor.shutdown();
    }

    private class ApplyRulesEventProcessor extends Thread implements EventProcessor {

        private boolean running;
        private final EventProcessingQueue sendingQueue;
        private EventProcessingQueue queue;

        ApplyRulesEventProcessor(EventProcessingQueue updateProductsQueue, EventProcessingQueue productQueue) {
           this.running = false;
           this.queue = updateProductsQueue;
           this.sendingQueue = productQueue;
        }

        @Override
        public void start() {
            if (!this.running) {
                System.out.println("Starting apply rules event processor...");
                super.start();
            }
        }

        public void run() {
            this.running = true;
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = (ProductEvent) this.queue.take();
                    System.out.println("Update Event Data : Type : " + eventData.getEventContext());
                    //TODO convert file data to update event
                    this.sendingQueue.putEventInQueue(new SaveProductUpdateEvent(eventData.getEventContext()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
