package com.ysrbdlgn.audioconverter.frontend.service;

import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;

import java.io.File;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public interface FileTableService {

    public void addFile(File file);
    public void addFileEntry(FileTableEntry entry);

}
