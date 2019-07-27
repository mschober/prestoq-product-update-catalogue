package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.ProductEvent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class SingleThreadedBlockingQueue implements EventProcessingQueue {

    private BlockingQueue<ProductEvent> eventQueue;

    public SingleThreadedBlockingQueue() {
        eventQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void putEventInQueue(ProductEvent eventData) {
        try {
            eventQueue.put(eventData);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ProductEvent take() throws InterruptedException {
        return eventQueue.take();
    }
}
