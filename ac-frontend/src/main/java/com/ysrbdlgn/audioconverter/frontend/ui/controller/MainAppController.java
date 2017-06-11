package com.ysrbdlgn.audioconverter.frontend.ui.controller;

import com.ysrbdlgn.audioconverter.frontend.ui.FileTable;
import com.ysrbdlgn.audioconverter.frontend.ui.model.FileTableEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class MainAppController implements Initializable {

    @FXML private FileTable fileTable;
    @FXML private TableColumn<FileTableEntry, Integer> colID;
    @FXML private TableColumn<FileTableEntry, String> colFileName;
    @FXML private TableColumn<FileTableEntry, String> colTitle;
    @FXML private TableColumn<FileTableEntry, String> colDuration;
    @FXML private TableColumn<FileTableEntry, String> colState;

    private ObservableList<FileTableEntry> fileTableEntries;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colID.setCellValueFactory(new PropertyValueFactory<FileTableEntry, Integer>("id"));
        colFileName.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("path"));
        colTitle.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("title"));
        colDuration.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("duration"));
        colState.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("state"));
        colState.setCellValueFactory(new PropertyValueFactory<FileTableEntry, String>("state"));


        fileTableEntries = FXCollections.observableArrayList(
                new FileTableEntry(1, "C:", "dosya1", 126513)
        );

        fileTable.getItems().setAll(fileTableEntries);

    }
}
