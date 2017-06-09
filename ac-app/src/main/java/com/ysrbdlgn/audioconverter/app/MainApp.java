package com.ysrbdlgn.audioconverter.app;

import com.ysrbdlgn.audioconverter.common.CommonTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class MainApp {


    public static void main( String[] args ) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"/spring/application-context-app.xml"});

        CommonTest comm = (CommonTest) applicationContext.getBean("commonTestBean");
        comm.display();


    }
}
