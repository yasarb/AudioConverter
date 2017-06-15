package com.ysrbdlgn.audioconverter.common.entity;

/**
 * Created by ysrbdlgn on 13-Jun-17.
 */
public class AudioTrack {

    private String title;
    private String bitRate;
    private String codec;
    private int channels;
    private int samplingRate;
    private String samplingRateStr;
    private long duration;
    private long fileSize;
    private String fileSizeStr;
    private String format;
    private String album;
    private String performer;
    private String encodedLibrary;
    private String path;

    public AudioTrack() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBitRate() {
        return bitRate;
    }

    public void setBitRate(String bitRate) {
        this.bitRate = bitRate;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public int getChannels() {
        return channels;
    }

    public void setChannels(int channels) {
        this.channels = channels;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(int samplingRate) {
        this.samplingRate = samplingRate;
    }

    public String getSamplingRateStr() {
        return samplingRateStr;
    }

    public void setSamplingRateStr(String samplingRateStr) {
        this.samplingRateStr = samplingRateStr;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSizeStr() {
        return fileSizeStr;
    }

    public void setFileSizeStr(String fileSizeStr) {
        this.fileSizeStr = fileSizeStr;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getEncodedLibrary() {
        return encodedLibrary;
    }

    public void setEncodedLibrary(String encodedLibrary) {
        this.encodedLibrary = encodedLibrary;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
