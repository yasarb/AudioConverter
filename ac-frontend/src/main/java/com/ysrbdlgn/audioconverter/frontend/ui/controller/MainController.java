package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;


/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class MainController {


    @FXML
    private Text actiontarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

}
