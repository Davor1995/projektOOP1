package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Optional;

public class mainController2 {
    @FXML
    private ListView<Vehicle> vehicleListView;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;

    private ObservableList<Vehicle> vehicleList;

    public void initialize() {
        vehicleList = FXCollections.observableArrayList(
            new Vehicle("Audi", "A3", 2010, 150000, 5000, 7000),
            new Vehicle("BMW", "320i", 2015, 80000, 10000, 12000)
        );
        vehicleListView.setItems(vehicleList);
    }

    @FXML
    private void handleEdit() {
        Vehicle selectedVehicle = vehicleListView.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vehicle_edit.fxml"));
                Parent root = loader.load();

                vehicleEditController controller = loader.getController();
                controller.setVehicle(selectedVehicle);

                Stage stage = new Stage();
                stage.setTitle("Fahrzeug bearbeiten");
                stage.setScene(new Scene(root));
                stage.showAndWait();

                vehicleListView.refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleDelete() {
        Vehicle selectedVehicle = vehicleListView.getSelectionModel().getSelectedItem();
        if (selectedVehicle != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Fahrzeug löschen");
            alert.setHeaderText(null);
            alert.setContentText("Sind Sie sicher, dass Sie das Fahrzeug löschen möchten?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                vehicleList.remove(selectedVehicle);
            }
        }
    }

    @FXML
    private void handleAdd() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/vehicle_add.fxml"));
            Parent root = loader.load();

            vehicleAddController controller = loader.getController();
            controller.setVehicleList(vehicleList);

            Stage stage = new Stage();
            stage.setTitle("Fahrzeug hinzufügen");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
