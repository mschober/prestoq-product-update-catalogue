package com.mschober.catalogue.updater;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IndependentRuleSet implements RuleSet {

    //not enforcing order here is handy since rules can be processed independently
    //TODO is this necessary?
    public HashSet<UpdateRule> rules = new HashSet<>();
    @Override
    public int size() {
        return rules.size();
    }

    @Override
    public boolean isEmpty() {
        return rules.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return rules.contains(o);
    }

    @Override
    public Iterator iterator() {
        return rules.iterator();
    }

    @Override
    public Object[] toArray() {
        return rules.toArray();
    }

    @Override
    public boolean add(Object o) {
        return rules.add((UpdateRule)o);
    }

    @Override
    public boolean remove(Object o) {
        return rules.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return rules.addAll(c);
    }

    @Override
    public void clear() {
        rules.clear();
    }

    @Override
    public boolean retainAll(Collection c) {
        return rules.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return rules.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return rules.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return rules.toArray(a);
    }
}
