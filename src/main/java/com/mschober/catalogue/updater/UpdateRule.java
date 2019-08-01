package com.mschober.catalogue.updater;

import com.mschober.catalogue.data.event.record.TransformedUpdateRecord;

public interface UpdateRule {
    void applyRule(TransformedUpdateRecord saveRecord);
}
