package Controller;

import DAO.*;
import Model.*;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {

    Stage stage;
    Parent scene;

    /**
     * Combo Boxes
     */
    @FXML
    private ComboBox<Users> userIDComboBox;

    @FXML
    private ComboBox<Customers> customerIDComboBox;

    @FXML
    private ComboBox<String> typeComboBOc;

    @FXML
    private ComboBox<Contacts> contactIDComboBox;

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

        String title = titleTextField.getText();
        String description = descriptionTextField.getText();
        String location = locationTextField.getText();
        String type = typeComboBOc.getValue();
        Contacts contacts = contactIDComboBox.getValue();
        Customers customers = customerIDComboBox.getValue();
        Users users = userIDComboBox.getValue();
        LocalDate date = startDateCalendar.getValue();
        LocalTime startTime = LocalTime.parse(startTimeTextField.getText());
        LocalTime endTime = LocalTime.parse(endTimeTextField.getText());
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

        if (title.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Title");
            alert.showAndWait();
            return;
        }

        if (location.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Location");
            alert.showAndWait();
            return;
        }
        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a Type");
            alert.showAndWait();
            return;
        }

        if (contacts == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select A Contact");
            alert.showAndWait();
            return;
        }

        if (customers == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select s Customer");
            alert.showAndWait();
            return;
        }

        if (users == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a User");
            alert.showAndWait();
            return;
        }

        if (date == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Pick a Date");
            alert.showAndWait();
            return;
        }

        if (startTime == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Start Time");
            alert.showAndWait();
            return;
        }

        if (endTime == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter an End Time");
            alert.showAndWait();
            return;
        }
        AppointmentsDOA.addAppointment (title, description, location, type, Timestamp.valueOf(startDateTime), Timestamp.valueOf(endDateTime), customers.getCustomerID(), contacts.getContactID(), users.getUserID());

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
        customerIDComboBox.setItems(CustomersDAO.getAllCustomers());
        userIDComboBox.setItems(UsersDAO.getAllUsers());
        contactIDComboBox.setItems(ContactsDAO.getAllContacts());
        typeComboBOc.setItems(Appointments.allTypes);
        appointmentIDTextField.setText("Auto Gen - Disabled");
        appointmentIDTextField.setDisable(true);
    }


}
