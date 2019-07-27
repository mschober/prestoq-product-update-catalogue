package com.mschober.catalogue.receiver;

import com.mschober.catalogue.data.FileProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

// watches files changes and pushes events onto the queue
// https://www.baeldung.com/java-nio2-watchservice
public class DirectoryWatcher implements Runnable {
    private final EventProcessingQueue queue;
    private final String path;
    private WatchService watchService = null;
    private EventProcessor eventProcessor;

    DirectoryWatcher(EventProcessingQueue queue, String path) {
        this.queue = queue;
        this.path = path;
        try {
            this.watchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void putFileProductEvent(WatchEvent<?> event) {
        System.out.println(
                "Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");

        this.queue.putEventInQueue(new FileProductUpdateEvent("" + event.context()));
        if(this.eventProcessor != null) {
            this.eventProcessor.start();
        }
        else {
            System.out.println("Warn: no event processor registered");
        }
    }

    @Override
    public void run() {
        System.out.println("Starting directory scanner...");
        try {

            // TODO: filepath should be configuration
            Path path = Paths.get(this.path);

            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println("Debug: found a file change");
                    putFileProductEvent(event);
                }
                key.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void register(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    public WatchKey poll(long i, TimeUnit seconds) throws InterruptedException {
        return this.watchService.poll(i, seconds);
    }
}
