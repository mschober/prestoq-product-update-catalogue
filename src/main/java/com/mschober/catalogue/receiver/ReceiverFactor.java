package com.mschober.catalogue.receiver;

import com.mschober.catalogue.queue.EventProcessingQueue;

public class ReceiverFactor {
    public static ProductReceiver createReceiver(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue, String type) {
        if (type.equals("file")) {
            return new FixedWidthProductFileReceiver(receivingQueue, sendingQueue);
        }
        throw new RuntimeException("Unknown Type");
    }
}
