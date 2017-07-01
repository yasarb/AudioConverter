package com.ysrbdlgn.audioconverter.settings.command;

import com.ysrbdlgn.audioconverter.common.command.GenericCommand;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ysrbdlgn on 01-Jul-17.
 */
public class OpenSettingsDialogCommandImpl implements GenericCommand {
    @Override
    public void execute() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/settingsdialog.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Audio Converter Settings");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
