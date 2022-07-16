package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    Stage stage;
    Parent scene;

    /**
     * Combo Boxes
     */
    @FXML
    private ComboBox<?> userIDComboBox;

    @FXML
    private ComboBox<?> customerIDComboBox;

    @FXML
    private ComboBox<?> typeComboBOc;

    @FXML
    private ComboBox<?> contactIDComboBox;

    /**
     * Labels
     */
    @FXML
    private Label titleLabel;

    /**
     * Text Fields
     */
    @FXML
    private TextField titleTextField;

    @FXML
    private TextField appointmentIDTextField;

    @FXML
    private TextField endTimeTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField startTimeTextField;

    /**
     * Buttons
     */
    @FXML
    private Button saveAppointmentButton;
    @FXML
    private Button cancelButton;

    /**
     *  Date Picker
     */
    @FXML
    private DatePicker startDateCalendar;

    /**
     * Saves user input and returns to appointment scrren
     * @param event
     */
    @FXML
    void onActionSave(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Cancels input and returns to appointment screen
     * @param event
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
