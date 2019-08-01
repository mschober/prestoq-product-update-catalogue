package com.mschober.catalogue.data.event.record;

import com.mschober.catalogue.data.event.ProductEvent;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransformedUpdateRecord implements ProductRecord {

    private final RawUpdateRecord productRecord;

    public TransformedUpdateRecord(ProductEvent updateRecord) {
        this.productRecord = (RawUpdateRecord) updateRecord;
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
    public void setTaxRate(double v) {
        this.productRecord.setTaxRate(v);
    }

    @Override
    public void setUnitOfMeasure(String pound) {
        this.productRecord.setUnitOfMeasure(pound);
    }

    @Override
    public void setPromotionalDisplayPrice(String calculatePromotionalDisplayPrice) {
        this.productRecord.setPromotionalDisplayPrice(calculatePromotionalDisplayPrice);
    }

    @Override
    public void setPromotionalCalculatorPrice(BigDecimal calculatePromotionalCalculatorPrice) {
        this.productRecord.setPromotionalCalculatorPrice(calculatePromotionalCalculatorPrice);
    }

    @Override
    public void setRegularDisplayPrice(String calculateDisplayPrice) {
        this.productRecord.setRegularDisplayPrice(calculateDisplayPrice);
    }

    @Override
    public void setRegularCalculatorPrice(BigDecimal calculateCalculatorPrice) {
        this.productRecord.setRegularCalculatorPrice(calculateCalculatorPrice);
    }

    @Override
    public BigDecimal getTaxRate() {
        return this.productRecord.getTaxRate();
    }

    @Override
    public String getUnitOfMeasure() {
        return this.productRecord.getUnitOfMeasure();
    }

    @Override
    public String getPromotionalDisplayPrice() {
        return this.productRecord.getPromotionalDisplayPrice();
    }

    @Override
    public BigDecimal getPromotionalCalculatorPrice() {
        return this.productRecord.getPromotionalCalculatorPrice();
    }

    @Override
    public String getRegularDisplayPrice() {
        return this.productRecord.getRegularDisplayPrice();
    }

    @Override
    public BigDecimal getRegularCalculatorPrice() {
        return this.productRecord.getRegularCalculatorPrice();
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
