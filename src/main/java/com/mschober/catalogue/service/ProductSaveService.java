package com.mschober.catalogue.service;

import com.mschober.catalogue.persistence.DbWriteCommand;
import com.mschober.catalogue.persistence.ProductWriteCommand;
import com.mschober.catalogue.queue.EventProcessingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductSaveService implements Runnable {

    private final ProductWriteCommand writeCommand;

    public ProductSaveService(EventProcessingQueue saveProductQueue) {
        this.writeCommand = new DbWriteCommand(saveProductQueue);
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(writeCommand);
        executor.shutdown();
    }
}
