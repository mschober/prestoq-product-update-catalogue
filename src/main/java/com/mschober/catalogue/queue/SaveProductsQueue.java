package com.mschober.catalogue.queue;

public class SaveProductsQueue extends SingleThreadedBlockingQueue {
    private static SaveProductsQueue ourInstance = new SaveProductsQueue();

    public static SaveProductsQueue getInstance() {
        return ourInstance;
    }

    private SaveProductsQueue() {
        super();
    }
}
