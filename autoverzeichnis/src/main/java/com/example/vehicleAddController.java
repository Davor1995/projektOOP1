package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class vehicleAddController {

    @FXML
    private TextField herstellerField;

    @FXML
    private TextField modellField;

    @FXML
    private TextField leistungField;

    private Stage dialogStage;
    private Vehicle vehicle;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    // Erstellung des Fahrzeugs
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;

        herstellerField.setText(vehicle.getHersteller());
        modellField.setText(vehicle.getModell());
        leistungField.setText(Integer.toString(vehicle.getLeistung()));
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        vehicle.setHersteller(herstellerField.getText());
        vehicle.setModell(modellField.getText());
        vehicle.setLeistung(Integer.parseInt(leistungField.getText()));

        okClicked = true;
        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
