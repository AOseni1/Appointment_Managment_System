package Controller;

import DAO.CountriesDAO;
import DAO.CustomersDAO;
import DAO.FirstLevelDivisionsDAO;
import Model.Countries;
import Model.First_Level_Divisions;
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
import java.util.ResourceBundle;

/**
 * Controls the Add Customer screen
 */
public class AddCustomers implements Initializable {

    Stage stage;
    Parent scene;

    /**
     * Text fields
     */
    @FXML
    private TextField customerIDTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField customerNameTextField;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private TextField addressTextField;

    /**
     * Buttons
     */
    @FXML
    private Button cancelButton;

    @FXML
    private Button saveCustomerButton;

    /**
     * Combo Boxes
     */
    @FXML
    private ComboBox<First_Level_Divisions> divisionsDropDownMenu;

    @FXML
    private ComboBox<Countries> countriesDropDOwnMenu;

    /**
     * Saves user input and returns to customer screen
     * @param event
     */
    @FXML
    void onActionSaveCustomer(ActionEvent event) throws IOException {
        /**
         * Gets user input from fields
         */
        String name = customerNameTextField.getText();
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String postalCode = postalCodeTextField.getText();
        First_Level_Divisions fld = divisionsDropDownMenu.getValue();


        /**
         * Checks to see if corresponding input is empty. If it is empty, an error box appears amd tells user what to complete.
         */

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Name");
            alert.showAndWait();
            return;
        }

        if (address.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter an Address");
            alert.showAndWait();
            return;
        }

        if (phoneNumber.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Phone Number");
            alert.showAndWait();
            return;
        }

        if (postalCode.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Postal Code");
            alert.showAndWait();
            return;
        }

        if (fld == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter Country/Division Information");
            alert.showAndWait();
            return;

        }

/**
 * Adds the new customer information into the database
 */
        CustomersDAO.addCustomer(name, address, phoneNumber, postalCode, fld.getDivisionID());


/**
 * Returns to the manage customers screen
 */
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Cancels actions and returns to manage customers screen
     * @param event
     * @throws IOException
     */

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /**
     * Populates the country and divisions combo boxes
     * @param actionEvent
     */
    public void onCountryCombo(ActionEvent actionEvent) {
        Countries countries = countriesDropDOwnMenu.getValue();
        divisionsDropDownMenu.setItems(FirstLevelDivisionsDAO.getAllFirstLevelDivisions(countries.getCountryID()));
    }

    /**
     * Initializes the controller
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countriesDropDOwnMenu.setItems(CountriesDAO.getAllCountries());
        customerIDTextField.setText("Auto Gen - Disabled");
        customerIDTextField.setDisable(true);

    }
}
