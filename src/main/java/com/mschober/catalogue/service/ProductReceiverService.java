package com.mschober.catalogue.service;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.reciever.DirectoryWatcher;

import java.io.IOException;

public class ProductReceiverService {

    private final EventProcessingQueue productReceiverQueue = null;
    private final DirectoryWatcher directoryWatcher;

    public ProductReceiverService() {
        this.directoryWatcher = new DirectoryWatcher(productReceiverQueue);
    }

    public void start() {
        System.out.println("Starting receiver...");
        try {
            this.directoryWatcher.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}