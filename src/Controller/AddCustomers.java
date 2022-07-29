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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomers implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private TextField customerIDTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<First_Level_Divisions> divisionsDropDownMenu;

    @FXML
    private Button saveCustomerButton;

    @FXML
    private TextField customerNameTextField;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private ComboBox<Countries> countriesDropDOwnMenu;

    @FXML
    void onActionSaveCustomer(ActionEvent event) throws IOException {
        String name = customerNameTextField.getText();
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String postalCode = postalCodeTextField.getText();

        First_Level_Divisions fld = divisionsDropDownMenu.getValue();

        CustomersDAO.addCustomer(name, address, phoneNumber, postalCode, fld.getDivisionID());

        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void onCountryCombo(ActionEvent actionEvent) {
        Countries countries = countriesDropDOwnMenu.getValue();
        divisionsDropDownMenu.setItems(FirstLevelDivisionsDAO.getAllFirstLevelDivisions(countries.getCountryID()));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countriesDropDOwnMenu.setItems(CountriesDAO.getAllCountries());
    }
}
