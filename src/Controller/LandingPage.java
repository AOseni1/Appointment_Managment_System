package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LandingPage implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private Button landingPageReportsButton;

    @FXML
    private Button landingPageAppointmentsButton;

    @FXML
    private Button landingPageCustomersButton;

    public Button exitButton;

    /**
     * This is for the button that takes the user to the Manage Customers page/view
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionLandingPageCustomersButton(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This is for the button that takes the user to the Appointment page/view
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionLandingPageAppointmentsButton(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AppointmentScreen.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This is for the button that takes the user to the Reports page/view
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionLandingPageReportsButton(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Reports.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This is for the button that exits the application. This includes a lambda expression
     * @param actionEvent
     */
    public void exitApplication(ActionEvent actionEvent) {
        //     lambda expression that exits the application
        exitButton.setOnAction(e -> System.exit(0));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
