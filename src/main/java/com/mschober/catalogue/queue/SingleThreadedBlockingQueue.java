package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.ProductEvent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleThreadedBlockingQueue implements EventProcessingQueue {


    private static SingleThreadedBlockingQueue instance;
    private static BlockingQueue<ProductEvent> eventQueue;

    private SingleThreadedBlockingQueue() {}


    public static EventProcessingQueue getInstance() {
        if (instance == null) {
            instance = new SingleThreadedBlockingQueue();
        }
        return instance;
    }

    private static void initialize() {
        if (eventQueue == null) {
            eventQueue = new LinkedBlockingQueue<>();
        }
    }


    @Override
    public void putEventInQueue(ProductEvent eventData) {
        try {
            initialize();
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
