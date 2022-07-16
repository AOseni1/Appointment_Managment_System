package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomers implements Initializable {
    @FXML
    private TextField customerIDTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private ChoiceBox<?> divisionsDropDownMenu;

    @FXML
    private Button saveCustomerButton;

    @FXML
    private TextField customerNameTextField;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private ChoiceBox<?> countriesDropDOwnMenu;

    @FXML
    void onActionSaveCustomer(ActionEvent event) {

    }

    @FXML
    void onActionCancel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
