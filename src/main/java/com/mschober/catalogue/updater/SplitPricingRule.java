package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class SplitPricingRule implements UpdateRule {
    @Override
    public void applyRule(SaveRecord saveRecord) {
        System.out.println("applying split pricing rule");
    }
}
