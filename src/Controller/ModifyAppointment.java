package Controller;

import DAO.*;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ModifyAppointment implements Initializable {
    public static Appointments appointmentToModify;
    Stage stage;
    Parent scene;

    @FXML
    private TextField modifyAppointmentLocationTextField;

    @FXML
    private TextField modifyAppointmentEndTimeTextField;

    @FXML
    private ComboBox<Users> userIDComboBox;

    @FXML
    private Button cancelModifyAppointmentButton;

    @FXML
    private TextField modifyAppointmentIDTextField;

    @FXML
    private DatePicker modifyAppointmentStartDateCalendar;

    @FXML
    private TextField modifyAppointmentStartTimeTextField;

    @FXML
    private ComboBox<Customers> customerIDComboBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField modifyAppointmentTitleTextField;

    @FXML
    private ComboBox<Contacts> contactIDComboBox;

    @FXML
    private Button deleteAppointmentButton;

    @FXML
    private Button saveAppointmentButton;

    @FXML
    private TextField modifyAppointmentTypeTextField;

    @FXML
    private TextField modifyAppointmentDescriptionTextField;


    @FXML
    void onActionUpdateAppointment(ActionEvent event) throws IOException {


        String title = modifyAppointmentTitleTextField.getText();
        String description = modifyAppointmentDescriptionTextField.getText();
        String location = modifyAppointmentLocationTextField.getText();
        String type = typeComboBox.getValue();
        Contacts contacts = contactIDComboBox.getValue();
        Customers customers = customerIDComboBox.getValue();
        Users users = userIDComboBox.getValue();
        LocalDate date = modifyAppointmentStartDateCalendar.getValue();
        LocalTime startTime = LocalTime.parse(modifyAppointmentStartTimeTextField.getText());
        LocalTime endTime = LocalTime.parse(modifyAppointmentEndTimeTextField.getText());
        LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
        int appointment_ID = Integer.parseInt(modifyAppointmentIDTextField.getText());

//        if (title.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Enter a Title");
//            alert.showAndWait();
//            return;
//        }
//
//        if (location.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Enter a Location");
//            alert.showAndWait();
//            return;
//        }
//        if (type == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Select a Type");
//            alert.showAndWait();
//            return;
//        }
//
//        if (contacts == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Select A Contact");
//            alert.showAndWait();
//            return;
//        }
//
//        if (customers == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Select s Customer");
//            alert.showAndWait();
//            return;
//        }
//
//        if (users == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Select a User");
//            alert.showAndWait();
//            return;
//        }
//
//        if (date == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Pick a Date");
//            alert.showAndWait();
//            return;
//        }
//
//        if (startTime == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Enter a Start Time");
//            alert.showAndWait();
//            return;
//        }
//
//        if (endTime == null) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Input Error");
//            alert.setContentText("Enter an End Time");
//            alert.showAndWait();
//            return;
//        }
        AppointmentsDOA.editAppointment(title, description, location, type, Timestamp.valueOf(startDateTime), Timestamp.valueOf(endDateTime), customers.getCustomerID(), contacts.getContactID(), users.getUserID(), appointment_ID);


        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    @FXML
    void onActionCancelModifyAppointment(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        modifyAppointmentIDTextField.setText(String.valueOf(appointmentToModify.getAppointmentID()));
        modifyAppointmentIDTextField.setDisable(true);

        modifyAppointmentTitleTextField.setText(appointmentToModify.getTitle());
        modifyAppointmentDescriptionTextField.setText(appointmentToModify.getDescription());
        modifyAppointmentLocationTextField.setText(appointmentToModify.getLocation());
        modifyAppointmentStartTimeTextField.setText(String.valueOf(LocalTime.from(appointmentToModify.getStart())));
        modifyAppointmentEndTimeTextField.setText(String.valueOf(LocalTime.from(appointmentToModify.getEnd())));
        modifyAppointmentStartDateCalendar.setValue(LocalDate.from(appointmentToModify.getDateDisplay()));
        typeComboBox.setItems(Appointments.allTypes);
        for(String t:typeComboBox.getItems()){
            if(t == appointmentToModify.getType());{
                typeComboBox.setValue(t);
                break;
            }
        }

        customerIDComboBox.setItems(CustomersDAO.getAllCustomers());
        for(Customers c:customerIDComboBox.getItems()){
            if(c.getCustomerID() == appointmentToModify.getCustomerID()){
                customerIDComboBox.setValue(c);
                break;
            }
        }

        userIDComboBox.setItems(UsersDAO.getAllUsers());
        for(Users u:userIDComboBox.getItems()){
            if(u.getUserID() == appointmentToModify.getUserID()){
                userIDComboBox.setValue(u);
                break;
            }
        }

        contactIDComboBox.setItems(ContactsDAO.getAllContacts());
        for(Contacts c:contactIDComboBox.getItems()){
            if(c.getContactID() == appointmentToModify.getContactID()){
                contactIDComboBox.setValue(c);
                break;
            }
        }

    }

    }

