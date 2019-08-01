package com.mschober.catalogue.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ProcessProductUpdateEvent implements ProductEvent, Collection {

    private final String eventContext;
    private final List<UpdateRecord> updateEvents;

    public ProcessProductUpdateEvent(List<String[]> parsedRows) {
        this.eventContext = "static context";
        this.updateEvents = new ArrayList<UpdateRecord>(parsedRows.size());
        for (int i = 0; i < parsedRows.size(); i++) {
            updateEvents.add(new RawUpdateRecord(parsedRows.get(i)));
        }
    }

    //TODO this is for debugging
    @Override
    public String getEventContext() {

        StringBuilder sb = new StringBuilder();

        for (UpdateRecord r : this.updateEvents) {
            sb.append(r.toString());
        }
        return sb.toString();
    }

    @Override
    public int size() {
        return this.updateEvents.size();
    }

    @Override
    public boolean isEmpty() {
        return this.updateEvents.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.updateEvents.contains(o);
    }

    @Override
    public Iterator iterator() {
        return this.updateEvents.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.updateEvents.toArray();
    }

    @Override
    public boolean add(Object o) {
        return this.updateEvents.add((UpdateRecord) o);
    }

    @Override
    public boolean remove(Object o) {
        return this.updateEvents.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return this.updateEvents.addAll(c);
    }

    @Override
    public void clear() {
        this.updateEvents.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return this.updateEvents.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return this.updateEvents.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return this.updateEvents.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.updateEvents.toArray(a);
    }
}
