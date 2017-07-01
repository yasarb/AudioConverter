package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.entity.EFileType;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import com.ysrbdlgn.audioconverter.converter.ConverterBuilder;
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

        ConverterBuilder builder = new ConverterBuilder()
                .input(entry.getPath())
                .output("E:\\test_mp3\\")
                .outputType(EFileType.WAV)
                .progressListener(convertFileProgressListener);

        return new ConverterTask<T>(builder, entry);

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
