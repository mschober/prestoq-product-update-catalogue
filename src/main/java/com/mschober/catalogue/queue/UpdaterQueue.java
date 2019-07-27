package com.mschober.catalogue.queue;

public class UpdaterQueue extends SingleThreadedBlockingQueue {
    private static UpdaterQueue ourInstance = new UpdaterQueue();

    public static UpdaterQueue getInstance() {
        return ourInstance;
    }

    private UpdaterQueue() {
        super();
    }
}
