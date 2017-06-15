package com.ysrbdlgn.audioconverter.common.mediainfo;

import com.ysrbdlgn.audioconverter.common.entity.AudioTrack;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ysrbdlgn on 12-Jun-17.
 */
public class MediaInfoUtil {

    /*
     * http://mediainfo.cvs.sourceforge.net/viewvc/mediainfo/MediaInfoLib/Source/Ressource/Text/Stream/
     */

    private final static MediaInfo INSTANCE;

    static {
        synchronized (MediaInfoUtil.class) {
            INSTANCE = new MediaInfo();
        }
    }

    public static AudioTrack collectInfo(File file) throws IOException {

        INSTANCE.open(file);
        AudioTrack track = new AudioTrack();
        track.setBitRate(INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "BitRate"));
        track.setCodec(INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "Codec/String"));
        track.setChannels(Integer.parseInt(
                INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "Channels")));
        track.setSamplingRate(Integer.parseInt(
                INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "SamplingRate")));
        track.setSamplingRateStr(INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "SamplingRate/String"));
        track.setTitle(INSTANCE.get(MediaInfo.StreamKind.General, 0, "Title"));
        track.setDuration(Long.parseLong(
                INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "Duration")));
        track.setFormat(INSTANCE.get(MediaInfo.StreamKind.General, 0, "Format"));
        track.setFileSize(Long.parseLong(
                INSTANCE.get(MediaInfo.StreamKind.General, 0, "FileSize")));
        track.setFileSizeStr(INSTANCE.get(MediaInfo.StreamKind.General, 0, "FileSize/String2"));
        track.setAlbum(INSTANCE.get(MediaInfo.StreamKind.General, 0, "Album"));
        track.setPerformer(INSTANCE.get(MediaInfo.StreamKind.General, 0, "Performer"));
        track.setEncodedLibrary(INSTANCE.get(MediaInfo.StreamKind.General, 0, "Encoded_Library"));
        track.setPath(file.getAbsolutePath());
        INSTANCE.close();

        return track;

    }

}
