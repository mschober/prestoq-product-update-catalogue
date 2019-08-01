package com.mschober.catalogue.data.event;

import com.mschober.catalogue.data.event.record.SaveRecord;

public class SaveProductUpdateEvent implements ProductEvent {
    private final SaveRecord productRecord;

    public SaveProductUpdateEvent(ProductEvent event) {
        this.productRecord = new SaveRecord(event);
    }

    @Override
    public String getEventContext() {
        return this.productRecord.getEventContext();
    }
}
