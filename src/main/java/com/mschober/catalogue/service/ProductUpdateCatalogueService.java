package com.mschober.catalogue.service;

import com.mschober.data.ProductRecord;

import java.util.ArrayList;
import java.util.Collection;

public class ProductUpdateCatalogueService {

    private final Collection<ProductRecord> productRecords;
    public ProductUpdateCatalogueService() {
        this.productRecords = new ArrayList<>();
    }

    public void start() {
    }
}
