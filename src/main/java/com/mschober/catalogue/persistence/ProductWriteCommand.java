package com.mschober.catalogue.persistence;

public interface ProductWriteCommand extends Runnable {
    void run();
}
