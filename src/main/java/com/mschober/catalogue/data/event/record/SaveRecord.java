package com.mschober.catalogue.data.event.record;

import com.mschober.catalogue.data.event.ProductEvent;

import java.math.BigInteger;

public class SaveRecord implements ProductRecord {

    private final ProductRecord productRecord;

    public SaveRecord(ProductEvent updateRecord) {
        this.productRecord = (ProductRecord) updateRecord;
    }

    @Override
    public String getProductId() {
        return this.productRecord.getProductId();
    }

    @Override
    public String getProductDescription() {
        return this.productRecord.getProductDescription();
    }

    @Override
    public BigInteger getRegularSingularPrice() {
        return this.productRecord.getRegularSingularPrice();
    }

    @Override
    public BigInteger getPromotionalSingularPrice() {
        return this.productRecord.getPromotionalSingularPrice();
    }

    @Override
    public BigInteger getRegularSplitPrice() {
        return this.getRegularSplitPrice();
    }

    @Override
    public BigInteger getPromotionalSplitPrice() {
        return this.getPromotionalSplitPrice();
    }

    @Override
    public BigInteger getRegularForX() {
        return this.getRegularForX();
    }

    @Override
    public BigInteger getPromotionalForX() {
        return this.getPromotionalForX();
    }

    @Override
    public String getFlags() {
        return this.getFlags();
    }

    @Override
    public String getProductSize() {
        return this.getProductSize();
    }

    @Override
    public String getEventContext() {
        return this.productRecord.toString();
    }
}
