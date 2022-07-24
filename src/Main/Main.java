package Main;

import DAO.CountriesDAO;
import DAO.CustomersDAO;
import DAO.JDBC;
import Model.Countries;
import Model.Customers;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        primaryStage.setTitle("Appointment Management System");
        primaryStage.setScene(new Scene(root, 575, 415));
        primaryStage.show();
    }


    public static void main(String[] args) {
        JDBC.openConnection();

            ObservableList<Customers> customerList = CustomersDAO.getAllCustomers();
            for (Customers customers : customerList) {
                System.out.println(customers.getCustomerID() + " - " + customers.getCustomerName() + " - " + customers.getAddress() + " - " + customers.getPostalCode() + " - " + customers.getPhoneNumber() + " - " + customers.getDivisionID());

            }


            launch(args);

            JDBC.closeConnection();
        }

    }
