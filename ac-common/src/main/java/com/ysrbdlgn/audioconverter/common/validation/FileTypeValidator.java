package com.ysrbdlgn.audioconverter.common.validation;

import com.ysrbdlgn.audioconverter.common.entity.EFileType;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;

/**
 * Created by ysrbdlgn on 11-Jun-17.
 */
public class FileTypeValidator {

    private static final EFileType[] ACCEPTED_FILE_TYPES = EFileType.values();

    public static boolean isValidFileType(File file){

        boolean isValid = false;

        String extension = file.getName().substring(file.getName().lastIndexOf('.')+1);

        for(EFileType acceptedType : ACCEPTED_FILE_TYPES)
            isValid |= acceptedType.getText().equals(extension);

        return isValid;

    }

}
