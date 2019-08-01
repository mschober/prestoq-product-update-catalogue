package com.mschober.catalogue.data.event.record;

import java.math.BigInteger;

public class RawUpdateRecord implements ProductRecord {
    private final String productId;
    private final String productDescription;
    private final BigInteger regularSingularPrice;
    private final BigInteger promotionalSingularPrice;
    private final BigInteger regularSplitPrice;
    private final BigInteger promotionalSplitPrice;
    private final BigInteger regularForX;
    private final BigInteger promotionalForX;
    private final String flags;
    private final String productSize;
    private Double taxRate;

    @Override
    public String getEventContext() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "RawUpdateRecord{" +
                "productId='" + productId + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", regularSingularPrice=" + regularSingularPrice +
                ", promotionalSingularPrice=" + promotionalSingularPrice +
                ", regularSplitPrice=" + regularSplitPrice +
                ", promotionalSplitPrice=" + promotionalSplitPrice +
                ", regularForX=" + regularForX +
                ", promotionalForX=" + promotionalForX +
                ", flags='" + flags + '\'' +
                ", productSize='" + productSize + '\'' +
                ", taxRate=" + taxRate +
                '}';
    }

    public RawUpdateRecord(String[] rawRow) {
        this.productId = rawRow[0];
        this.productDescription = rawRow[1];
        this.regularSingularPrice = new BigInteger(rawRow[2]);
        this.promotionalSingularPrice = new BigInteger(rawRow[3]);
        this.regularSplitPrice = new BigInteger(rawRow[4]);
        this.promotionalSplitPrice = new BigInteger(rawRow[5]);
        this.regularForX = new BigInteger(rawRow[6]);
        this.promotionalForX = new BigInteger(rawRow[7]);
        this.flags = rawRow[8];
        this.productSize = rawRow[9];
    }


    @Override
    public String getProductId() {
        return this.productId;
    }

    @Override
    public String getProductDescription() {
        return this.productDescription;
    }

    @Override
    public BigInteger getRegularSingularPrice() {
        return this.regularSingularPrice;
    }

    @Override
    public BigInteger getPromotionalSingularPrice() {
        return this.promotionalSingularPrice;
    }

    @Override
    public BigInteger getRegularSplitPrice() {
        return this.regularSplitPrice;
    }

    @Override
    public BigInteger getPromotionalSplitPrice() {
        return this.promotionalSplitPrice;
    }

    @Override
    public BigInteger getRegularForX() {
        return this.regularForX;
    }

    @Override
    public BigInteger getPromotionalForX() {
        return this.promotionalForX;
    }

    @Override
    public String getFlags() {
        return this.flags;
    }

    @Override
    public String getProductSize() {
        return this.productSize;
    }

    @Override
    public void setTaxRate(double v) {
        this.taxRate = v;
    }
}
