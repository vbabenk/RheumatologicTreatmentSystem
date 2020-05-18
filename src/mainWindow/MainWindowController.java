// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko
// Contacts: vbabenko2191@gmail.com

package diploma.mainWindow;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.io.IOException;

public class MainWindowController {
    @FXML
    private Button addBtn;
    @FXML
    private Button predBtn;

    public void addNewPatient() throws IOException {
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/diploma/profileMVC/ProfileView.fxml"));
        Parent root = loader.load();
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Анкета нового пацієнта");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void predictTreatment() throws IOException {
        Stage stage = (Stage) predBtn.getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/diploma/patientChooserMVC/PatientChooserView.fxml"));
        Parent root = loader.load();
        new JMetro(JMetro.Style.LIGHT).applyTheme(root);
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Прогнозування лікування");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
