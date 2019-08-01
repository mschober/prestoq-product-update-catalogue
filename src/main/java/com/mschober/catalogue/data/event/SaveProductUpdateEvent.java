package com.mschober.catalogue.data.event;

import com.mschober.catalogue.data.event.ProductEvent;

public class SaveProductUpdateEvent implements ProductEvent {
    private final String eventContext;

    public SaveProductUpdateEvent(String events) {
        this.eventContext = "static context";
    }

    @Override
    public String getEventContext() {
        return eventContext;
    }
}
