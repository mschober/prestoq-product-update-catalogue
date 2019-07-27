package com.mschober.catalogue.receiver;

import com.google.common.io.Files;
import com.mschober.catalogue.queue.EventProcessingQueue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;

public class TestDirectoryWatcher {

    @Mock
    EventProcessingQueue eventProcessingQueue;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void testWatcher() throws InterruptedException, IOException {
        File tempDir = Files.createTempDir();

        DirectoryWatcher watcher = new DirectoryWatcher(eventProcessingQueue, tempDir.getAbsolutePath());
        watcher.run();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<?> future = executor.submit(watcher);
//        executor.shutdown();

//        Thread.sleep(50);
//        Files.touch(new File(tempDir.getAbsolutePath() + "/testfile"));
//        WatchKey poll = watcher.poll(2, TimeUnit.SECONDS);
//        System.out.println(poll);

//        Thread.sleep(15000);
    }

}