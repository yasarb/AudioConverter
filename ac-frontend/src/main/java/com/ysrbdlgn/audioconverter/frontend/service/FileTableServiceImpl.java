package com.ysrbdlgn.audioconverter.frontend.service;

import com.ysrbdlgn.audioconverter.frontend.ui.FileTable;
import com.ysrbdlgn.audioconverter.frontend.ui.controller.MainSceneControllerImpl;
import com.ysrbdlgn.audioconverter.frontend.ui.model.FileTableEntry;

import java.io.File;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class FileTableServiceImpl implements FileTableService {

    private MainSceneControllerImpl mainSceneController;

    @Override
    public void addFile(File file) {

        FileTableEntry entry = null;
        // file -> file entry

        addFileEntry(entry);
    }

    @Override
    public void addFileEntry(FileTableEntry entry) {

        FileTable fileTable = mainSceneController.getFileTable();

        // check if file exists

        fileTable.getItems().add(entry);

    }

    public void setMainSceneController(MainSceneControllerImpl mainSceneController) {
        this.mainSceneController = mainSceneController;
    }
}
