package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.SaveRecord;

public interface UpdateRule {
    void applyRule(SaveRecord saveRecord);
}
