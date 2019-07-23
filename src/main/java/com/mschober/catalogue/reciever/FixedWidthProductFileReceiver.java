package com.mschober.catalogue.reciever;


import com.mschober.catalogue.queue.EventProcessingQueue;

import java.io.IOException;

public class FixedWidthProductFileReceiver implements ProductReceiver {
    private final DirectoryWatcher directoryWatcher;

    public FixedWidthProductFileReceiver(EventProcessingQueue productReceiverQueue) {
        this.directoryWatcher = new DirectoryWatcher(productReceiverQueue);
    }

    @Override
    public void start() {
        System.out.println("Starting fixed width file receiver...");
        this.directoryWatcher.start();
    }
}
