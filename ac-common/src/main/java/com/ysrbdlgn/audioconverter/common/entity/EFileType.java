package com.ysrbdlgn.audioconverter.common.entity;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public enum EFileType {

    MP3("mp3","MP3 Files (*.mp3)"),
    WMA("wma","WMA Files (*.wma)"),
    WAV("wav","WAV Files (*.wav)"),
    AAC("aac","AAC Files (*.aac)"),
    M4A("m4a","M4A Files (*.m4a)"),
    AMR("amr","AMR Files (*.amr)"),
    OGG("ogg","OGG Files (*.ogg)");

    private String text;
    private String description;

    EFileType(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}
