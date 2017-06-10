package com.ysrbdlgn.audioconverter.common.entity;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public enum EFileState {

    READY("Ready"),
    PROCESSING("Processing"),
    PLAYING("Playing"),
    NULL("");

    private String value;

    EFileState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
