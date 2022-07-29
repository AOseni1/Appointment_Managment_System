package Controller;

import DAO.CountriesDAO;
import DAO.CustomersDAO;
import DAO.FirstLevelDivisionsDAO;
import Model.Countries;
import Model.Customers;
import Model.First_Level_Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ManageCustomers implements Initializable {


    Stage stage;
    Parent scene;

    /**
    *Buttons
    **/
    @FXML
    private Button ModifyCustomersSaveChangesButton;

    @FXML
    private Button manageCustomersDeleteButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button addNewCustomerButton;

    @FXML
    private Button ModifyCustomersCancelButton;

    @FXML
    private Button manageCustomersEditButton;

    /**
     * Text Fields
     */

    @FXML
    private TextField manageCustomersPostalCodeTextField;

    @FXML
    private TextField manageCustomersCustomerIDTextField;

    @FXML
    private TextField manageCustomersCustomerNameTextField;

    @FXML
    private TextField manageCustomerAddressTextField;

    @FXML
    private TextField manageCustomersPhoneNumberTextField;

    /**
     * Table Columns
     */

    @FXML
    private TableColumn<?, ?> manageCustomersPostalCodeColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersDivisionColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersAddressColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersCustomerIDColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersCustomerNameColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersPhoneNumberColumn;

    @FXML
    private TableColumn<?, ?> manageCustomersCountryIDColumn;


    public TableView <Customers> manageCustomersTable;
    /**
     * Choice boxes
     */
    @FXML
    private ComboBox<Countries> manageCustomersCountriesDropDownMenu;
    @FXML
    private ComboBox<First_Level_Divisions> manageCustomersDivisionsDropDownMenu;


    /**
     * Saves what is input into the text fields into the table
     * @param event
     * @throws IOException
     */

    @FXML
    void onActionSaveChanges(ActionEvent event) throws IOException {

    }

    /**
     * Cancels the selection
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {

    }

    /**
     * Shifts to the add customer view
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionAddNewCustomer(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/AddCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Returns user to the landing page
     * @param event
     * @throws IOException
     */
    @FXML
    void onActionMainMenu(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }



    @FXML
    void onActionManageCustomersDelete(ActionEvent event) {

    }

    @FXML
    void onActionManageCustomersEdit(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
manageCustomersTable.setItems(CustomersDAO.getAllCustomers());
manageCustomersCountriesDropDownMenu.setItems(CountriesDAO.getAllCountries());

        manageCustomersCustomerIDColumn.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        manageCustomersCustomerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        manageCustomersAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        manageCustomersPostalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        manageCustomersPhoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        manageCustomersDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("divisionID"));
        manageCustomersCountryIDColumn.setCellValueFactory(new PropertyValueFactory<>("countryID"));


    }


    public void onCountryCombo(ActionEvent actionEvent) {
        Countries countries = manageCustomersCountriesDropDownMenu.getValue();
        manageCustomersDivisionsDropDownMenu.setItems(FirstLevelDivisionsDAO.getAllFirstLevelDivisions(countries.getCountryID()));
               }


    public void onDivisionsCombo(ActionEvent actionEvent) {
        First_Level_Divisions fld = manageCustomersDivisionsDropDownMenu.getValue();
    }
}
