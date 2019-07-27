package com.mschober.catalogue.service;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.receiver.ProductReceiver;
import com.mschober.catalogue.receiver.ReceiverFactor;

import java.util.LinkedList;
import java.util.List;

public class ProductReceiverService {

    private final List<ProductReceiver> receivers;

    public ProductReceiverService(EventProcessingQueue receivingQueue, EventProcessingQueue sendingQueue) {
        this.receivers = new LinkedList<>();
        // TODO: Dip Inj? or configuration
        this.receivers.add(ReceiverFactor.createReceiver(receivingQueue, sendingQueue, "file"));
    }

    public void start() {
        for(ProductReceiver r : this.receivers) {
            r.start();
        }
    }
}