package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import com.ysrbdlgn.audioconverter.common.entity.EFileType;
import com.ysrbdlgn.audioconverter.frontend.AudioConverterApplication;
import com.ysrbdlgn.audioconverter.frontend.service.FileTableService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class RibbonMenuControllerImpl implements RibbonMenuController {

    private FileTableService fileTableService;

    @Override
    public void addFileButtonPressed(ActionEvent actionEvent) {

        FileChooser chooser = new FileChooser();
        /* TODO: Initial directory should be the directory where app started.*/

        chooser.setInitialDirectory(new File("E:\\test_mp3"));
        addExtensionFilters(chooser);
        File file = chooser.showOpenDialog(AudioConverterApplication.getScene().getWindow());

        if(file == null)
            return;

        fileTableService.addFile(file);

    }

    @Override
    public void removeFileButtonPressed(ActionEvent actionEvent) {

        Button sourceButton = (Button) actionEvent.getSource();

        System.out.println(sourceButton.getId());

    }

    private void addExtensionFilters(FileChooser chooser){

        String extensionTemplate = "*.%s";

        // Add individual filters
        for(EFileType fileType : EFileType.values()) {
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                    fileType.getDescription(), String.format(extensionTemplate, fileType.getText()));
            chooser.getExtensionFilters().add(extFilter);
        }

        // Add "all audio files" item

        List<String> allExtensions = new ArrayList<>();
        for(EFileType fileType : EFileType.values()) {
            allExtensions.add(String.format(extensionTemplate, fileType.getText()));
        }
        FileChooser.ExtensionFilter allExtFilter = new FileChooser.ExtensionFilter("All Audio Files", allExtensions);
        chooser.getExtensionFilters().add(0, allExtFilter);

    }

    public void setFileTableService(FileTableService fileTableService) {
        this.fileTableService = fileTableService;
    }
}
