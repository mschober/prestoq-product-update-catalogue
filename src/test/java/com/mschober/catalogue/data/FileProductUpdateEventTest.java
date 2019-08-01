package com.mschober.catalogue.data;

import com.mschober.catalogue.data.event.FileProductUpdateEvent;
import org.junit.Test;

import java.io.File;
import java.nio.file.WatchEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileProductUpdateEventTest {

    @Test
    public void createFileProductEvent() {
        String fullPath = "/tmp/productchanges/testfile";
        File testFile = new File(fullPath);
        WatchEvent mock = mock(WatchEvent.class);
        when(mock.context()).thenReturn("testfile");
        FileProductUpdateEvent fileEvent = new FileProductUpdateEvent(mock, "/tmp/productchanges");
        assertTrue(testFile.equals(fileEvent.getChangedFile()));
    }
}