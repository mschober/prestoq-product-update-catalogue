package com.mschober.catalogue;

import com.mschober.catalogue.queue.*;
import com.mschober.catalogue.service.ProductReceiverService;
import com.mschober.catalogue.service.ProductUpdateService;

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
        ExecutorService executor = Executors.newSingleThreadExecutor();

        ProductReceiverService receiverService = new ProductReceiverService(productReceiverQueue, updateProductQueue);
        ProductUpdateService updateService = new ProductUpdateService(updateProductQueue);

        executor.submit(receiverService);
        executor.submit(updateService);
        executor.shutdown();
    }

}
