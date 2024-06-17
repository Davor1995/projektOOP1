package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class vehicleEditController {
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

    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

        brandField.setText(vehicle.getBrand());
        modelField.setText(vehicle.getModel());
        yearField.setText(Integer.toString(vehicle.getYear()));
        mileageField.setText(Integer.toString(vehicle.getMileage()));
        purchasePriceField.setText(Double.toString(vehicle.getPurchasePrice()));
        sellingPriceField.setText(Double.toString(vehicle.getSellingPrice()));
    }

    @FXML
    private void handleSave() {
        vehicle.setBrand(brandField.getText());
        vehicle.setModel(modelField.getText());
        vehicle.setYear(Integer.parseInt(yearField.getText()));
        vehicle.setMileage(Integer.parseInt(mileageField.getText()));
        vehicle.setPurchasePrice(Double.parseDouble(purchasePriceField.getText()));
        vehicle.setSellingPrice(Double.parseDouble(sellingPriceField.getText()));

        Stage stage = (Stage) brandField.getScene().getWindow();
        stage.close();
    }
}
