package Controller;

import DAO.UsersDAO;
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
import java.time.ZoneId;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public Label label;
    Stage stage;
    Parent scene;

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

        if (userIdentification > 0) {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter correct login Information");
            alert.showAndWait();
            return;
        }
    }
        //get username and pass word from text fields
        //check for valid user from database (get userID or 0)
        //if valid user > 0
        //then write valid login to a file
        //15 min check - (similar to overlap check - start time of any appt = now + now + 15 min for that user id - exclude others - - don't find any then a pop up to say that you didn't find anything - write a seperate method for the 15 min check)
        //switch screens
        //else - a bad login case/not valid user
        //write bag login to a file
        //pop up an invalid login message in eng or fr




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    label.setText(ZoneId.systemDefault().toString());
    }
}
