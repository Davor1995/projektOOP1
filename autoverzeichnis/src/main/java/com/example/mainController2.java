package com.example;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;



public class mainController2 {

    @FXML
    private TableView<Vehicle> vehicleTable;
    @FXML
    private TableColumn<Vehicle, String> herstellerColumn;
    @FXML
    private TableColumn<Vehicle, String> modellColumn;
    @FXML
    private TableColumn<Vehicle, Integer> leistungColumn;

    private ObservableList<Vehicle> vehicleData = FXCollections.observableArrayList();

    public mainController2() {
        vehicleData.add(new Vehicle("BMW", "X5", 300));
        vehicleData.add(new Vehicle("Audi", "A4", 250));
    }

    @FXML
    private void initialize() {
        // Spalten initialisieren 
        herstellerColumn.setCellValueFactory(cellData -> cellData.getValue().herstellerProperty());
        modellColumn.setCellValueFactory(cellData -> cellData.getValue().modellProperty());
        leistungColumn.setCellValueFactory(cellData -> cellData.getValue().leistungProperty().asObject());

        // Die Tabelle mit Daten füllen
        vehicleTable.setItems(vehicleData);
    }
        // Auto hinzufügen
    @FXML
    private void handleAdd() {
        Vehicle newVehicle = new Vehicle("Neuer Hersteller", "Neues Modell", 0);
        boolean okClicked = showVehicleAddDialog(newVehicle);
        if (okClicked) {
            vehicleData.add(newVehicle);
        }
    }
        // Auto bearbeiten
    @FXML
    private void handleEdit() {
        Vehicle selectedVehicle = vehicleTable.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            boolean okClicked = showVehicleEditDialog(selectedVehicle);
            if (okClicked) {
                refreshTable();
            } else {
                showAlert("Keine Auswahl", "Kein Fahrzeug ausgewählt", "Bitte wählen Sie ein Fahrzeug aus der Tabelle aus.");
            }
        }
    }
        // Auto löschen
    @FXML
    private void handleDelete() {
        int selectedIndex = vehicleTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            vehicleTable.getItems().remove(selectedIndex);
        }
    }
        // View Auto hinzufügen
    private boolean showVehicleAddDialog(Vehicle vehicle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vehicle_add.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Fahrzeug hinzufügen");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            vehicleAddController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setVehicle(vehicle);

            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
        // View Auto bearbeiten
    private boolean showVehicleEditDialog(Vehicle vehicle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vehicle_edit.fxml"));
            VBox page = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Fahrzeug bearbeiten");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            vehicleEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setVehicle(vehicle);

            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
        // Tabelle aktualisieren
    private void refreshTable() {
        if (vehicleTable.getItems() != null) {
            vehicleTable.refresh();
        }
    }
        // Fehlermeldung
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
        // Exit aus dem Programm
    @FXML
    private void handleExit() {
        Platform.exit();
    }
}
