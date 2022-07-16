package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField userIDTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField appointmentIDTextField;

    @FXML
    private TextField endTimeTextField;

    @FXML
    private DatePicker startDateCalendar;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField customerIDTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField startTimeTextField;

    @FXML
    private Button saveAppointmentButton;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField contactIDTextField;

    @FXML
    void onActionSave(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
