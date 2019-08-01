package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class SplitPricingRule implements UpdateRule {
    @Override
    public void applyRule(SaveRecord saveRecord) {
        //TODO will this create issues with very large values?
        if (saveRecord.getRegularSingularPrice().intValue() == 0) {
            System.out.println("applying split pricing rule");
        }
    }

    @Override
    public String toString() {
        return "SplitPricingRule{}";
    }
}
