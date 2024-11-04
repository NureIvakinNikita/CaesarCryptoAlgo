package com.example.caesarwithgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        String[] args = getParameters().getRaw().toArray(new String[0]); // Get command-line arguments
        controller.handleCommandLineArgs(args); // Pass them to the controller

        stage.show();
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            launch(args);
        } else {
            launch();
        }
    }
}