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
        return this.productRecord.getRegularSplitPrice();
    }

    @Override
    public BigInteger getPromotionalSplitPrice() {
        return this.productRecord.getPromotionalSplitPrice();
    }

    @Override
    public BigInteger getRegularForX() {
        return this.productRecord.getRegularForX();
    }

    @Override
    public BigInteger getPromotionalForX() {
        return this.productRecord.getPromotionalForX();
    }

    @Override
    public String getFlags() {
        return this.productRecord.getFlags();
    }

    @Override
    public String getProductSize() {
        return this.productRecord.getProductSize();
    }

    @Override
    public String getEventContext() {
        return this.productRecord.toString();
    }

    @Override
    public String toString() {
        return this.productRecord.getEventContext();
    }
}
