package com.ysrbdlgn.audioconverter.common;

import com.ysrbdlgn.audioconverter.common.entity.EFileState;
import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import com.ysrbdlgn.audioconverter.common.mediainfo.MediaInfoUtil;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class FileInfoUtil {

    public static FileTableEntry createFileEntry(File file) throws IOException, NoSuchAlgorithmException {

        FileTableEntry entry = new FileTableEntry();
        String hash = CryptoUtil.calculateSHA1(file);

        /* TODO: extract audio info */
        long duration = Long.parseLong(MediaInfoUtil.getAudioDuration(file));

        entry.setPath(file.getAbsolutePath());
        entry.setTitle("");
        entry.setDuration(duration);
        entry.setState(EFileState.READY);
        entry.setHash(hash);

        return entry;
    }

}
