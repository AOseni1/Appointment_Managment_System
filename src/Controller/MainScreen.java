package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {

    @FXML
    private Button addCustomer;

    @FXML
    private Button modifyCustomer;

    @FXML
    private Button addAppointment;

    @FXML
    private RadioButton viewByMonth;

    @FXML
    private Button report;

    @FXML
    private RadioButton viewByWeek;

    @FXML
    private Label timeZone;

    @FXML
    private RadioButton viewAll;

    @FXML
    private Button modifyAppointment;

    @FXML
    void onActionAddCustomer(ActionEvent event) {

    }

    @FXML
    void onActionModifyCustomer(ActionEvent event) {

    }

    @FXML
    void onActionAddAppointment(ActionEvent event) {

    }

    @FXML
    void onActionModifyAppointment(ActionEvent event) {

    }

    @FXML
    void onActionReport(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
