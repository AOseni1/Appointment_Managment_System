package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
    private int customerID;
    private int userID;
    private int contactID;

    public static ObservableList<String> allTypes = FXCollections.observableArrayList("Tech Trance", "Progressive Trance", "Psytrance");
    public static ObservableList<String> allMonths = FXCollections.observableArrayList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" );


    public Appointments(int appointmentID, String title, String description, String location, LocalDateTime start, LocalDateTime end, String type, int customerID, int userID, int contactID){
        this.appointmentID = appointmentID;
        this.title = title;
        this.description = description;
        this.location= location;
        this.start = start;
        this.end = end;

        this.type = type;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     * This gets the appointment ID
     * @return appointment ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     * This gets the title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This gets the description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This gets the location
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * This gets the start date
     * @return start date
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * This gets the end date
     * @return end date
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * This gets the type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * This gets the customer ID
     * @return customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * This gets the user ID
     * @return user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * This gets the contact ID
     * @return contact ID
     */
    public int getContactID() {
        return contactID;
    }


    /**
     * This gets the date times
     * @return
     */
    public LocalDate getDateDisplay(){
     return start.toLocalDate();
    }

    public LocalTime getStartTimeDisplay(){
        return start.toLocalTime();
    }

    public LocalTime getEndTimeDisplay(){
        return end.toLocalTime();
    }
}
