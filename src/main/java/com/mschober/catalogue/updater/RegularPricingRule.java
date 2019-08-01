package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.TransformedUpdateRecord;

import java.math.BigDecimal;

public class RegularPricingRule extends PricingRule implements UpdateRule {

    @Override
    public void applyRule(TransformedUpdateRecord saveRecord) {
        //TODO will this create issues with very large values?

        boolean isRegularSingle = saveRecord.getRegularSingularPrice().intValue() > 0;
        boolean isRegularSplit = saveRecord.getRegularSplitPrice().intValue() > 0;

        BigDecimal calculatorPrice = null;
        if (isRegularSingle) {
            calculatorPrice = new BigDecimal(saveRecord.getRegularSingularPrice());
        }
        if (isRegularSplit) {
            calculatorPrice = calculateSplitPrice(saveRecord.getRegularSplitPrice(), saveRecord.getRegularForX());
        }
        if (isRegularSingle || isRegularSplit) {
            System.out.println("applying regular pricing rule " + saveRecord.getProductId());
            calculatorPrice = calculatorPrice.divide(new BigDecimal(100));
            saveRecord.setRegularDisplayPrice(formatDisplayPrice(calculatorPrice));
            saveRecord.setRegularCalculatorPrice(formatCalculatorPrice(calculatorPrice));
        }
    }

    @Override
    public String toString() {
        return "RegularPricingRule{}";
    }
}
