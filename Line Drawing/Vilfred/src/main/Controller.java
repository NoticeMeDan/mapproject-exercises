package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    Model model;

    public Canvas map;
    public GraphicsContext gc;

    void drawMap(){
        for(Line line : model.getLines()){
            gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model  = new Model();
        gc = map.getGraphicsContext2D();
        drawMap();
    }

    void zoom(double factor, double mouseX, double mouseY){
        for(Line line : model.getLines()){

        }
    }

    void mouseScroll(ScrollEvent e){
        if(e.getDeltaY()>0){
            zoom(1.1, e.getX(), e.getY());
        } else{
            zoom(0.9, e.getX(), e.getY());
        }
    }


    @FXML
    void keyPressed(KeyEvent e){
        System.out.println("Key pressed: " + e.getCharacter());

    }

    public void mouseClick(MouseEvent mouseEvent) {
        System.out.println("Hello");
    }
}
