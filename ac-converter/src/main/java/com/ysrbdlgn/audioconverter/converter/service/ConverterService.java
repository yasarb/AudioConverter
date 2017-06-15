package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.entity.AudioTrack;
import javazoom.jl.decoder.JavaLayerException;

/**
 * Created by ysrbdlgn on 14-Jun-17.
 */
public interface ConverterService {

    public void convert(String source, String destination) throws JavaLayerException;
    public void convert(AudioTrack source, String destination) throws JavaLayerException;

}
