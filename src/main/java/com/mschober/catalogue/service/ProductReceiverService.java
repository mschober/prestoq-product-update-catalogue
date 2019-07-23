package com.mschober.catalogue.service;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.reciever.FixedWidthProductFileReceiver;
import com.mschober.catalogue.reciever.ProductReceiver;

import java.util.LinkedList;
import java.util.List;

public class ProductReceiverService {

    private final EventProcessingQueue productReceiverQueue = null;
    private final List<ProductReceiver> receivers;

    public ProductReceiverService() {
        this.receivers = new LinkedList<>();
        // TODO: Dip Inj? or configuration
        this.receivers.add(new FixedWidthProductFileReceiver(productReceiverQueue));
    }

    public void start() {
        for(ProductReceiver r : this.receivers) {
            r.start();
        }
    }
}