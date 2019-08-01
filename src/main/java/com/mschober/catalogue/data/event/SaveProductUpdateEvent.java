package com.mschober.catalogue.data.event;

import com.mschober.catalogue.data.event.ProductEvent;

public class SaveProductUpdateEvent implements ProductEvent {
    private final String eventContext;

    public SaveProductUpdateEvent(ProductEvent event) {
        this.eventContext = event.getEventContext();
    }

    @Override
    public String getEventContext() {
        return eventContext;
    }
}
