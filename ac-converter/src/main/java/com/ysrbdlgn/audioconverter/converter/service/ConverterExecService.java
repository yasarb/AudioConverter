package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.entity.EFileConversionState;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import com.ysrbdlgn.audioconverter.converter.listener.ConverterProgressListener;
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
    private ConverterProgressListener converterProgressListener;

    protected Task<T> createTask() {

        return new Task<T>() {

            protected T call() throws Exception {

                entry.setState(EFileConversionState.CONVERTING);
                converter.convert(entry.getPath(), destination, converterProgressListener);
                entry.setState(EFileConversionState.DONE);

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

    public void setConverterProgressListener(ConverterProgressListener converterProgressListener) {
        this.converterProgressListener = converterProgressListener;
    }
}
