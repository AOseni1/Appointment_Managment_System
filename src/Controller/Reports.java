package Controller;

import DAO.AppointmentsDOA;
import DAO.ContactsDAO;
import DAO.CountriesDAO;
import Model.Appointments;
import Model.Contacts;
import Model.Countries;
import Model.Users;
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

public class Reports implements Initializable {

    public TableView <Appointments>apptTable;
    public TableColumn locationColumn;
    public TableColumn userColumn;
    public TableColumn contactCOlumn;
    Stage stage;
    Parent scene;

    @FXML
    private ComboBox<Countries> reportsCountryCountComboBox;

    @FXML
    private ComboBox<Contacts> contactComboBox;

    @FXML
    private TableColumn<?, ?> customerIDColumn;

    @FXML
    private TableColumn<?, ?> startDateColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> endDateColumn;

    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private ComboBox<?> reportsMonthComboBox;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private Button returnToMainMenuButton;

    @FXML
    private ComboBox<String> reportsTypeComboBox;

    @FXML
    private TableColumn<?, ?> appointmentIDColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

        @FXML
        void onActionReturnToMainMenu(ActionEvent event) throws IOException {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apptTable.setItems(AppointmentsDOA.getAllAppointments());
        appointmentIDColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        contactCOlumn.setCellValueFactory(new PropertyValueFactory<>("contactID"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startTimeDisplay"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTimeDisplay"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("dateDisplay"));
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));


        contactComboBox.setItems(ContactsDAO.getAllContacts());
        reportsCountryCountComboBox.setItems(CountriesDAO.getAllCountries());
        reportsTypeComboBox.setItems(Appointments.allTypes);

    }

    public void onContactCB(ActionEvent actionEvent) {
        Contacts c = contactComboBox.getValue();
        apptTable.setItems(AppointmentsDOA.getContactAppointments(c.getContactID()));
    }

    public void getTypes(ActionEvent actionEvent){
        reportsTypeComboBox.setItems(Appointments.allTypes);

        String a = reportsTypeComboBox.getValue();
        reportsTypeComboBox.setItems(Appointments.allTypes);

    }

    public void onCountriesCB(ActionEvent actionEvent){
            Countries c = reportsCountryCountComboBox.getValue();
        apptTable.setItems(AppointmentsDOA.getCountries(c.getCountryName()));
    }
}
