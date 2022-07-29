package DAO;

import Model.Appointments;
import Model.Countries;
import Model.Customers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class AppointmentsDOA {
    public static  ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sql = "SELECT * FROM appointments";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("appointment_ID");
                String title = rs.getString("title");
                String description = rs.getString("Description");
                String location = rs.getString("location");
                String type = rs.getString("Type");
                Timestamp start = rs.getTimestamp("Start");
                Timestamp end = rs.getTimestamp("End");
                int customerID = rs.getInt("customer_ID");
                int userID = rs.getInt("user_ID");
                int contactID = rs.getInt("contact_ID");


                Appointments appointments = new Appointments(appointmentID, title, description, location, start, end, type, customerID, userID, contactID);
                allAppointments.add(appointments);
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAppointments;
    }
}
