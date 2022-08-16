package DAO;

import Model.Appointments;
import Model.Countries;
import Model.Customers;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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


                Appointments appointments = new Appointments(appointmentID, title, description, location, start.toLocalDateTime(), end.toLocalDateTime(), type, customerID, userID, contactID);
                allAppointments.add(appointments);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAppointments;
    }

    public static void addAppointment(String title, String description, String location, String type, Timestamp start, Timestamp end, int customerID, int userID, int contactID ) {
        String sql = "INSERT into Appointments(appointment_ID, title, description, location, type, start, end, customer_ID, user_ID, contact_ID) values(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, location);
            ps.setString(4, type);
            ps.setTimestamp(5, start);
            ps.setTimestamp(6, end);
            ps.setInt(7, customerID);
            ps.setInt(8, userID);
            ps.setInt(9, contactID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteAppointment(int appointment_ID) {
        String sql1 = "DELETE FROM appointments WHERE Appointment_ID = ?;";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql1);
            ps.setInt(1, appointment_ID);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void editAppointment(int appointmentID, String title, String description, String location, String type, Timestamp start, Timestamp end, int customerID, int userID, int contactID) {
        String sql = "UPDATE appointments SET title = ?, description = ?, location = ?, type = ?, start = ?, end = ?, customer_ID = ?, user_ID = ?, contact_ID = ? WHERE appointment_ID = ?;";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, location);
            ps.setString(4, type);
            ps.setTimestamp(5, start);
            ps.setTimestamp(6, end);
            ps.setInt(7, customerID);
            ps.setInt(8, userID);
            ps.setInt(9, contactID);
            ps.setInt(10, appointmentID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static  ObservableList<Appointments> getWeekAppointments() {
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sql = "SELECT * FROM appointments WHERE yearweek(start) = yearweek(now())";
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


                Appointments appointments = new Appointments(appointmentID, title, description, location, start.toLocalDateTime(), end.toLocalDateTime(), type, customerID, userID, contactID);
                allAppointments.add(appointments);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAppointments;
    }

    public static  ObservableList<Appointments> getMonthAppointments() {
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sql = "SELECT * FROM appointments WHERE month(start) = month(now())";
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


                Appointments appointments = new Appointments(appointmentID, title, description, location, start.toLocalDateTime(), end.toLocalDateTime(), type, customerID, userID, contactID);
                allAppointments.add(appointments);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allAppointments;
    }

    /**
     * lambda method filters through the appointment list and returning when a contact equals the contact ID
     * @param contactID
     * @return
     */
    public static ObservableList<Appointments> getContactAppointments(int contactID) {
        ObservableList<Appointments> apptList = getAllAppointments();
        ObservableList<Appointments>filteredList = apptList.filtered(a -> {
            if(a.getContactID() == contactID){
                return true;
            }
            return false;
        });
        return filteredList;
    }

    /**
     * lambda method filters through the appointment list and returning when a contact equals the contact ID
     * @param type
     * @return
     */
    public static ObservableList<Appointments> getTypes(String type) {
        ObservableList<Appointments> typeList = getAllAppointments();
        ObservableList<Appointments>filteredList = typeList.filtered(a -> {
            if(a.getType() == type){
                return true;
            }
            return false;
        });
        return filteredList;
    }

    /**
     * lambda method filters through the appointment list and returning when a contact equals the contact ID
     * @param location
     * @return
     */
    public static ObservableList<Appointments> getCountries(String location) {
        ObservableList<Appointments> countryList = getAllAppointments();
        ObservableList<Appointments>filteredList = countryList.filtered(a -> {
            if(a.getLocation() == location){
                return true;
            }
            return false;
        });
        return filteredList;
    }
}
