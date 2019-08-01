package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class UnitOfMeasureRule implements UpdateRule {

    public static final int PER_WEIGHT_INDEX = 2;

    @Override
    public void applyRule(SaveRecord saveRecord) {
        if (saveRecord.getFlags().charAt(PER_WEIGHT_INDEX) == 'Y') {
            System.out.println("applying unit of measure rule");
        }
    }

    @Override
    public String toString() {
        return "UnitOfMeasureRule{}";
    }
}
