package com.mschober.catalogue.queue;

public interface EventProcessor extends Runnable {
    void start();
    void run();
}
