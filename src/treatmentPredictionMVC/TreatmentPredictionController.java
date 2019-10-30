package diploma.treatmentPredictionMVC;

import com.itextpdf.text.DocumentException;
import diploma.classes.Patient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreatmentPredictionController {
    private Patient patient;
    private TreatmentPredictionActivity tpActivity;
    @FXML
    private TextField idField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField middlenameField;
    @FXML
    private TextField uraField;
    @FXML
    private TextField sexField;
    @FXML
    private Button backBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private GridPane firstGridPane;
    @FXML
    private GridPane secondGridPane;
    @FXML
    private GridPane thirdGridPane;
    @FXML
    private GridPane resultGridPane;
    @FXML
    private TextField x1Field;
    @FXML
    private TextField x2Field;
    @FXML
    private TextField x3Field;
    @FXML
    private TextField x4Field;
    @FXML
    private TextField x5Field;
    @FXML
    private TextField x6Field;
    @FXML
    private TextField x7Field;
    @FXML
    private TextField x8Field;
    @FXML
    private TextField x9Field;
    @FXML
    private TextField x10Field;
    @FXML
    private TextField x11Field;
    @FXML
    private TextField x12Field;
    @FXML
    private TextField x13Field;
    @FXML
    private TextField x14Field;
    @FXML
    private TextField x15Field;
    @FXML
    private TextField k1Field;
    @FXML
    private TextField k2Field;
    @FXML
    private Label treatmentLabel;
    @FXML
    private Label resultLabel;

    public void initData(Patient patient) {
        this.patient = patient;
        setFields(patient);
    }

    private void setFields(Patient patient) {
        idField.setText(Integer.toString(patient.getPatientID()));
        surnameField.setText(patient.getPatientSurname());
        firstnameField.setText(patient.getPatientFirstname());
        middlenameField.setText(patient.getPatientMiddlename());
        uraField.setText(patient.getUraGroup());
        sexField.setText(patient.getSex());
    }

    @FXML
    public void initialize() {
        tpActivity = new TreatmentPredictionActivity();
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
    public void calculateTreatment() throws SQLException {
        ArrayList<Double> resultList = tpActivity.calculateTreatment(patient);
        if (resultList.size() != 0) {
            saveBtn.setDisable(false);
            resultLabel.setVisible(true);
            treatmentLabel.setVisible(true);
            resultGridPane.setVisible(true);
            switch (patient.getUraGroup()) {
                case "Поліартичний":
                    firstGridPane.setVisible(true);
                    x1Field.setText(Double.toString(resultList.get(0)) + " місяців");
                    x2Field.setText(Double.toString(resultList.get(1)));
                    x3Field.setText(Double.toString(resultList.get(2)) + " років");
                    if (Math.round(resultList.get(3)) == 0) {
                        k1Field.setText("Ні");
                    } else {
                        k1Field.setText("Так");
                    }
                    if (Math.round(resultList.get(4)) == 0) {
                        k2Field.setText("Ні");
                    } else {
                        k2Field.setText("Так");
                    }
                    break;
                case "Олігоартичний":
                    secondGridPane.setVisible(true);
                    resultLabel.setLayoutY(196);
                    resultGridPane.setLayoutY(224);
                    x4Field.setText(Double.toString(resultList.get(0)));
                    x5Field.setText(Double.toString(resultList.get(1)) + " місяців");
                    if (resultList.get(2) == 1.0) {
                        x6Field.setText("Є");
                    } else {
                        x6Field.setText("Немає");
                    }
                    x7Field.setText(Double.toString(resultList.get(3)));
                    x8Field.setText(Double.toString(resultList.get(4)) + " років");
                    if (Math.round(resultList.get(5)) == 0) {
                        k1Field.setText("Ні");
                    } else {
                        k1Field.setText("Так");
                    }
                    if (Math.round(resultList.get(6)) == 0) {
                        k2Field.setText("Ні");
                    } else {
                        k2Field.setText("Так");
                    }
                    break;
                default:
                    thirdGridPane.setVisible(true);
                    resultLabel.setLayoutY(256);
                    resultGridPane.setLayoutY(284);
                    x9Field.setText(Double.toString(resultList.get(0)));
                    if (resultList.get(1) == 1.0) {
                        x10Field.setText("Є");
                    } else {
                        x10Field.setText("Немає");
                    }
                    if (resultList.get(2) == 1.0) {
                        x11Field.setText("Потрібна");
                    } else {
                        x11Field.setText("Не потрібна");
                    }
                    x12Field.setText(Double.toString(resultList.get(3)));
                    x13Field.setText(Double.toString(resultList.get(4)));
                    x14Field.setText(Double.toString(resultList.get(5)));
                    x15Field.setText(Double.toString(resultList.get(6)));
                    if (Math.round(resultList.get(7)) == 0) {
                        k1Field.setText("Ні");
                    } else {
                        k1Field.setText("Так");
                    }
                    if (Math.round(resultList.get(8)) == 0) {
                        k2Field.setText("Ні");
                    } else {
                        k2Field.setText("Так");
                    }
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText("Рішення не було знайдено!");
            alert.setContentText("На жаль будь-яке лікування приводить до виникнення пошкоджень");
            alert.showAndWait();
        }
    }

    @FXML
    public void saveResult() throws DocumentException, IOException {
        ArrayList<String> resultList = getResult();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        Stage stage = new Stage();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            tpActivity.createPdfFile(resultList, file);
        }
    }

    private ArrayList<String> getResult() {
        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(surnameField.getText());
        resultList.add(firstnameField.getText());
        resultList.add(middlenameField.getText());
        resultList.add(uraField.getText());
        resultList.add(sexField.getText());
        switch (patient.getUraGroup()) {
            case "Поліартичний":
                resultList.add(x1Field.getText());
                resultList.add(x2Field.getText());
                resultList.add(x3Field.getText());
                break;
            case "Олігоартичний":
                resultList.add(x4Field.getText());
                resultList.add(x5Field.getText());
                resultList.add(x6Field.getText());
                resultList.add(x7Field.getText());
                resultList.add(x8Field.getText());
                break;
            default:
                resultList.add(x9Field.getText());
                resultList.add(x10Field.getText());
                resultList.add(x11Field.getText());
                resultList.add(x12Field.getText());
                resultList.add(x13Field.getText());
                resultList.add(x14Field.getText());
                resultList.add(x15Field.getText());
                break;
        }
        resultList.add(k1Field.getText());
        resultList.add(k2Field.getText());
        return resultList;
    }
}
