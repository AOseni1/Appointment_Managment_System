package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyCustomers implements Initializable {

    @FXML
    private Button ModifyCustomersSaveChangesButton;

    @FXML
    private TextField modifyCustomersCustomerNameTextField;

    @FXML
    private ChoiceBox<?> modifyCustomersDivisionsDropDownMenu;

    @FXML
    private TextField modifyCustomersCustomerIDTextField;

    @FXML
    private TextField modifyCustomerAddressTextField;

    @FXML
    private TextField modifyCustomersPhoneNumberTextField;

    @FXML
    private ChoiceBox<?> modifyCustomersCountriesDropDownMenu;

    @FXML
    private TextField modifyCustomersPostalCodeTextField;

    @FXML
    private Button ModifyCustomersDeleteChangesButton;

    @FXML
    private Button ModifyCustomersCancelButton;

    @FXML
    void onActionSaveChanges(ActionEvent event) {

    }

    @FXML
    void onActionDeleteCustomer(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
