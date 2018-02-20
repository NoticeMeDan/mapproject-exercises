package main.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class view extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/ui.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.setTitle("OSM Painting");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
