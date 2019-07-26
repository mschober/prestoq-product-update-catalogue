package com.mschober.catalogue.reciever;

import com.mschober.catalogue.data.FileProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryWatcher implements ProductReceiver {
    private final EventProcessingQueue queue;

    // watches files changes and pushes events onto the queue
// https://www.baeldung.com/java-nio2-watchservice
//

    DirectoryWatcher(EventProcessingQueue queue) {
        this.queue = queue;
    }

    public void start() {
        System.out.println("Starting directory scanner...");
        try {
            WatchService watchService
                    = FileSystems.getDefault().newWatchService();

            // TODO: filepath should be configuration
            Path path = Paths.get("/tmp/productchanges");

            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
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

    private void putFileProductEvent(WatchEvent<?> event) {
        System.out.println(
                "Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");

        this.queue.putEventInQueue(new FileProductUpdateEvent("" + event.context()));

    }
}
