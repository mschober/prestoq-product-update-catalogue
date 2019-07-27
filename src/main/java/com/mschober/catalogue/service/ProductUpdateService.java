package com.mschober.catalogue.service;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.updater.ApplyRulesUpdateStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductUpdateService implements Runnable {

    private final ApplyRulesUpdateStrategy updateStrategy;

    public ProductUpdateService(EventProcessingQueue updateProductQueue) {
        updateStrategy = new ApplyRulesUpdateStrategy(updateProductQueue);
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(updateStrategy);
        executor.shutdown();
    }
}