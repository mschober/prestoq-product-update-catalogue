package com.mschober.catalogue.updater;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public abstract class PricingRule {

    protected BigDecimal formatCalculatorPrice(BigDecimal calculatorPrice) {

        BigDecimal scaled = calculatorPrice.setScale(4, RoundingMode.HALF_DOWN);
        return scaled;
    }

    protected String formatDisplayPrice(BigDecimal calculatorPrice) {
        String displayPrice = "$";
        displayPrice += calculatorPrice.setScale(2, RoundingMode.HALF_DOWN).toPlainString();
        return displayPrice;
    }

    protected BigDecimal calculateSplitPrice(BigInteger splitPrice, BigInteger forX) {
        BigDecimal price = new BigDecimal(splitPrice);
        BigDecimal quotient = price.divide(new BigDecimal(forX));
        return quotient;
    }
}
