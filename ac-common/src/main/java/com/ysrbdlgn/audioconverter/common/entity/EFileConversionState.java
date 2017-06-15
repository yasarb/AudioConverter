package com.ysrbdlgn.audioconverter.common.entity;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public enum EFileConversionState {

    READY("Ready"),
    CONVERTING("Converting"),
    PLAYING("Playing"),
    DONE("Done"),
    NULL("");

    private String text;

    EFileConversionState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
