package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class TaxRateRule implements UpdateRule {

    public static final int TAXABLE_FLAG = 4;

    @Override
    public void applyRule(SaveRecord saveRecord) {
        if (saveRecord.getFlags().charAt(TAXABLE_FLAG) == 'Y') {
            System.out.println("applying tax rate rule " + saveRecord.getProductId());
            saveRecord.setTaxRate(.07775);
        }
    }

    @Override
    public String toString() {
        return "TaxRateRule{}";
    }
}
