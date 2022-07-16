package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyAppointment implements Initializable {

    @FXML
    private TextField modifyAppointmentLocationTextField;

    @FXML
    private TextField modifyAppointmentContactIDTextField;

    @FXML
    private TextField modifyAppointmentEndTimeTextField;

    @FXML
    private Button cancelModifyAppointmentButton;

    @FXML
    private TextField modifyAppointmentIDTextField;

    @FXML
    private DatePicker modifyAppointmentStartDateCalendar;

    @FXML
    private TextField modifyAppointmentStartTimeTextField;

    @FXML
    private TextField modifyAppointmentTitleTextField;

    @FXML
    private TextField modifyAppointmentUserIDTextField;

    @FXML
    private DatePicker modifyAppointmentEndDateCalendar;

    @FXML
    private Button saveAppointmentButton;

    @FXML
    private TextField modifyAppointmentTypeTextField;

    @FXML
    private TextField modifyAppointmentDescriptionTextField;

    @FXML
    private TextField modifyAppointmentCustomerIDTextField;

    @FXML
    void onActionSaveAppointment(ActionEvent event) {

    }

    @FXML
    void onActionCancelModifyAppointment(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
