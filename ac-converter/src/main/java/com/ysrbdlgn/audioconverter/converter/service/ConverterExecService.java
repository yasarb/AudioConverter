package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.EServiceLocator;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import com.ysrbdlgn.audioconverter.common.event.ConversionEvent;
import com.ysrbdlgn.audioconverter.common.event.EventBus;
import com.ysrbdlgn.audioconverter.converter.listener.ConvertFileProgressListener;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javazoom.jl.converter.Converter;

/**
 * Created by ysrbdlgn on 15-Jun-17.
 * Ref: http://fxexperience.com/2011/07/worker-threading-in-javafx-2-0/
 */
public class ConverterExecService<T> extends Service<T> {

    private FileTableEntry entry;
    private Converter converter;
    private String destination;
    private ConvertFileProgressListener convertFileProgressListener;

    protected Task<T> createTask() {

        return new Task<T>() {

            protected T call() throws Exception {
                EventBus eventBus = EServiceLocator.INSTANCE.getService(EventBus.class);

                eventBus.fireEvent(new ConversionEvent(ConversionEvent.STARTED, entry));
                converter.convert(entry.getPath(), destination, convertFileProgressListener);
                eventBus.fireEvent(new ConversionEvent(ConversionEvent.DONE, entry));

                return null;
            }
        };
    }

    public void setEntry(FileTableEntry entry) {
        this.entry = entry;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setConvertFileProgressListener(ConvertFileProgressListener convertFileProgressListener) {
        this.convertFileProgressListener = convertFileProgressListener;
    }
}
