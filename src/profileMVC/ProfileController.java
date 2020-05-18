// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko
// Contacts: vbabenko2191@gmail.com

package diploma.profileMVC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.io.IOException;
import java.sql.SQLException;


public class ProfileController {
    private ProfileActivity profileActivity;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField middlenameField;
    @FXML
    private ChoiceBox<String> uraBox;
    @FXML
    private ChoiceBox<String> x101Box;
    @FXML
    private TextField x102Field;
    @FXML
    private TextField x103Field;
    @FXML
    private ChoiceBox<String> x104Box;
    @FXML
    private ChoiceBox<String> x105Box;
    @FXML
    private ChoiceBox<String> x106Box;
    @FXML
    private ChoiceBox<String> x107Box;
    @FXML
    private ChoiceBox<String> x108Box;
    @FXML
    private ChoiceBox<String> x109Box;
    @FXML
    private ChoiceBox<String> x110Box;
    @FXML
    private ChoiceBox<String> x111Box;
    @FXML
    private ChoiceBox<String> x112Box;
    @FXML
    private ChoiceBox<String> x113Box;
    @FXML
    private ChoiceBox<String> x114Box;
    @FXML
    private TextField x115Field;
    @FXML
    private ChoiceBox<String> x116Box;
    @FXML
    private ChoiceBox<String> x117Box;
    @FXML
    private ChoiceBox<String> x118Box;
    @FXML
    private ChoiceBox<String> x119Box;
    @FXML
    private TextField x120Field;
    @FXML
    private TextField x121Field;
    @FXML
    private TextField x122Field;
    @FXML
    private TextField x123Field;
    @FXML
    private TextField x124Field;
    @FXML
    private TextField x125Field;
    @FXML
    private TextField x126Field;
    @FXML
    private TextField x127Field;
    @FXML
    private Button backBtn;
    @FXML
    private ChoiceBox<String> x1Box;
    @FXML
    private ChoiceBox<String> x2Box;
    @FXML
    private ChoiceBox<String> x3Box;
    @FXML
    private ChoiceBox<String> x4Box;
    @FXML
    private ChoiceBox<String> x5Box;

    @FXML
    public void initialize() {
        profileActivity = new ProfileActivity();
        ObservableList<String> uraList = FXCollections.observableArrayList("Поліартичний", "Олігоартичний", "Ентезит");
        ObservableList<String> sexList = FXCollections.observableArrayList("Жіноча", "Чоловіча");
        ObservableList<String> yesNoList = FXCollections.observableArrayList("Так", "Ні");
        ObservableList<String> somethingList = FXCollections.observableArrayList("Клічічно", "МРТ", "Нема");
        uraBox.setItems(uraList);
        x101Box.setItems(sexList);
        x104Box.setItems(yesNoList);
        x105Box.setItems(yesNoList);
        x106Box.setItems(yesNoList);
        x107Box.setItems(yesNoList);
        x108Box.setItems(yesNoList);
        x109Box.setItems(yesNoList);
        x110Box.setItems(yesNoList);
        x111Box.setItems(yesNoList);
        x112Box.setItems(yesNoList);
        x113Box.setItems(yesNoList);
        x114Box.setItems(yesNoList);
        x116Box.setItems(yesNoList);
        x117Box.setItems(yesNoList);
        x118Box.setItems(yesNoList);
        x119Box.setItems(yesNoList);
        x1Box.setItems(yesNoList);
        x2Box.setItems(yesNoList);
        x3Box.setItems(somethingList);
        x4Box.setItems(yesNoList);
        x5Box.setItems(yesNoList);
        uraBox.getSelectionModel().selectFirst();
        x101Box.getSelectionModel().selectFirst();
        x104Box.getSelectionModel().selectFirst();
        x105Box.getSelectionModel().selectFirst();
        x106Box.getSelectionModel().selectFirst();
        x107Box.getSelectionModel().selectFirst();
        x108Box.getSelectionModel().selectFirst();
        x109Box.getSelectionModel().selectFirst();
        x110Box.getSelectionModel().selectFirst();
        x111Box.getSelectionModel().selectFirst();
        x112Box.getSelectionModel().selectFirst();
        x113Box.getSelectionModel().selectFirst();
        x114Box.getSelectionModel().selectFirst();
        x116Box.getSelectionModel().selectFirst();
        x117Box.getSelectionModel().selectFirst();
        x118Box.getSelectionModel().selectFirst();
        x119Box.getSelectionModel().selectFirst();
        x1Box.getSelectionModel().selectFirst();
        x2Box.getSelectionModel().selectFirst();
        x3Box.getSelectionModel().selectFirst();
        x4Box.getSelectionModel().selectFirst();
        x5Box.getSelectionModel().selectFirst();
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
    public void addToDB() throws SQLException {
        String patientSurname = surnameField.getText();
        String patientFirstname = firstnameField.getText();
        String patientMiddlename = middlenameField.getText();
        String uraGroup = uraBox.getValue();
        String x101 = x101Box.getValue();
        String x102 = x102Field.getText();
        String x103 = x103Field.getText();
        String x104 = x104Box.getValue();
        String x105 = x105Box.getValue();
        String x106 = x106Box.getValue();
        String x107 = x107Box.getValue();
        String x108 = x108Box.getValue();
        String x109 = x109Box.getValue();
        String x110 = x110Box.getValue();
        String x111 = x111Box.getValue();
        String x112 = x112Box.getValue();
        String x113 = x113Box.getValue();
        String x114 = x114Box.getValue();
        String x115 = x115Field.getText();
        String x116 = x116Box.getValue();
        String x117 = x117Box.getValue();
        String x118 = x118Box.getValue();
        String x119 = x119Box.getValue();
        String x120 = x120Field.getText();
        String x121 = x121Field.getText();
        String x122 = x122Field.getText();
        String x123 = x123Field.getText();
        String x124 = x124Field.getText();
        String x125 = x125Field.getText();
        String x126 = x126Field.getText();
        String x127 = x127Field.getText();
        profileActivity.addNewPatient(patientSurname, patientFirstname, patientMiddlename, uraGroup, x101, x102, x103,
                x104, x105, x106, x107, x108, x109, x110, x111, x112, x113, x114, x115, x116, x117, x118, x119, x120, x121, x122,
                x123, x124, x125, x126, x127);
    }
}
