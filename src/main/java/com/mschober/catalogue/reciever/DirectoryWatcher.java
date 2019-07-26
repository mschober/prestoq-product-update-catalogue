package com.mschober.catalogue.reciever;

import com.mschober.catalogue.data.FileProductUpdateEvent;
import com.mschober.catalogue.queue.EventProcessingQueue;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryWatcher implements Runnable {
    private final EventProcessingQueue queue;
    private List processors;

    // watches files changes and pushes events onto the queue
// https://www.baeldung.com/java-nio2-watchservice
//

    DirectoryWatcher(EventProcessingQueue queue) {
        this.queue = queue;
        this.processors = new LinkedList<FixedWidthProductFileReceiver.EventProcessor>();
    }

//    public void start() {
//        System.out.println("Starting directory scanner...");
//        try {
//            WatchService watchService
//                    = FileSystems.getDefault().newWatchService();
//
//            // TODO: filepath should be configuration
//            Path path = Paths.get("/tmp/productchanges");
//
//            path.register(
//                    watchService,
//                    StandardWatchEventKinds.ENTRY_CREATE,
//                    StandardWatchEventKinds.ENTRY_DELETE,
//                    StandardWatchEventKinds.ENTRY_MODIFY);
//
//            WatchKey key;
//            while ((key = watchService.take()) != null) {
//                for (WatchEvent<?> event : key.pollEvents()) {
//                    putFileProductEvent(event);
//                }
//                key.reset();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private void putFileProductEvent(WatchEvent<?> event) {
        System.out.println(
                "Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");

        this.queue.putEventInQueue(new FileProductUpdateEvent("" + event.context()));

    }

    @Override
    public void run() {
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
                    FixedWidthProductFileReceiver.EventProcessor eventProcessor = (FixedWidthProductFileReceiver.EventProcessor) this.processors.get(0);
                    eventProcessor.start();
                }
                key.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void register(FixedWidthProductFileReceiver.EventProcessor eventProcessor) {
        this.processors.add(eventProcessor);
    }
}
