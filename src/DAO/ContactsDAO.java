package DAO;

import Model.Contacts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This creates an observable list for all contacts in the database.
 */
public class ContactsDAO {
    public static ObservableList<Contacts> getAllContacts(){
        ObservableList <Contacts> allContacts = FXCollections.observableArrayList();
        String sql = "SELECT * FROM contacts";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int contactID = rs.getInt("Contact_ID");
                String contact_Name = rs.getString("contact_Name");
                Contacts contacts = new Contacts(contactID, contact_Name);
                allContacts.add(contacts);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allContacts;
    }
}
