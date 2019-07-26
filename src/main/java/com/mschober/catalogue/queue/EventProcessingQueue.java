package com.mschober.catalogue.queue;

import com.mschober.catalogue.data.ProductEvent;

public interface EventProcessingQueue {

    void putEventInQueue(ProductEvent event);

    ProductEvent take() throws InterruptedException;
}
