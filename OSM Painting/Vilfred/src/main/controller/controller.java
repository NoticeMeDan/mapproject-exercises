package javafxml_web;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.MyBrowser;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class Controller implements Initializable {

    @FXML
    private MyBrowser mybrowser;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}