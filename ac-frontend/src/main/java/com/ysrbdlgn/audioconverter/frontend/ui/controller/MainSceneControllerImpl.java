package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import com.ysrbdlgn.audioconverter.common.EServiceLocator;
import com.ysrbdlgn.audioconverter.common.event.ConversionEvent;
import com.ysrbdlgn.audioconverter.common.event.EventBus;
import com.ysrbdlgn.audioconverter.converter.listener.ConvertFileProgressListener;
import com.ysrbdlgn.audioconverter.converter.service.ConverterService;
import com.ysrbdlgn.audioconverter.frontend.AudioConverterApplication;
import com.ysrbdlgn.audioconverter.frontend.ui.FileTable;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class MainSceneControllerImpl implements MainSceneController {

    @FXML private FileTable<FileTableEntry> fileTable;
    @FXML private TextField outputPathField;
    @FXML private TableColumn<FileTableEntry, Integer> colID;
    @FXML private TableColumn<FileTableEntry, String> colFileName;
    @FXML private TableColumn<FileTableEntry, String> colTitle;
    @FXML private TableColumn<FileTableEntry, String> colDuration;
    @FXML private TableColumn<FileTableEntry, String> colState;
    @FXML private RibbonMenuController ribbonMenuController;
    @FXML private Label convertingFileNameLabel;
    @FXML private ProgressBar convertFileProgressBar;

    private ConvertFileProgressListener convertFileProgressListener;

    public MainSceneControllerImpl() {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colID.setCellValueFactory(new PropertyValueFactory<FileTableEntry, Integer>("id"));
        colFileName.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("path"));
        colTitle.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("title"));
        colDuration.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("duration"));
        colState.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("state"));

        convertFileProgressBar.progressProperty().bind(convertFileProgressListener.progressProperty());

        initEvents();
    }

    private void initEvents() {

        EventBus eventBus = EServiceLocator.INSTANCE.getService(EventBus.class);

        eventBus.addEventHandler(ConversionEvent.STARTED, event -> {
            Platform.runLater(() -> {
                convertingFileNameLabel.textProperty().setValue(event.getFileEntry().getPath());
            });
        });
        eventBus.addEventHandler(ConversionEvent.DONE, event -> {
            Platform.runLater(() -> {
                convertingFileNameLabel.textProperty().setValue("");
            });
        });
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

    public FileTable<FileTableEntry> getFileTable() { return fileTable; }

    public void setConverterService(ConverterService service) {
    }

    public void setConvertFileProgressListener(ConvertFileProgressListener convertFileProgressListener) {
        this.convertFileProgressListener = convertFileProgressListener;
    }
}
