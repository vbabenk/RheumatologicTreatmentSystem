// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko
// Contacts: vbabenko2191@gmail.com

package diploma.patientChooserMVC;

import diploma.classes.Patient;
import diploma.treatmentPredictionMVC.TreatmentPredictionController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.io.*;
import java.sql.SQLException;

public class PatientChooserController {
    private Patient patient;
    @FXML
    private TableView<Patient> patientsTable;
    @FXML
    private TableColumn<ObservableList<Patient>, String> idColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> surnameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> firstnameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> middlenameColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> uraColumn;
    @FXML
    private TableColumn<ObservableList<Patient>, String> sexColumn;
    @FXML
    private TextField searchField;
    @FXML
    private Button selectBtn;
    @FXML
    private Button backBtn;

    private void addElementsToTable() {
        ObservableList<Patient> data = FXCollections.observableArrayList(patient);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("patientSurname"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<>("patientFirstname"));
        middlenameColumn.setCellValueFactory(new PropertyValueFactory<>("patientMiddlename"));
        uraColumn.setCellValueFactory(new PropertyValueFactory<>("uraGroup"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        patientsTable.setItems(data);
    }

    @FXML
    public void searchPatient() throws SQLException {
        PatientChooserActivity logic = new PatientChooserActivity();
        String something = searchField.getText();
        patient = logic.loadPatient(something);
        addElementsToTable();
    }

    @FXML
    public void backToMenu() throws IOException {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/diploma/mainWindow/MainWindowView.fxml"));
        Parent root = loader.load();
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Головне меню");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void choosePatient() throws IOException {
        Patient selectedPatient = patientsTable.getSelectionModel().getSelectedItem();
        try {
            Stage stage = (Stage) selectBtn.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/diploma/treatmentPredictionMVC/TreatmentPredictionView.fxml"));
            Parent root = loader.load();
            new JMetro(JMetro.Style.LIGHT).applyTheme(root);
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Прогноз лікування");
            stage.setScene(new Scene(root));
            TreatmentPredictionController controller = loader.getController();
            controller.initData(selectedPatient);
            stage.show();
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Увага");
            alert.setHeaderText("Виникла помилка!");
            alert.setContentText("Виберіть пацієнта, будь ласка!");
            alert.showAndWait();
        }
    }
}
