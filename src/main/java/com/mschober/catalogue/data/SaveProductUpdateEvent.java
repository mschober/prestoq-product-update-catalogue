package com.mschober.catalogue.data;

public class SaveProductUpdateEvent implements ProductEvent {
    private final String eventContext;

    public SaveProductUpdateEvent(String eventContext) {
        this.eventContext = eventContext;
    }

    @Override
    public String getEventContext() {
        return eventContext;
    }
}
