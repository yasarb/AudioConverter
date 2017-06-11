package com.ysrbdlgn.audioconverter.frontend.ui.model;

import com.ysrbdlgn.audioconverter.common.entity.EFileState;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.apache.commons.lang3.time.DurationFormatUtils;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class FileTableEntry {

    private final String DURATION_FORMAT = "HH:mm:ss";
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty path;
    private final SimpleStringProperty title;
    private final SimpleStringProperty duration;
    private final SimpleStringProperty state;

    public FileTableEntry(int id, String path, String title, long duration) {
        this.id = new SimpleIntegerProperty(id);
        this.path = new SimpleStringProperty(path);
        this.title = new SimpleStringProperty(title);
        this.duration = new SimpleStringProperty(DurationFormatUtils.formatDuration(duration, DURATION_FORMAT));
        this.state = new SimpleStringProperty(EFileState.READY.getText());
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPath() {
        return path.get();
    }

    public SimpleStringProperty pathProperty() {
        return path;
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDuration() {
        return duration.get();
    }

    public SimpleStringProperty durationProperty() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration.set(DurationFormatUtils.formatDurationHMS(duration));
    }

    public void setDuration(String duration) {
        this.duration.set(duration);
    }

    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
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
