package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {

    @FXML
    private TableColumn<?, ?> contactColumn;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> customerIDColumn;

    @FXML
    private Button addAppointment;

    @FXML
    private RadioButton viewByWeek;

    @FXML
    private Label timeZone;

    @FXML
    private ToggleGroup viewTG;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private RadioButton viewAll;

    @FXML
    private Button modifyAppointment;

    @FXML
    private Button addCustomer;

    @FXML
    private Button modifyCustomer;

    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private RadioButton viewByMonth;

    @FXML
    private Button report;

    @FXML
    private TableColumn<?, ?> appointmentIDColumn;

    @FXML
    private TableColumn<?, ?> userIDColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

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
