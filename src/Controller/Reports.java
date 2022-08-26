package Controller;

import DAO.*;
import Model.Appointments;
import Model.Contacts;
import Model.Countries;
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

public class Reports implements Initializable {

    public TableView<Appointments> apptTable;
    public TableColumn locationColumn;
    public TableColumn userColumn;
    public TableColumn contactCOlumn;
    public TextField countTextField;
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
    private ComboBox<String> reportsMonthComboBox;

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

    /**
     * This is the button that returns the user to the Landing Page screen/view
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionReturnToMainMenu(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * This populates the table
     * @param url
     * @param resourceBundle
     */
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
        reportsMonthComboBox.setItems(Appointments.allMonths);


        contactComboBox.setItems(ContactsDAO.getAllContacts());
        reportsCountryCountComboBox.setItems(CountriesDAO.getAllCountries());
        reportsTypeComboBox.setItems(Appointments.allTypes);

    }

    /**
     * This populates the contacts combo box
     * @param actionEvent
     */
    public void onContactCB(ActionEvent actionEvent) {
        Contacts c = contactComboBox.getValue();
        apptTable.setItems(AppointmentsDOA.getContactAppointments(c.getContactID()));
    }

    /**
     * This populates the month and type combo boxes and makes sure that neither is null before generating a count
     * @param actionEvent
     * @return
     */
    public int monthTypeComboBox(ActionEvent actionEvent) {
        String monthnames = reportsMonthComboBox.getValue();
        String types = reportsTypeComboBox.getValue();

        if (monthnames == null || types == null) {
            return 0;
        } else
            countTextField.setText(String.valueOf(AppointmentsDOA.monthTypeCount(types, monthnames)));
            return AppointmentsDOA.monthTypeCount(types, monthnames);

    }

    /**
     * This populates the country combo box
     * @param actionEvent
     */
    public void country(ActionEvent actionEvent) {
        Countries c = reportsCountryCountComboBox.getValue();
        apptTable.setItems(AppointmentsDOA.country(String.valueOf(c.getCountryID())));

    }
}

