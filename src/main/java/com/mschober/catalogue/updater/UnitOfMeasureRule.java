package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class UnitOfMeasureRule extends FlagUpdateRule {

    public static final int PER_WEIGHT_INDEX = 2;

    @Override
    int flagIndex() {
        return PER_WEIGHT_INDEX;
    }

    @Override
    void setValue(SaveRecord record) {
        record.setUnitOfMeasure("Pound");
    }

    @Override
    void printMessage(String productId) {
        System.out.println("applying unit of measure rule " + productId);
    }

    @Override
    public String toString() {
        return "UnitOfMeasureRule{}";
    }
}
