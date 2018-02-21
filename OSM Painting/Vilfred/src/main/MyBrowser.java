package main;

import java.net.URL;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class MyBrowser extends Region{
    HBox toolbar;

    private WebView webView = new WebView();
    private WebEngine webEngine = this.webView.getEngine();

    public MyBrowser(){

        final URL urlGoogleMaps = getClass().getResource("../resources/fxml/index.html");
        this.webEngine.load(urlGoogleMaps.toExternalForm());

        this.getChildren().add(this.webView);

    }
}
