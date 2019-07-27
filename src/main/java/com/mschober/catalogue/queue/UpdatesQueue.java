package com.mschober.catalogue.queue;

public class UpdatesQueue extends SingleThreadedBlockingQueue {
    private static UpdatesQueue ourInstance = new UpdatesQueue();

    public static UpdatesQueue getInstance() {
        return ourInstance;
    }

    private UpdatesQueue() {
        super();
    }
}
