package com.mschober.catalogue.service;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.reciever.ProductReceiver;
import com.mschober.catalogue.reciever.ReceiverFactor;

import java.util.LinkedList;
import java.util.List;

public class ProductReceiverService {

    private final EventProcessingQueue productReceiverQueue = null;
    private final List<ProductReceiver> receivers;

    public ProductReceiverService() {
        this.receivers = new LinkedList<>();
        // TODO: Dip Inj? or configuration
        this.receivers.add(ReceiverFactor.createReceiver(productReceiverQueue, "file"));
    }

    public void start() {
        for(ProductReceiver r : this.receivers) {
            r.start();
        }
    }
}