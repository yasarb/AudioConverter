package com.ysrbdlgn.audioconverter.common.entity;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public enum EFileState {

    READY("Ready"),
    PROCESSING("Processing"),
    PLAYING("Playing"),
    DONE("Done"),
    NULL("");

    private String text;

    EFileState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
