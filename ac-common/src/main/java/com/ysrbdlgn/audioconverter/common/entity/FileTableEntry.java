package com.ysrbdlgn.audioconverter.common.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class FileTableEntry {

    private SimpleIntegerProperty id;
    private SimpleStringProperty path;
    private SimpleStringProperty title;
    private SimpleStringProperty duration;
    private SimpleStringProperty state;

    public FileTableEntry(int id, String path, String title, long duration) {
        this.id = new SimpleIntegerProperty(id);
        this.path = new SimpleStringProperty(path);
        this.title = new SimpleStringProperty(title);
        this.duration = new SimpleStringProperty(DurationFormatUtils.formatDurationHMS(duration));
        this.state = new SimpleStringProperty(EFileState.READY.getValue());
    }

    @Override
    public String toString() {
        return "FileTableEntry{" +
                "id=" + id +
                ", path=" + path +
                ", title=" + title +
                ", duration=" + duration +
                ", state=" + state +
                '}';
    }
}
