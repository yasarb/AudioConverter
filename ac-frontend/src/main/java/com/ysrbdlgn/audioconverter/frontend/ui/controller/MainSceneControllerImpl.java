package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import com.ysrbdlgn.audioconverter.frontend.AudioConverterApplication;
import com.ysrbdlgn.audioconverter.frontend.service.FileTableService;
import com.ysrbdlgn.audioconverter.frontend.ui.FileTable;
import com.ysrbdlgn.audioconverter.frontend.ui.model.FileTableEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class MainSceneControllerImpl implements MainSceneController {

    @FXML private FileTable fileTable;
    @FXML private TextField outputPathField;
    @FXML private TableColumn<FileTableEntry, Integer> colID;
    @FXML private TableColumn<FileTableEntry, String> colFileName;
    @FXML private TableColumn<FileTableEntry, String> colTitle;
    @FXML private TableColumn<FileTableEntry, String> colDuration;
    @FXML private TableColumn<FileTableEntry, String> colState;
    @FXML private RibbonMenuController ribbonMenuController;

    private FileTableService fileTableService;
    private ObservableList<FileTableEntry> fileTableEntries;

    public MainSceneControllerImpl() {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colID.setCellValueFactory(new PropertyValueFactory<FileTableEntry, Integer>("id"));
        colFileName.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("path"));
        colTitle.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("title"));
        colDuration.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("duration"));
        colState.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("state"));
        colState.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("state"));

        fileTableEntries = FXCollections.observableArrayList(
                new FileTableEntry(1, "C:", "dosya1", 126513),
                new FileTableEntry(2, "C:\\Program Files\\", "program files", 8451136)
        );

        fileTable.getItems().setAll(fileTableEntries);

    }

    @FXML
    public void browseButtonPressed(ActionEvent actionEvent) {

        DirectoryChooser chooser = new DirectoryChooser();
        /* TODO: Initial directory should be the directory where app started.*/
        chooser.setInitialDirectory(new File("C:\\"));
        File directory = chooser.showDialog(AudioConverterApplication.getScene().getWindow());

        if(directory == null)
            return;

        outputPathField.setText(directory.getAbsolutePath());
    }

    public FileTable getFileTable() {
        return fileTable;
    }

    public void setFileTableService(FileTableService fileTableService) {
        this.fileTableService = fileTableService;
    }

}
