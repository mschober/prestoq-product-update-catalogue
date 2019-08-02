package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public abstract class FlagUpdateRule implements UpdateRule {

    abstract int flagIndex();
    abstract void setValue(SaveRecord record);
    abstract void printMessage(String productId);

    @Override
    public void applyRule(SaveRecord saveRecord) {
        if (saveRecord.getFlags().charAt(flagIndex()) == 'Y') {
            printMessage(saveRecord.getProductId());
            setValue(saveRecord);
        }
    }
}
