package com.ysrbdlgn.audioconverter.converter.listener;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.Obuffer;

/**
 * Created by ysrbdlgn on 15-Jun-17.
 */
public class ConvertFileProgressListener implements Converter.ProgressListener {

    private SimpleDoubleProperty progress;
    private SimpleStringProperty filePathProperty;

    public ConvertFileProgressListener() {
    }

    private void initialize() {
        if (progress == null) {
            progress = new SimpleDoubleProperty();
        }
    }

    @Override
    public void converterUpdate(int i, int i1, int i2) {}

    @Override
    public void parsedFrame(int i, Header header) {}

    @Override
    public void readFrame(int i, Header header) {}

    @Override
    public void decodedFrame(int i, Header header, Obuffer obuffer) {

        double freqInKHz = header.frequency() / 1000.0;

        progress.set(i / (header.framesize * freqInKHz));
    }

    @Override
    public boolean converterException(Throwable throwable) {
        return false;
    }

    public SimpleDoubleProperty progressProperty() {
        return progress;
    }

}
