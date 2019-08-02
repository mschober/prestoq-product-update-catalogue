package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class TaxRateRule extends FlagUpdateRule {

    public static final int TAXABLE_FLAG = 4;

    @Override
    public String toString() {
        return "TaxRateRule{}";
    }

    @Override
    int flagIndex() {
        return TAXABLE_FLAG;
    }

    @Override
    void setValue(SaveRecord record) {
        record.setTaxRate(.07775);
    }

    @Override
    void printMessage(String productId) {
        System.out.println("applying tax rate rule " + productId);
    }
}
