package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.converter.listener.ConverterProgressListener;
import com.ysrbdlgn.audioconverter.common.entity.AudioTrack;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

import java.util.Observable;

/**
 * Created by ysrbdlgn on 14-Jun-17.
 */
public class ConverterServiceImpl extends Observable implements ConverterService {

    private Converter converter;
    private ConverterProgressListener converterProgressListener;

    public ConverterServiceImpl() {
    }

    private void initialize() {
        converter = new Converter();
    }

    @Override
    public void convert(String source, String destination) throws JavaLayerException {

        // TODO: Threading
        converterProgressListener.progressProperty().set(0.0);

        Service<Void> myService = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {

                        converter.convert(source, destination, converterProgressListener);

                        return null;
                    }
                };
            }
        };

        myService.restart();

    }

    @Override
    public void convert(AudioTrack source, String destination) throws JavaLayerException {
        convert(source.getPath(), destination);
    }


    public void setConverterProgressListener(ConverterProgressListener converterProgressListener) {
        this.converterProgressListener = converterProgressListener;
    }
}
