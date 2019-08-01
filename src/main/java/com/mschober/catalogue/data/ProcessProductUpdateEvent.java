package com.mschober.catalogue.data;

import java.util.ArrayList;
import java.util.List;

public class ProcessProductUpdateEvent implements ProductEvent {

    private final String eventContext;
    private final List<UpdateRecord> updateEvents;

    public ProcessProductUpdateEvent(List<String[]> parsedRows) {
        this.eventContext = "static context";
        this.updateEvents = new ArrayList<UpdateRecord>();
        for (int i = 0; i < parsedRows.size(); i++) {
            updateEvents.add(new RawUpdateRecord(parsedRows.get(i)));
        }
    }

    @Override
    public String getEventContext() {
        return this.eventContext;
    }
}
