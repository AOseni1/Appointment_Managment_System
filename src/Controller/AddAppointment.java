package Controller;

import DAO.*;
import Model.*;
import com.mysql.cj.util.StringUtils;
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
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

/**
 * Controls the add appointments screen
 */
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
     * Date Picker
     */
    @FXML
    private DatePicker startDateCalendar;

    /**
     * Gets user input and saves to corresponding fields
     *
     * @param event
     */

    @FXML
    void onActionSave(ActionEvent event) throws IOException, DateTimeParseException, NullPointerException {
/**
 * Gets user input from fields
 */
        /**
         * Checks to see if corresponding input is empty. If it is empty, an error box appears amd tells user what to complete.
         */
        String title = titleTextField.getText();
        if (title.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Title");
            alert.showAndWait();
            return;
        }
        String description = descriptionTextField.getText();
        if (description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Description");
            alert.showAndWait();
            return;
        }
        String location = locationTextField.getText();
        if (location.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Location");
            alert.showAndWait();
            return;
        }
        String type = typeComboBOc.getValue();
        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a Type");
            alert.showAndWait();
            return;
        }
        Contacts contacts = contactIDComboBox.getValue();
        if (contacts == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select A Contact");
            alert.showAndWait();
            return;
        }
        Customers customers = customerIDComboBox.getValue();
        if (customers == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a Customer");
            alert.showAndWait();
            return;
        }
        Users users = userIDComboBox.getValue();
        if (users == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a User");
            alert.showAndWait();
            return;
        }

        LocalDate date = startDateCalendar.getValue();
        if (date == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Select a Date");
            alert.showAndWait();
            return;
        }

        if (startTimeTextField.getText().equals("") || !(startTimeTextField.getText() instanceof String)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setContentText("Enter a valid start time");
                alert.showAndWait();
                return;
        }
            LocalTime startTime = LocalTime.parse(startTimeTextField.getText());
            if (endTimeTextField.getText().equals("") || !(endTimeTextField.getText() instanceof String)) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setContentText("Enter a valid end time");
                alert.showAndWait();
                return;
            }
            LocalTime endTime = LocalTime.parse(endTimeTextField.getText());
            LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
            LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

            /**
             * checking for overlapping times and showing error if times overlap
             */
            if (AppointmentsDOA.checkForOverlap(startDateTime, endDateTime, customers.getCustomerID(), 0)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Overlap Error");
                alert.setContentText("Appointment overlaps with another");
                alert.showAndWait();
                return;
            }

            //business hours check(convert to eastern time)
//        ZonedDateTime openEST = ZonedDateTime.of(date, LocalTime.of(8, 00), ZoneId.of("America/New_York"));
//        ZonedDateTime closedEST = ZonedDateTime.of(date, LocalTime.of(22, 00), ZoneId.of("America/New_York"));
//        ZonedDateTime localOpen = openEST.withZoneSameInstant(ZoneId.of(TimeZone.getDefault().getID()));
//        ZonedDateTime localClosed = closedEST.withZoneSameInstant(ZoneId.of(TimeZone.getDefault().getID()));
//        LocalTime open = localOpen.toLocalTime();
//        LocalTime closed = localClosed.toLocalTime();
//
//        if (AppointmentsDOA.checkBuinessHours(localOpen, localClosed, open, closed)) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Time Error");
//            alert.setContentText("Choose a time when oour business is open");
//            alert.showAndWait();
//            return;

            /**
             * Adds the new appointment information into the database
             */
            AppointmentsDOA.addAppointment(title, description, location, type, Timestamp.valueOf(startDateTime), Timestamp.valueOf(endDateTime), customers.getCustomerID(), contacts.getContactID(), users.getUserID());

            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }


    /**
     * Cancels actions and returns to appointment screen
     * @param event
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Initializes the controller class
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerIDComboBox.setItems(CustomersDAO.getAllCustomers());
        userIDComboBox.setItems(UsersDAO.getAllUsers());
        contactIDComboBox.setItems(ContactsDAO.getAllContacts());
        typeComboBOc.setItems(Appointments.allTypes);
        appointmentIDTextField.setText("Auto Gen - Disabled");
        appointmentIDTextField.setDisable(true);
        startDateCalendar.setValue(LocalDate.now());



    }


}
