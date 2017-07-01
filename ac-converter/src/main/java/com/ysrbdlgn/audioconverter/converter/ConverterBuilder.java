package com.ysrbdlgn.audioconverter.converter;

import com.ysrbdlgn.audioconverter.common.entity.EFileType;
import com.ysrbdlgn.audioconverter.converter.listener.ConvertFileProgressListener;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ysrbdlgn on 18-Jun-17.
 */
public class ConverterBuilder {

    public static final String FFMPEG_PATH = "\"E:\\ffmpeg\\bin\\ffmpeg.exe\"";
    public static final String TIME_REGEX = "(0[0-9]|1[0-9]|2[0-3])(:([0-5][0-9])){2}\\.([0-9]{2})";

    private String inputFilePath;
    private String inputFileNameWithoutExtension;
    private String outputFolder;
    private EFileType type;
    private String command;
    private ConvertFileProgressListener progressListener;

    public ConverterBuilder input(String path) {
        inputFilePath = path;
        inputFileNameWithoutExtension = inputFilePath.substring(
                inputFilePath.lastIndexOf(File.separator) + 1,
                inputFilePath.lastIndexOf("."));
        return this;
    }

    public ConverterBuilder output(String path) {
        outputFolder = path;
        return this;
    }

    public ConverterBuilder outputType(EFileType type) {
        this.type = type;
        return this;
    }

    public ConverterBuilder progressListener(ConvertFileProgressListener listener) {
        this.progressListener = listener;
        return this;
    }

    public void convert() throws IOException {

        String[] command = {FFMPEG_PATH + " -y -i "
                + "\"" + inputFilePath + "\"" + " "
                + "\"" + outputFolder + inputFileNameWithoutExtension + "." + type.getText() + "\""};
        Process process = Runtime.getRuntime().exec(command);

        InputStream is = process.getErrorStream();
        BufferedInputStream bis = new BufferedInputStream(is);

        byte[] contents = new byte[2048];
        Pattern sizePattern = Pattern.compile(TIME_REGEX);
        Pattern durationPattern = Pattern.compile("Duration: " + TIME_REGEX);

        int bytesRead = 0;
        int totalDuration = 0;
        int convertedDuration;
        Matcher m;
        while((bytesRead = bis.read(contents)) != -1) {

            String s = (new String(contents, 0, bytesRead)).trim();

            if(totalDuration == 0)
                m  = durationPattern.matcher(s);
            else
                m = sizePattern.matcher(s);

            if(m.find()) {
                if (totalDuration == 0) {
                    totalDuration = hmsToInteger(m.group().substring(10));
                } else if (s.startsWith("size=")) {
                    convertedDuration = hmsToInteger(m.group());
                    progressListener.converterUpdate(convertedDuration, totalDuration);

                }
            }

        }



    }

    private static int hmsToInteger(String time) {

        int hour =   Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6, 8));
        int millis = Integer.parseInt(time.substring(9, 11));

        int timeLong = millis + (second * 100) + (minute * 100 * 60) + (hour * 60 * 60 * 100);
        return timeLong;

    }

}
