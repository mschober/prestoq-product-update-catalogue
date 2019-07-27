package com.mschober.catalogue.queue;

public class ReceiverQueue extends SingleThreadedBlockingQueue {
    private static ReceiverQueue ourInstance = new ReceiverQueue();

    public static ReceiverQueue getInstance() {
        return ourInstance;
    }

    private ReceiverQueue() {
        super();
    }

}
