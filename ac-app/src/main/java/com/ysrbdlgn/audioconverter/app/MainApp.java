package com.ysrbdlgn.audioconverter.app;

import com.ysrbdlgn.audioconverter.converter.Converter;
import com.ysrbdlgn.audioconverter.frontend.Frontend;


/**
 * Hello world!
 *
 */
public class MainApp {
    public static void main( String[] args ) {

        Converter c = new Converter();
        Frontend.main(args);

    }
}
