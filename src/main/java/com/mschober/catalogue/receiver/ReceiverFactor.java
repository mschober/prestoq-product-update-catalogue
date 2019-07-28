package com.mschober.catalogue.receiver;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.receiver.file.fixedwidth.FixedWidthProductFileReceiver;

public class ReceiverFactor {
    public static ProductReceiver createReceiver(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue, String type) {
        if (type.equals("file")) {
            return new FixedWidthProductFileReceiver(receivingQueue, sendingQueue);
        }
        throw new RuntimeException("Unknown Type");
    }
}
