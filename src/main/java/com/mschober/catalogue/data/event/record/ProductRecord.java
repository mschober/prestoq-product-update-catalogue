package com.mschober.catalogue.data.event.record;

import com.mschober.catalogue.data.event.ProductEvent;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface ProductRecord extends ProductEvent {
    String getProductId();

    String getProductDescription();

//    http://www.javapractices.com/topic/TopicAction.do?Id=13
    BigInteger getRegularSingularPrice();

    BigInteger getPromotionalSingularPrice();

    BigInteger getRegularSplitPrice();

    BigInteger getPromotionalSplitPrice();

    BigInteger getRegularForX();

    BigInteger getPromotionalForX();

    String getFlags();

    String getProductSize();

    void setTaxRate(double v);

    void setUnitOfMeasure(String pound);

    void setPromotionalDisplayPrice(String calculatePromotionalDisplayPrice);

    void setPromotionalCalculatorPrice(BigDecimal calculatePromotionalCalculatorPrice);

    void setRegularDisplayPrice(String calculateDisplayPrice);

    void setRegularCalculatorPrice(BigDecimal calculateCalculatorPrice);

    BigDecimal getTaxRate();

    String getUnitOfMeasure();

    String getPromotionalDisplayPrice();

    BigDecimal getPromotionalCalculatorPrice();

    String getRegularDisplayPrice();

    BigDecimal getRegularCalculatorPrice();
}
