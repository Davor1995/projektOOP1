package com.example;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class vehicleAddController {
    @FXML
    private TextField brandField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField mileageField;
    @FXML
    private TextField purchasePriceField;
    @FXML
    private TextField sellingPriceField;

    private ObservableList<Vehicle> vehicleList;

    public void setVehicleList(ObservableList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @FXML
    private void handleAdd() {
        Vehicle newVehicle = new Vehicle(
                brandField.getText(),
                modelField.getText(),
                Integer.parseInt(yearField.getText()),
                Integer.parseInt(mileageField.getText()),
                Double.parseDouble(purchasePriceField.getText()),
                Double.parseDouble(sellingPriceField.getText())
        );

        vehicleList.add(newVehicle);

        Stage stage = (Stage) brandField.getScene().getWindow();
        stage.close();
    }
}
