package com.mschober.catalogue.receiver;

import com.mschober.catalogue.queue.EventProcessingQueue;
import com.mschober.catalogue.queue.EventProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.nio.file.Path;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestDirectoryWatcher {

    DirectoryWatcher fileWatcher;

    @Mock
    EventProcessingQueue eventProcessingQueue;

    @Mock
    EventProcessor eventProcessor;

    private Path path;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWatcher() {
        doNothing().when(eventProcessor).start();
        DirectoryWatcher watcher = new DirectoryWatcher(eventProcessingQueue, "/tmp/productchanges");
        watcher.register(eventProcessor);
        watcher.run();
    }

}