package com.mschober.catalogue.data;

public class ProductUpdateEvent implements ProductEvent {
    private final String eventContext;

    public ProductUpdateEvent(String eventContext) {
        this.eventContext = eventContext;
    }

    @Override
    public String getEventContext() {
        return this.eventContext;
    }
}
