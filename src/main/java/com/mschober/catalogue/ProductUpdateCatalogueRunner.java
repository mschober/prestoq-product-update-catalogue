package com.mschober.catalogue;

import com.mschober.catalogue.queue.*;
import com.mschober.catalogue.service.ProductReceiverService;

public class ProductUpdateCatalogueRunner {
    static final EventProcessingQueue productReceiverQueue = ReceiverQueue.getInstance();
    static final EventProcessingQueue updateProductQueue = UpdatesQueue.getInstance();
    static final EventProcessingQueue saveProductQueue = SaveProductsQueue.getInstance();

    public static void main(String[] args) {
        System.out.println("starting...");
        startServices();
    }

    private static void startServices() {
        ProductReceiverService receiverService = new ProductReceiverService(productReceiverQueue, updateProductQueue);
        receiverService.start();
    }

}
