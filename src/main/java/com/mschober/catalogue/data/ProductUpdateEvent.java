package com.mschober.catalogue.data;

public class ProductUpdateEvent implements ProductEvent {
    @Override
    public String getEventContext() {
        return null;
    }
}
