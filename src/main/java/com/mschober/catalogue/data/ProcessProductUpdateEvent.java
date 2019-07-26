package com.mschober.catalogue.data;

public class ProcessProductUpdateEvent implements ProductEvent {
    private final String eventContext;

    public ProcessProductUpdateEvent(String eventContext) {
        this.eventContext = eventContext;
    }

    @Override
    public String getEventContext() {
        return this.eventContext;
    }
}
