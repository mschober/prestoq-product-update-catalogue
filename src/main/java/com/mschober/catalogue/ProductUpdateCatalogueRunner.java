package com.mschober.catalogue;

import com.mschober.catalogue.queue.*;
import com.mschober.catalogue.service.ProductReceiverService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductUpdateCatalogueRunner {
    static final EventProcessingQueue productReceiverQueue = ReceiverQueue.getInstance();
    static final EventProcessingQueue updateProductQueue = UpdaterQueue.getInstance();
    static final EventProcessingQueue saveProductQueue = SaverQueue.getInstance();

    public static void main(String[] args) {
        System.out.println("starting...");
        startServices();
    }

    private static void startServices() {
        ProductReceiverService receiverService = new ProductReceiverService(productReceiverQueue, updateProductQueue);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(receiverService);

        executor.shutdown();
    }

}
