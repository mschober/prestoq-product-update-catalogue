package com.mschober.catalogue;

import com.mschober.catalogue.queue.SingleThreadedBlockingQueue;
import com.mschober.catalogue.service.ProductReceiverService;

public class ProductUpdateCatalogueRunner {

    public static void main(String[] args) {
        startServices();
        System.out.println("starting...");
    }

    private static void startServices() {
        ProductReceiverService receiverService = new ProductReceiverService();
        receiverService.start();
    }

}
