package Controller;

import DAO.AppointmentsDOA;
import DAO.CountriesDAO;
import DAO.CustomersDAO;
import Model.Appointments;
import Model.Customers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentScreen implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TableColumn<?, ?> contactColumn;

    @FXML
    private TableColumn<?, ?> locationColumn;

    @FXML
    private TableColumn<?, ?> customerIDColumn;

    @FXML
    private TableColumn<?, ?> DateColumn;


    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;
    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> appointmentIDColumn;

    @FXML
    private TableColumn<?, ?> userIDColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private TableView<Appointments> appointmentsTable;

    @FXML
    private Button addAppointment;

    @FXML
    private Button modifyAppointment;

    @FXML
    private Button deleteAppointment;

    @FXML
    private Button report;

    @FXML
    private Button returnToMainScreenButton;

    @FXML
    private RadioButton viewByWeek;

    @FXML
    private RadioButton viewAll;

    @FXML
    private RadioButton viewByMonth;

    @FXML
    private ToggleGroup viewTG;


    @FXML
    void onActionAddAppointment(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionModifyAppointment(ActionEvent event) throws IOException {
        Appointments a = appointmentsTable.getSelectionModel().getSelectedItem();
        if(a == null){
            return;
        }

       ModifyAppointment.appointmentToModify = a;

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ModifyAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void onActionDeleteAppointment(ActionEvent event) {
        int deleteAppointmentID = appointmentsTable.getSelectionModel().getSelectedItem().getAppointmentID();
        AppointmentsDOA.deleteAppointment(deleteAppointmentID);
        appointmentsTable.setItems(AppointmentsDOA.getAllAppointments());
    }

    @FXML
    void onActionReturnToMainScreen(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        appointmentsTable.setItems(AppointmentsDOA.getAllAppointments());
        appointmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTimeDisplay"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTimeDisplay"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("dateDisplay"));
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
    }

    public void onViewAll(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getAllAppointments());
    }

    public void onMonth(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getMonthAppointments());
    }

    public void onWeek(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getWeekAppointments());
    }
}
