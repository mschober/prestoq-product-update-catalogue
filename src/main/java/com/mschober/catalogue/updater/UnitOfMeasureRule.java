package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.TransformedUpdateRecord;

public class UnitOfMeasureRule implements UpdateRule {

    public static final int PER_WEIGHT_INDEX = 2;

    @Override
    public void applyRule(TransformedUpdateRecord saveRecord) {
        if (saveRecord.getFlags().charAt(PER_WEIGHT_INDEX) == 'Y') {
            System.out.println("applying unit of measure rule " + saveRecord.getProductId());
            saveRecord.setUnitOfMeasure("Pound");
        }
    }

    @Override
    public String toString() {
        return "UnitOfMeasureRule{}";
    }
}
