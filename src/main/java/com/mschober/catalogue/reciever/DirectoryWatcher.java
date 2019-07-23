package com.mschober.catalogue.reciever;

import com.mschober.catalogue.data.FileProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.SingleThreadedBlockingQueue;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryWatcher implements ProductReceiver {
    private final EventProcessingQueue queue;

    // watches files changes and pushes events onto the queue
// https://www.baeldung.com/java-nio2-watchservice
//

    public DirectoryWatcher(EventProcessingQueue queue) {
        if (queue != null) {
            this.queue = queue;
        }
        else {
            //TODO should this class own this? Dep. Inj?
            this.queue = new SingleThreadedBlockingQueue();
        }

    }

    public void start() throws InterruptedException, IOException {
        System.out.println("Starting directory scanner...");
        WatchService watchService
                = FileSystems.getDefault().newWatchService();

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
    }

    private void putFileProductEvent(WatchEvent<?> event) {
        System.out.println(
                "Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");

        this.queue.putEventInQueue(new FileProductUpdateEvent("" + event.context()));

    }
}
