package com.ysrbdlgn.audioconverter.converter.service;

import com.ysrbdlgn.audioconverter.common.entity.FileTableEntry;
import javazoom.jl.decoder.JavaLayerException;

/**
 * Created by ysrbdlgn on 14-Jun-17.
 */
public interface ConverterService {

    public void convert(FileTableEntry source, String destination);

}
