package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.ProductEvent;
import com.mschober.catalogue.data.event.SaveProductUpdateEvent;
import com.mschober.catalogue.data.event.record.SaveRecord;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;

import java.util.Collection;
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

        private final Collection<UpdateRule> rules;
        private boolean running;
        private final EventProcessingQueue sendingQueue;
        private EventProcessingQueue queue;

        ApplyRulesEventProcessor(EventProcessingQueue updateProductsQueue, EventProcessingQueue productQueue) {
           this.running = false;
           this.queue = updateProductsQueue;
           this.sendingQueue = productQueue;
           this.rules = new IndependentRuleSet();
           this.rules.add(new SplitPricingRule());
           this.rules.add(new TaxRateRule());
           this.rules.add(new UnitOfMeasureRule());
        }

        @Override
        public void start() {
            if (!this.running) {
                System.out.println("Starting apply rules event processor...");
                super.start();
            }
        }

        //TODO refactor to a template?
        public void run() {
            this.running = true;
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = this.queue.take();
                    System.out.println("Update Event Data : Type : " + eventData.getEventContext());
                    SaveRecord saveRecord = new SaveRecord(eventData);
                    for (UpdateRule rule : this.rules) {
                        rule.applyRule(saveRecord);
                    }
                    this.sendingQueue.putEventInQueue(new SaveProductUpdateEvent(saveRecord));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
