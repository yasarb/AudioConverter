package com.ysrbdlgn.audioconverter.frontend.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class AudioConverterApp extends Application {

    public void run(String[] args) {
        Application.launch(AudioConverterApp.class, args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/audioconverterapp.fxml"));

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("<Title>");
        stage.setScene(scene);
        stage.show();

    }
}
