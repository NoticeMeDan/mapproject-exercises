package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import java.util.regex.*;

public class Controller implements Initializable{

    private Address a;
    private Model model;
    {
        try {
            model = new Model();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public TextArea output;
    public Text address;
    public TextField input;
    public Button enter;
    public AutoCompleteTextField streetInput;
    public AutoCompleteTextField zipcodeInput;
    public AutoCompleteTextField cityInput;

    public void enterCity(ActionEvent actionEvent) {
        address.setText(streetInput.getText());
    }

    public void enterPostal(ActionEvent actionEvent) {
        String currentString = zipcodeInput.getText();
        String finalString = currentString.substring(0,4);

        zipcodeInput.setText(finalString);
        cityInput.setText(currentString.substring(4));

    }

    public void enterStreet(ActionEvent actionEvent) {
        updateAddress(streetInput.getText());
    }

    public boolean isZipcode(String text){
        String regex = "(?<postcode>\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        String zipcode = text.substring(0,4);
        Matcher matcher = pattern.matcher(zipcode);

        if(matcher.matches()){
            return true;
        } else{
            return false;
        }
    }
    public void updateAddress(String text){
        address.setText("");
        address.setText(text);
    }
    public void addAddress(ActionEvent actionEvent) {
        a = Address.parse(streetInput.getText() + " " + cityInput.getText() + " " + zipcodeInput.getText());
        output.setText(a.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        streetInput.getEntries().addAll(model.getStreets());
        cityInput.getEntries().addAll(model.getCities());
        zipcodeInput.getEntries().addAll(model.getZipcode());
    }
}
