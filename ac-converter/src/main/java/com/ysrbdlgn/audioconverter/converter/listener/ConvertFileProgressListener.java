package com.ysrbdlgn.audioconverter.converter.listener;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by ysrbdlgn on 15-Jun-17.
 */
public class ConvertFileProgressListener {

    private SimpleDoubleProperty progress;
    private SimpleStringProperty filePathProperty;

    public ConvertFileProgressListener() {
    }

    private void initialize() {
        if (progress == null) {
            progress = new SimpleDoubleProperty();
        }
    }

    public void converterUpdate(int progressValue, int totalValue) {

        progress.set(progressValue * 1.0 / totalValue);

    }

    public SimpleDoubleProperty progressProperty() {
        return progress;
    }

}
