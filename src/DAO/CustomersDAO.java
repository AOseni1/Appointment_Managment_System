package DAO;

import Model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomersDAO {
    public static  ObservableList<Customers> getAllCustomers() {
        ObservableList<Customers> allCustomers = FXCollections.observableArrayList();
        String sql = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone, customers.Division_ID, Country_ID FROM customers, first_level_divisions WHERE customers.Division_ID = first_level_divisions.Division_ID";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerID = rs.getInt("Customer_ID");
                String customer_Name = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String postalCode = rs.getString("Postal_Code");
                String phone = rs.getString("Phone");
                int countryID = rs.getInt("country_ID");
                int division_ID = rs.getInt("division_ID");


                Customers customers = new Customers(customerID, customer_Name, address, postalCode, phone, division_ID, countryID);
                allCustomers.add(customers);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCustomers;
    }

    public static void addCustomer(String name, String address, String phoneNumber, String postalCode, int divisionID) {
    String sql = "INSERT into Customers(Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID) values(NULL, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, postalCode);
            ps.setString(4, phoneNumber);
            ps.setInt(5, divisionID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
