package Controller;

import DAO.CountriesDAO;
import DAO.CustomersDAO;
import DAO.FirstLevelDivisionsDAO;
import Model.Countries;
import Model.Customers;
import Model.First_Level_Divisions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditCustomers implements Initializable {
    Stage stage;
    Parent scene;

    public static Customers customerToModify;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField customerIDTextField;

    @FXML
    private ComboBox<First_Level_Divisions> divisionsDropDownMenu;

    @FXML
    private TextField customerNameTextField;

    @FXML
    private TextField postalCodeTextField;

    @FXML
    private Button updateCustomerButton;

    @FXML
    private ComboBox<Countries> countriesDropDOwnMenu;


    @FXML
    void onActionUpdateCustomer(ActionEvent event) throws IOException {

        String name = customerNameTextField.getText();
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String postalCode = postalCodeTextField.getText();
        int customer_ID = Integer.parseInt(customerIDTextField.getText());


        First_Level_Divisions fld = (First_Level_Divisions) divisionsDropDownMenu.getValue();



            CustomersDAO.editCustomer(name, address, phoneNumber, postalCode, fld.getDivisionID(),customer_ID);

        if(name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Name");
            alert.showAndWait();
            return;
        }

        if(address.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter an Address");
            alert.showAndWait();
            return;
        }

        if(phoneNumber.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Phone Number");
            alert.showAndWait();
            return;
        }

        if(postalCode.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter a Postal Code");
            alert.showAndWait();
            return;
        }

        if(fld == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setContentText("Enter Country Information");
            alert.showAndWait();
            return;
        }
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/ManageCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
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
            customerIDTextField.setText(String.valueOf(customerToModify.getCustomerID()));
            customerIDTextField.setDisable(true);

            customerNameTextField.setText(customerToModify.getCustomerName());
            addressTextField.setText(customerToModify.getAddress());
            phoneNumberTextField.setText(customerToModify.getPhoneNumber());
            postalCodeTextField.setText(customerToModify.getPostalCode());

            countriesDropDOwnMenu.setItems(CountriesDAO.getAllCountries());
            for(Countries c:countriesDropDOwnMenu.getItems()){
                if(c.getCountryID() == customerToModify.getCountryID()){
                    countriesDropDOwnMenu.setValue(c);
                    break;
                }
            }
        divisionsDropDownMenu.setItems(FirstLevelDivisionsDAO.getAllFirstLevelDivisions(customerToModify.getCountryID()));
            for(First_Level_Divisions f:divisionsDropDownMenu.getItems()){
                if(f.getDivisionID() == customerToModify.getDivisionID()){
                    divisionsDropDownMenu.setValue(f);
                    break;
                }
            }
    }
    }


