package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
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
    private TableColumn<?, ?> manageCustomersCountryColumn;

    @FXML
    private TableColumn<?, ?> getManageCustomersCountryIDColumn;

    /**
     * Choice boexes
     */
    @FXML
    private ChoiceBox<?> manageCustomersCountriesDropDownMenu;
    @FXML
    private ChoiceBox<?> manageCustomersDivisionsDropDownMenu;


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

    }
}
