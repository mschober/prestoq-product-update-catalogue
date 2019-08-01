package com.mschober.catalogue.data;

import java.util.List;

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
