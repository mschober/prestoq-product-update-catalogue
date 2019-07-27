package com.mschober.catalogue.async;

//https://dzone.com/articles/synchronising-multithreaded
public class ThreadWrapper {

    /**
     * Start the thread running so that it does some work.
     */
    public void doWork(Runnable job) {

        Thread thread = new Thread(job);
        thread.start();
    }
}