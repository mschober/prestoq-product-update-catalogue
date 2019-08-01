package com.mschober.catalogue.data.event.record;

import com.mschober.catalogue.data.event.ProductEvent;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SaveRecord implements ProductRecord {

    private final TransformedUpdateRecord transformedRecord;

    public SaveRecord(ProductEvent event) {
        this.transformedRecord = (TransformedUpdateRecord) event;
    }

    @Override
    public String getProductId() {
        return this.transformedRecord.getProductId();
    }

    @Override
    public String getProductDescription() {
        return this.transformedRecord.getProductDescription();
    }

    @Override
    public BigInteger getRegularSingularPrice() {
        return this.transformedRecord.getRegularSingularPrice();
    }

    @Override
    public BigInteger getPromotionalSingularPrice() {
        return this.transformedRecord.getPromotionalSingularPrice();
    }

    @Override
    public BigInteger getRegularSplitPrice() {
        return this.transformedRecord.getRegularSplitPrice();
    }

    @Override
    public BigInteger getPromotionalSplitPrice() {
        return this.transformedRecord.getPromotionalSplitPrice();
    }

    @Override
    public BigInteger getRegularForX() {
        return this.transformedRecord.getRegularForX();
    }

    @Override
    public BigInteger getPromotionalForX() {
        return this.transformedRecord.getPromotionalForX();
    }

    @Override
    public String getFlags() {
        return this.transformedRecord.getFlags();
    }

    @Override
    public String getProductSize() {
        return this.transformedRecord.getProductSize();
    }

    //TODO need another interface
    @Override
    public void setTaxRate(double v) {
        this.transformedRecord.setTaxRate(v);
    }

    @Override
    public void setUnitOfMeasure(String pound) {
        this.transformedRecord.setUnitOfMeasure(pound);
    }

    @Override
    public void setPromotionalDisplayPrice(String calculatePromotionalDisplayPrice) {
        this.transformedRecord.setPromotionalDisplayPrice(calculatePromotionalDisplayPrice);
    }

    @Override
    public void setPromotionalCalculatorPrice(BigDecimal calculatePromotionalCalculatorPrice) {
        this.transformedRecord.setPromotionalCalculatorPrice(calculatePromotionalCalculatorPrice);
    }

    @Override
    public void setRegularDisplayPrice(String calculateDisplayPrice) {
        this.transformedRecord.setRegularDisplayPrice(calculateDisplayPrice);
    }

    @Override
    public void setRegularCalculatorPrice(BigDecimal calculateCalculatorPrice) {
        this.transformedRecord.setRegularCalculatorPrice(calculateCalculatorPrice);
    }

    @Override
    public BigDecimal getTaxRate() {
        return this.transformedRecord.getTaxRate();
    }

    @Override
    public String getUnitOfMeasure() {
        return this.transformedRecord.getUnitOfMeasure();
    }

    @Override
    public String getPromotionalDisplayPrice() {
        return this.transformedRecord.getPromotionalDisplayPrice();
    }

    @Override
    public BigDecimal getPromotionalCalculatorPrice() {
        return this.transformedRecord.getPromotionalCalculatorPrice();
    }

    @Override
    public String getRegularDisplayPrice() {
        return this.transformedRecord.getRegularDisplayPrice();
    }

    @Override
    public BigDecimal getRegularCalculatorPrice() {
        return this.transformedRecord.getRegularCalculatorPrice();
    }

    @Override
    public String getEventContext() {
        StringBuffer sb = new StringBuffer();
        String initial = "RawUpdateRecord{" +
                "productId='" + this.transformedRecord.getProductId() + '\'' +
                ", productDescription='" + this.transformedRecord.getProductDescription() + '\'' +
                ", productSize='" + this.transformedRecord.getProductSize()  + '\'' +
                ", taxRate=" + this.transformedRecord.getTaxRate() + '\'' +
                ", unitOfMeasure='" + this.transformedRecord.getUnitOfMeasure();
            sb.append(initial);
            if (this.transformedRecord.getPromotionalDisplayPrice() != null) {
                sb.append(", promotionalDisplayPrice='" + this.transformedRecord.getPromotionalDisplayPrice() + '\'');
            }

            if (this.transformedRecord.getPromotionalCalculatorPrice().intValue() > 0) {
                sb.append(", promotionalCalculatorPrice='" + this.transformedRecord.getPromotionalCalculatorPrice() + '\'');
            }

            if (this.transformedRecord.getRegularDisplayPrice() != null) {
                sb.append(", regularDisplayPrice='" + this.transformedRecord.getRegularDisplayPrice() + '\'');
            }

            if (this.transformedRecord.getRegularCalculatorPrice().intValue() > 0) {
                sb.append(", promotionalCalculatorPrice='" + this.transformedRecord.getRegularCalculatorPrice() + '\'');
            }
            return sb.toString();
    }
}
