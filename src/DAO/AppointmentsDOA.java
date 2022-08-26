package DAO;

import Model.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This creates an observable list for all appointments in the database.
 */
public class AppointmentsDOA {
    public static ObservableList<Appointments> getAllAppointments() {
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

    /**
     * Method that allows for appointment addition
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param customerID
     * @param userID
     * @param contactID
     */
    public static void addAppointment(String title, String description, String location, String type, Timestamp start, Timestamp end, int customerID, int userID, int contactID) {
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

    /**
     * Method that allows for appointment deletion
     * @param appointment_ID
     */
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

    /**
     * Method that allos the user to edit/modify appointments
     * @param title
     * @param description
     * @param location
     * @param type
     * @param start
     * @param end
     * @param customerID
     * @param userID
     * @param contactID
     * @param appointmentID
     */
    public static void editAppointment(String title, String description, String location, String type, Timestamp start, Timestamp end, int customerID, int userID, int contactID, int appointmentID) {
        String sql = "UPDATE Appointments SET Title = ?, Description = ?, Location = ?, Type = ?, Start = ?, End = ?, Customer_ID = ?, User_ID = ?, Contact_ID = ? WHERE Appointment_ID = ?;";
        try {
            System.out.println(appointmentID);
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
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Method that allows user to have appointment by week view
     * @return
     */
    public static ObservableList<Appointments> getWeekAppointments() {
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

    /**
     * Method that allows user to have appointment by month view
     * @return
     */
    public static ObservableList<Appointments> getMonthAppointments() {
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
     * Method that allows user to have a count of appointments by month and type
     * @param type
     * @param monthname
     * @return
     */

    public static int monthTypeCount(String type, String monthname) {
        String sql = "SELECT count(*) AS total FROM appointments WHERE type = ? AND monthname(start) = ?";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, monthname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int getTotal = rs.getInt("total");
                return getTotal;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    /**
     * lambda method filters through the appointment list and returning when a contact equals the contact ID
     *
     * @param contactID
     * @return
     */

//    /**
//     * lambda method filters through the appointment list and returning when a contact equals the contact ID
//     *
//     * @param contactID
//     * @return
//     */
    public static ObservableList<Appointments> getContactAppointments(int contactID) {
        ObservableList<Appointments> apptList = getAllAppointments();
        ObservableList<Appointments> filteredList = apptList.filtered(a -> {
            if (a.getContactID() == contactID) {
                return true;
            }
            return false;
        });
        return filteredList;

    }

    /**
     * Method that allows the user view reports by country
     * This is my additional report
     * @param customer
     * @return
     */
    public static ObservableList<Appointments> country(String customer) {
        ObservableList<Appointments> allAppointments = FXCollections.observableArrayList();
        String sql = "SELECT * FROM appointments WHERE customer_ID IN (SELECT customers.customer_ID FROM customers, first_level_divisions WHERE customers.division_ID = first_level_divisions.division_ID AND country_ID = ?)";
        ;
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, customer);

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
     * This is the method that checks for overlapping appointments
     */

    public static boolean checkForOverlap(LocalDateTime pStart, LocalDateTime pEnd, int customerID, int appointment_id) {
//        Go through each appointment for all appointments in the DB
        ObservableList<Appointments> App = getAllAppointments();
        for (Appointments a : App) {
            if (a.getCustomerID() != customerID) {
                continue;
            }
            if (a.getAppointmentID() == appointment_id) {
                continue;
            }
            LocalDateTime aStart = a.getStart();
            LocalDateTime aEnd = a.getEnd();

            if ((aStart.isAfter(pStart) || aStart.isEqual(pStart)) && aStart.isBefore(pEnd)) {
                return true;
            }
            if ((aEnd.isAfter(pStart)) && (aEnd.isBefore(pEnd) || (aEnd.isEqual(pEnd)))) {
                return true;
            }
            if ((aStart.isBefore(pStart) || aStart.isEqual(pStart)) && ((aEnd.isAfter(pEnd)) || (aEnd.isEqual(pEnd)))) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is the method that checks if an appointment is within the business hours
     * @param bOpen
     * @param bClosed
     * @param presentStartTime
     * @param presentEndTime
     * @return
     */
    public static boolean checkBusinessHours(LocalTime bOpen, LocalTime bClosed, LocalTime presentStartTime, LocalTime presentEndTime) {
//
        if (presentStartTime.isBefore(bOpen) || presentStartTime.isAfter(bClosed)) {
            return false;
        }
        if ((presentEndTime.isBefore(bOpen) || presentEndTime.isAfter(bClosed))) {
            return false;
        }
        return true;
    }

}


