package Controller;

import DAO.*;
import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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

        modifyAppointmentIDTextField.setText(String.valueOf(appointmentToModify.getCustomerID()));
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

