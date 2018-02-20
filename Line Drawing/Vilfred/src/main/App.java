package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends javafx.application.Application {
    public static void main(String[]args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        primaryStage.setTitle("Line Drawing");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}
