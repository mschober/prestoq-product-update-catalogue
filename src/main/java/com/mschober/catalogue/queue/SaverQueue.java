package com.mschober.catalogue.queue;

public class SaverQueue extends SingleThreadedBlockingQueue {
    private static SaverQueue ourInstance = new SaverQueue();

    public static SaverQueue getInstance() {
        return ourInstance;
    }

    private SaverQueue() {
        super();
    }
}
