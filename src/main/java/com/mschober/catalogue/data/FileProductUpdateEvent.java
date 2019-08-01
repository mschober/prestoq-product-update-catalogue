package com.mschober.catalogue.data;

import java.io.File;
import java.nio.file.WatchEvent;
import java.util.List;

public class FileProductUpdateEvent implements ProductEvent {
    private final WatchEvent<?> watchEvent;
    private final String filename;
    private final String path;
    private final File changedFile;


    public FileProductUpdateEvent(WatchEvent<?> event, String path) {
        this.watchEvent = event;
        this.filename = getEventContext();
        this.path = path;
        this.changedFile = new File(path + "/" + filename);
    }

    public String getEventContext() {
        return this.watchEvent.context() + "";
    }

    public File getChangedFile() {
        return this.changedFile;
    }
}
