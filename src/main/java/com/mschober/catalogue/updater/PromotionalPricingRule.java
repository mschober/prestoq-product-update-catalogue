package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class PromotionalPricingRule implements UpdateRule {

    @Override
    public void applyRule(SaveRecord saveRecord) {
        //TODO this might not work for large numbers
        if (saveRecord.getPromotionalSingularPrice().intValue() > 0) {
            System.out.println("applying promotional pricing rule " + saveRecord.getProductId());
        }
    }
}
