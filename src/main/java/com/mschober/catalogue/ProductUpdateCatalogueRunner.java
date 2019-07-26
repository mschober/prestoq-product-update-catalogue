package com.mschober.catalogue;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.SingleThreadedBlockingQueue;
import com.mschober.catalogue.service.ProductReceiverService;

public class ProductUpdateCatalogueRunner {
    static final EventProcessingQueue productReceiverQueue = SingleThreadedBlockingQueue.getInstance();
    static final EventProcessingQueue updateProductQueue = SingleThreadedBlockingQueue.getInstance();
    static final EventProcessingQueue saveProductQueue = SingleThreadedBlockingQueue.getInstance();

    public static void main(String[] args) {
        System.out.println("starting...");
        startServices();
    }

    private static void startServices() {
        ProductReceiverService receiverService = new ProductReceiverService(productReceiverQueue, updateProductQueue);
        receiverService.start();
    }

}
