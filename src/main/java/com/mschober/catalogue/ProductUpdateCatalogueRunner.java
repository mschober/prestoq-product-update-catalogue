package com.mschober.catalogue;

import com.mschober.catalogue.service.ProductUpdateCatalogueService;

public class ProductUpdateCatalogueRunner {

    public static void main(String[] args) {
        ProductUpdateCatalogueService catalogueService = new ProductUpdateCatalogueService();
        System.out.println("starting...");
        catalogueService.start();
    }

}
