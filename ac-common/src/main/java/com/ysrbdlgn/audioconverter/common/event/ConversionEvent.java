package com.ysrbdlgn.audioconverter.common.event;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public class ConversionEvent extends Event {

    private int fileID;

    public static final EventType<ConversionEvent> ANY
            = new EventType<>(Event.ANY, "CONVERSION_EVENT");

    public static final EventType<ConversionEvent> STARTED
            = new EventType<>(ConversionEvent.ANY, "CONVERSION_STARTED");

    public static final EventType<ConversionEvent> DONE
            = new EventType<>(ConversionEvent.ANY, "CONVERSION_DONE");

    public ConversionEvent(EventType<ConversionEvent> eventType) {
        super(eventType);
    }

    public ConversionEvent(EventType<ConversionEvent> eventType, int fileID) {
        super(eventType);
        this.fileID = fileID;
    }

    public int getFileID() {
        return fileID;
    }

    @Override
    public String toString() {
        return "ConversionEvent[" + getEventType() + ", fileID=" + getFileID() + "]";
    }
}
