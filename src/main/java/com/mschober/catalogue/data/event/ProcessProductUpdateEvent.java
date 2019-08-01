package com.mschober.catalogue.data.event;

import com.mschober.catalogue.data.event.record.RawUpdateRecord;
import com.mschober.catalogue.data.event.record.ProductRecord;

import java.util.ArrayList;
import java.util.List;

public class ProcessProductUpdateEvent implements ProductEvent {

    private final String eventContext;
    private final List<ProductRecord> updateEvents;

    public ProcessProductUpdateEvent(List<String[]> parsedRows) {
        this.eventContext = "static context";
        this.updateEvents = new ArrayList<>(parsedRows.size());
        for (int i = 0; i < parsedRows.size(); i++) {
            updateEvents.add(new RawUpdateRecord(parsedRows.get(i)));
        }
    }

    //TODO this is for debugging
    @Override
    public String getEventContext() {

        StringBuilder sb = new StringBuilder();

        for (ProductRecord r : this.updateEvents) {
            sb.append(r.toString());
        }
        return sb.toString();
    }

    public ProductRecord get(int index) {
        return this.updateEvents.get(index);
    }
}
