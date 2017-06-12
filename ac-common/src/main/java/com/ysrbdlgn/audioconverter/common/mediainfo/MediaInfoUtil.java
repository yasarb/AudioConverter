package com.ysrbdlgn.audioconverter.common.mediainfo;

import java.io.File;
import java.io.IOException;

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

    public static String getAudioBitRate(File file) throws IOException {

        String bitRate;

        INSTANCE.open(file);
        bitRate = INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "BitRate",
                MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
        INSTANCE.close();

        return bitRate;
    }

    public static String getAudioDuration(File file) throws IOException {

        String duration;

        INSTANCE.open(file);
        duration = INSTANCE.get(MediaInfo.StreamKind.Audio, 0, "Duration",
                MediaInfo.InfoKind.Text, MediaInfo.InfoKind.Name);
        INSTANCE.close();

        return duration;
    }
}
