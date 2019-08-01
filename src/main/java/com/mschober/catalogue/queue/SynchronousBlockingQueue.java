package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.event.ProductEvent;

import java.util.concurrent.SynchronousQueue;

public class SynchronousBlockingQueue implements EventProcessingQueue {
    private SynchronousQueue<ProductEvent> eventQueue;

    @Override
    public void putEventInQueue(ProductEvent event) {
        eventQueue = new SynchronousQueue<>();

    }

    @Override
    public ProductEvent take() throws InterruptedException {
        return null;
    }
}
