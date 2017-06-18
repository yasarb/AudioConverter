package com.ysrbdlgn.audioconverter.frontend;

import com.ysrbdlgn.audioconverter.common.EServiceLocator;
import com.ysrbdlgn.audioconverter.common.event.EventBus;
import com.ysrbdlgn.audioconverter.common.event.EventBusProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by ysrbdlgn on 10-Jun-17.
 */
public class AudioConverterApplication extends Application {

    private static ApplicationContext applicationContext;
    private static Scene scene;
    private EventBus eventBus;

    public AudioConverterApplication() {}

    public static void main(String[] args) {

        initServices();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        applicationContext = new ClassPathXmlApplicationContext(new String[]{"/spring/application-context-frontend.xml"});
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/audioconverterapp.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Parent root = loader.load();

        scene = new Scene(root);
        primaryStage.setTitle("<Title>");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static Scene getScene() {
        return scene;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static void initServices() {
        EServiceLocator.INSTANCE.registerService(EventBus.class, EventBusProvider.class);
    }
}
