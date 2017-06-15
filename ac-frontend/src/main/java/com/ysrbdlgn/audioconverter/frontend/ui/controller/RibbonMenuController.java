package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import javafx.event.ActionEvent;
import javazoom.jl.decoder.JavaLayerException;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public interface RibbonMenuController {
    void addFileButtonPressed(ActionEvent actionEvent);
    void removeFileButtonPressed(ActionEvent actionEvent);

    void convertButtonPressed(ActionEvent actionEvent) throws JavaLayerException;
}
