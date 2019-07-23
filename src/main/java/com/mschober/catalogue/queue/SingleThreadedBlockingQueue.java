package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.ProductEvent;
import com.mschober.catalogue.data.ProductUpdateEvent;
import org.w3c.dom.events.Event;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SingleThreadedBlockingQueue implements EventProcessingQueue {


    private static SingleThreadedBlockingQueue instance = null;
    private static BlockingQueue<ProductEvent> eventQueue = null;

//    private SingleThreadedBlockingQueue() {}

//    public static SingleThreadedBlockingQueue getInstance() {
//        if (instance == null) {
//            instance = new SingleThreadedBlockingQueue();
//        }
//        return instance;
//    }

    private void initialize() {
        if (eventQueue == null) {
            eventQueue = new LinkedBlockingQueue<>();
            EventProcessor eventProcessor = new EventProcessor();
            eventProcessor.start();
        }
    }


    public void putEventInQueue(ProductEvent eventData) {
        try {
            initialize();
            eventQueue.put(eventData);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    class EventProcessor extends Thread {
        @Override
        public void run() {
            for (;;) {
                ProductEvent eventData = null;
                try {
                    eventData = eventQueue.take();
                    System.out.println("Process Event Data : Type : " + eventData.getEventContext());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
