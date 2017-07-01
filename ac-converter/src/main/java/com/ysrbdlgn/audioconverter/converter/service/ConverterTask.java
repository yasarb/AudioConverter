package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.EServiceLocator;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import com.ysrbdlgn.audioconverter.common.event.ConversionEvent;
import com.ysrbdlgn.audioconverter.common.event.EventBus;
import com.ysrbdlgn.audioconverter.converter.ConverterBuilder;
import javafx.concurrent.Task;

import java.io.IOException;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public class ConverterTask<T> extends Task<T> {

    private ConverterBuilder builder;
    private FileTableEntry entry;

    public ConverterTask(ConverterBuilder builder) {
        this.builder = builder;
    }

    public ConverterTask(ConverterBuilder builder, FileTableEntry entry) {
        this.builder = builder;
        this.entry = entry;
    }

    @Override
    protected T call() throws Exception {

        EventBus eventBus = EServiceLocator.INSTANCE.getService(EventBus.class);

        eventBus.fireEvent(new ConversionEvent(ConversionEvent.STARTED, entry));

        try {

            builder.convert();

        } catch (IOException e) {
            e.printStackTrace();
        }

        eventBus.fireEvent(new ConversionEvent(ConversionEvent.DONE, entry));

        return null;

    }
}
