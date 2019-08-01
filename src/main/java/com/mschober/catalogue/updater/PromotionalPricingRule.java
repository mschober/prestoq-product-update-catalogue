package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

import java.math.BigDecimal;

public class PromotionalPricingRule extends PricingRule implements UpdateRule{

    @Override
    public void applyRule(SaveRecord saveRecord) {

        boolean isPromotionalSingle = saveRecord.getPromotionalSingularPrice().intValue() > 0;
        boolean isPromotionalSplit = saveRecord.getPromotionalSplitPrice().intValue() > 0;

        BigDecimal calculatorPrice = null;
        if (isPromotionalSingle) {
            calculatorPrice = new BigDecimal(saveRecord.getPromotionalSingularPrice());
        }

        if (isPromotionalSplit) {
            calculatorPrice = calculateSplitPrice(saveRecord.getPromotionalSplitPrice(), saveRecord.getPromotionalForX());
        }

        //TODO this might not work for large numbers
        if (isPromotionalSingle || isPromotionalSplit) {
            System.out.println("applying promotional pricing rule " + saveRecord.getProductId());
            calculatorPrice = calculatorPrice.divide(new BigDecimal(100));
            saveRecord.setPromotionalDisplayPrice(formatDisplayPrice(calculatorPrice));
            saveRecord.setPromotionalCalculatorPrice(formatCalculatorPrice(calculatorPrice));
        }
    }
}
