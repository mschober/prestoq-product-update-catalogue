package com.mschober.catalogue.reciever;

import com.mschober.catalogue.queue.EventProcessingQueue;

public class ReceiverFactor {
    public static ProductReceiver createReceiver(EventProcessingQueue productReceiverQueue, String type) {
        if (type.equals("file")) {
            return new FixedWidthProductFileReceiver(productReceiverQueue);
        }
        throw new RuntimeException("Unknown Type");
    }
}
