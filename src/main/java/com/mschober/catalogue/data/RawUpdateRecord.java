package com.mschober.catalogue.data;

public class RawUpdateRecord implements UpdateRecord {
    private final String productId;

    public RawUpdateRecord(String[] rawRow) {
        this.productId = rawRow[0];
    }

    @Override
    public String getProductId() {
        return this.productId;
    }
}
