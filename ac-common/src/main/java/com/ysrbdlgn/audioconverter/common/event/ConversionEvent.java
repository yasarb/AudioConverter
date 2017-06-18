package com.ysrbdlgn.audioconverter.common.event;

import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public class ConversionEvent extends Event {

    private FileTableEntry fileTableEntry;

    public static final EventType<ConversionEvent> ANY
            = new EventType<>(Event.ANY, "CONVERSION_EVENT");

    public static final EventType<ConversionEvent> STARTED
            = new EventType<>(ConversionEvent.ANY, "CONVERSION_STARTED");

    public static final EventType<ConversionEvent> DONE
            = new EventType<>(ConversionEvent.ANY, "CONVERSION_DONE");

    public ConversionEvent(EventType<ConversionEvent> eventType) {
        super(eventType);
    }

    public ConversionEvent(EventType<ConversionEvent> eventType, FileTableEntry entry) {
        super(eventType);
        this.fileTableEntry = entry;
    }

    public FileTableEntry getFileEntry() {
        return fileTableEntry;
    }

    @Override
    public String toString() {
        return "ConversionEvent[" + getEventType() + ", FileTableEntry=" + getFileEntry() + "]";
    }
}
