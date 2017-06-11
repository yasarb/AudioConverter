package com.ysrbdlgn.audioconverter.frontend.service;

import com.ysrbdlgn.audioconverter.common.CryptoUtil;
import com.ysrbdlgn.audioconverter.common.FileInfoUtil;
import com.ysrbdlgn.audioconverter.frontend.ui.FileTable;
import com.ysrbdlgn.audioconverter.frontend.ui.GenericDialog;
import com.ysrbdlgn.audioconverter.frontend.ui.controller.MainSceneControllerImpl;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class FileTableServiceImpl implements FileTableService {

    private MainSceneControllerImpl mainSceneController;

    @Override
    public void addFile(File file) {

        FileTableEntry entry = null;
        String hash = null;
        boolean isEntryExists;

        try {
            hash = CryptoUtil.calculateSHA1(file);

            isEntryExists = checkIfEntryExists(hash);

            if (!isEntryExists) {

                entry = FileInfoUtil.createFileEntry(file);
                addFileEntry(entry);

            } else {
                GenericDialog.showInfoDialog("File exists", "This file is already exists:\n" + file.getAbsolutePath());
            }

        } catch (IOException | NoSuchAlgorithmException e) {
            GenericDialog.showErrorDialog("Error", "An error occured while calculating hash of file.");
            e.printStackTrace();
        }
    }

    private boolean checkIfEntryExists(String hash) {

        boolean isExists = false;
        FileTable fileTable = mainSceneController.getFileTable();

        if (hash != null) {

            for (Object entry : fileTable.getItems()) {
                if (hash.equals(((FileTableEntry) entry).getHash())) {
                    isExists = true;
                    break;
                }
            }
        }

        return isExists;

    }

    @Override
    public void addFileEntry(FileTableEntry entry) {

        FileTable fileTable = mainSceneController.getFileTable();

        // check if file exists

        entry.setId(fileTable.getItems().size() + 1);
        fileTable.getItems().add(entry);

    }

    public void setMainSceneController(MainSceneControllerImpl mainSceneController) {
        this.mainSceneController = mainSceneController;
    }
}
