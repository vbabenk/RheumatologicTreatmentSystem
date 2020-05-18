// Copyright © 2019. All rights reserved.
// Authors: Vitalii Babenko
// Contacts: vbabenko2191@gmail.com

package diploma.loginMVC;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    private LoginActivity loginActivity;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginBtn;

    @FXML
    public void initialize() {
         loginActivity = new LoginActivity();
    }

    @FXML
    public void loginIntoSystem() throws IOException, SQLException {
        String login = loginField.getText();
        String password = passwordField.getText();
        boolean flag = loginActivity.checkAccount(login, password);
        if (flag) {
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/diploma/mainWindow/MainWindowView.fxml"));
            Parent root = loader.load();
            new JMetro(JMetro.Style.LIGHT).applyTheme(root);
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Головне меню");
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Виникла помилка при вході в аккаунт!");
            alert.setContentText("Логін або пароль введені неправильно, спробуйте ще.");
            alert.showAndWait();
        }
    }
}
