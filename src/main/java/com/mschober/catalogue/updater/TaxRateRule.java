package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class TaxRateRule implements UpdateRule {
    @Override
    public void applyRule(SaveRecord saveRecord) {
        System.out.println("applying tax rate rule");
    }
}
