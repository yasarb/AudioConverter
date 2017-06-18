package com.ysrbdlgn.audioconverter.common.entity;

import com.ysrbdlgn.audioconverter.common.CryptoUtil;
import com.ysrbdlgn.audioconverter.common.EServiceLocator;
import com.ysrbdlgn.audioconverter.common.event.ConversionEvent;
import com.ysrbdlgn.audioconverter.common.event.EventBus;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class FileTableEntry {

    private final String DURATION_FORMAT = "HH:mm:ss";
    private SimpleIntegerProperty id;
    private SimpleStringProperty path;
    private SimpleStringProperty title;
    private SimpleStringProperty duration;
    private SimpleStringProperty state;
    private AudioTrack track;
    private String hash;

    public FileTableEntry(){
        this.id = new SimpleIntegerProperty(-1);
        this.path = new SimpleStringProperty("");
        this.title = new SimpleStringProperty("");
        this.duration = new SimpleStringProperty("");
        this.state = new SimpleStringProperty("");
        this.hash = "";

        initEvents();
    }

    private void initEvents() {
        EventBus eventBus = EServiceLocator.INSTANCE.getService(EventBus.class);
        eventBus.addEventHandler(ConversionEvent.STARTED, event -> {
            if(event.getFileEntry().getId() == getId()) {
                stateProperty().set(EFileConversionState.CONVERTING.getText());
            }
        });

        eventBus.addEventHandler(ConversionEvent.DONE, event -> {
            if(event.getFileEntry().getId() == getId()) {
                stateProperty().set(EFileConversionState.DONE.getText());
            }
        });
    }

    public FileTableEntry(int id, String path, String title, long duration) throws IOException, NoSuchAlgorithmException {
        this.id = new SimpleIntegerProperty(id);
        this.path = new SimpleStringProperty(path);
        this.title = new SimpleStringProperty(title);
        this.duration = new SimpleStringProperty(DurationFormatUtils.formatDuration(duration, DURATION_FORMAT));
        this.state = new SimpleStringProperty(EFileConversionState.READY.getText());
        this.hash = CryptoUtil.calculateSHA1(new File(path));
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
        this.duration.set(DurationFormatUtils.formatDuration(duration, DURATION_FORMAT));
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

    public void setState(EFileConversionState state) {
        this.state.set(state.getText());
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

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public AudioTrack getTrack() {
        return track;
    }

    public void setTrack(AudioTrack track) {
        this.track = track;
    }
}
