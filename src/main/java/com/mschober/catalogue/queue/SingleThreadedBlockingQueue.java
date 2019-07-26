package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.ProductEvent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleThreadedBlockingQueue implements EventProcessingQueue {


    private static BlockingQueue<ProductEvent> eventQueue = null;

//    private SingleThreadedBlockingQueue() {}

//    // TODO how should this be handled?
//    public static EventProcessingQueue getInstance() {
//        if (instance == null) {
//            instance = new SingleThreadedBlockingQueue();
//        }
//        return instance;
//    }

    private void initialize() {
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
