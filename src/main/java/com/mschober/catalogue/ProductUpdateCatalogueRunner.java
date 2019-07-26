package com.mschober.catalogue;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.SingleThreadedBlockingQueue;
import com.mschober.catalogue.service.ProductReceiverService;

public class ProductUpdateCatalogueRunner {
    static final EventProcessingQueue productReceiverQueue = new SingleThreadedBlockingQueue();
    static final EventProcessingQueue updateProductQueue = new SingleThreadedBlockingQueue();
    static final EventProcessingQueue saveProductQueue = new SingleThreadedBlockingQueue();

    public static void main(String[] args) {
        startServices();
        System.out.println("starting...");
    }

    private static void startServices() {
        ProductReceiverService receiverService = new ProductReceiverService(productReceiverQueue, updateProductQueue);
        receiverService.start();
    }

}
