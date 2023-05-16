package com.internshala.JavaFXapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dell on 07-May-23.
 */
public class Controller implements Initializable{

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField textField;

    @FXML
    public Button btnConvert;


    private static final String C_TO_F_TEXT = "Celsius To Fahrenheit";
    private static final String F_TO_C_TEXT = "Fahrenheit To Celsius";

    private boolean isC_TO_F = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);

        choiceBox.setValue(C_TO_F_TEXT);


//        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                System.out.println(newValue);
//
//            }
//        });
        //Replace by Lambda
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(C_TO_F_TEXT)){
                isC_TO_F = true;       //if user has selected "Celsius To Fahrenheit"
            }else{
                isC_TO_F = false;      //else user has selected "Fahrenheit To Celsius"
            }
        });

        //Replace by Lambda
//        btnConvert.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Button Clicked!");
//            }
//        });
        btnConvert.setOnAction(event -> {
//            System.out.println("Button Clicked!");
              convert();
        });
    }

    private void convert() {
        String input = textField.getText();

        float enterTemperature = 0.0f;
        try {
            enterTemperature = Float.parseFloat(input);
        }catch (Exception exception){
            warnUser();
            return;
            //no code executed...
        }


        float newTemperature = 0.0f;
        if(isC_TO_F){
            newTemperature = (enterTemperature * 9 / 5) + 32;
        }else{
            newTemperature = (enterTemperature - 32) * 5 / 9;
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error occurred!");
        alert.setHeaderText("Invalid temperature entered!");
        alert.setContentText("Please entered a valid temperature!");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit = isC_TO_F? " F" : " C";

        System.out.println("The new temperature is: "+ newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: "+ newTemperature + unit);
        alert.show();
    }
}
