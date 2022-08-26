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
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentScreen implements Initializable {

    Stage stage;
    Parent scene;

    /**
     * Columns for the appointment table
     */
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

    /**
     * Tableview fot the appointment table
     */

    @FXML
    private TableView<Appointments> appointmentsTable;

    /**
     * Buttons
     */

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

    /**
     * Radio Buttons and corresponding toggle group
     */
    @FXML
    private RadioButton viewByWeek;

    @FXML
    private RadioButton viewAll;

    @FXML
    private RadioButton viewByMonth;

    @FXML
    private ToggleGroup viewTG;

    /**
     * Takes user to the Add Appointment screen
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionAddAppointment(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Takes user to Modify Appointment screen but after first checking that an appointment was selected
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionModifyAppointment(ActionEvent event) throws IOException {
        Appointments a = appointmentsTable.getSelectionModel().getSelectedItem();
        if (a == null) {
            return;
        }

        ModifyAppointment.appointmentToModify = a;

        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ModifyAppointment.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /**
     * Deletes an appointment and displays information about the ID and Type of appointment that was deleted
     * Also displays an error message if the user did not make a selection
     * @param event
     */
    @FXML
    void onActionDeleteAppointment(ActionEvent event) {

        try {
            int deleteAppointmentID = appointmentsTable.getSelectionModel().getSelectedItem().getAppointmentID();
            String appointmentType = appointmentsTable.getSelectionModel().getSelectedItem().getType();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete?");
            alert.setContentText("Are you sure you want to delete?");
            Optional<ButtonType> result = alert.showAndWait();
            ButtonType button = result.orElse(ButtonType.CANCEL);

            if (button == ButtonType.OK) {
                alert.setContentText("Deleted appt ID: " + deleteAppointmentID + " Type: " + appointmentType);
                alert.showAndWait();
                AppointmentsDOA.deleteAppointment(deleteAppointmentID);
                appointmentsTable.setItems(AppointmentsDOA.getAllAppointments());
            } else {
                alert.setContentText("Did NOT delete appt ID: " + deleteAppointmentID + " Type: " + appointmentType);
                alert.showAndWait();
            }
            } catch(NullPointerException e) {
            if (appointmentsTable.getSelectionModel().getSelectedItem() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Please select an appointment to delete.");
                alert.showAndWait();
            }
        }catch (Exception e) {

        }

            }



    /**
     * Returns user to the landing page
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionReturnToMainScreen(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Initializes the controller class and sets the values into the table
     * @param url
     * @param resourceBundle
     */
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

    /**
     * Allows users to view all appointments when they click the view all radio button
     * @param actionEvent
     */
    public void onViewAll(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getAllAppointments());
    }

    /**
     * Allows users to view all appointments in the current month when they click the view month radio button
     * @param actionEvent
     */
    public void onMonth(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getMonthAppointments());
    }
    /**
     * Allows users to view all appointments in the current week when they click the view all week radio button
     * @param actionEvent
     */
    public void onWeek(ActionEvent actionEvent) {
        appointmentsTable.setItems(AppointmentsDOA.getWeekAppointments());
    }
}
