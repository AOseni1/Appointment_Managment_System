package Controller;

import DAO.AppointmentsDOA;
import DAO.UsersDAO;
import Model.Appointments;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login implements Initializable {
    public Label label;
    Stage stage;
    Parent scene;

    private ResourceBundle myRB = ResourceBundle.getBundle("Language/Language");

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label timeZoneLabel;

    @FXML
    private Button loginButton;


    @FXML
    void onActionLogin(ActionEvent event) throws IOException {
        String username = userNameTextField.getText();
        String password = passwordTextField.getText();
        int userIdentification = UsersDAO.userPasswordCheck(username, password);

        ObservableList<Appointments> getAllAppointments = AppointmentsDOA.getAllAppointments();
        LocalDateTime currTimeM15 = LocalDateTime.now().minusMinutes(15);
        LocalDateTime currTimeP15 = LocalDateTime.now().plusMinutes(15);
        LocalDateTime startTime;
        int getAppointmentID = 0;
        LocalDateTime displayTime = null;
        boolean appt15 = false;

        if (userIdentification > 0) {

            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        new File("login_activity.txt"),
                        true /* append = true */));
                pw.append("\t This is an valid login by " + username + " at " + Timestamp.valueOf(LocalDateTime.now()) +" \n");
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

            for (Appointments appointment : getAllAppointments) {
                startTime = appointment.getStart();
                if ((startTime.isAfter(currTimeM15) || startTime.isEqual(currTimeM15)) && (startTime.isBefore(currTimeP15) || (startTime.isEqual(currTimeP15)))) {
                    getAppointmentID = appointment.getAppointmentID();
                    displayTime = startTime;
                    appt15 = true;
                }
            }
            if (appt15 != false) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Appointment within 15 minutes: " + getAppointmentID + " at " + Timestamp.valueOf(displayTime));
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("No upcoming appointments");
                alert.showAndWait();
            }
        } else {
            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        new File("login_activity.txt"),
                        true /* append = true */));
                pw.append("\t This is an invalid login by " + username + " at" + Timestamp.valueOf(LocalDateTime.now()) +" \n");
                pw.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter correct login Information");
            alert.showAndWait();
            return;
        }
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(ZoneId.systemDefault().toString());
        System.out.println(myRB.getString("USERNAME"));
        System.out.println(myRB.getString("PASSWORD"));
        System.out.println(myRB.getString("LOGIN"));
        System.out.println(myRB.getString("TIMEZONE"));
        System.out.println(myRB.getString("ERROR"));
        System.out.println(myRB.getString("ERRORMESSAGE"));
    }
}
