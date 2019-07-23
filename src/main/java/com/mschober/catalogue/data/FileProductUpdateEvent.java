package com.mschober.catalogue.data;

public class FileProductUpdateEvent implements ProductEvent {
    private final String context;

    public FileProductUpdateEvent(String context) {
        this.context = context;
    }

    public String getEventContext() {
        return this.context;
    }
}
