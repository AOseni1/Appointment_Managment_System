package Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Appointments {
    private int appointmentID;
    private String title;
    private String description;
    private String location;
    private Timestamp start;
    private Timestamp end;
    private String type;
    private int customerID;
    private int userID;
    private int contactID;

    public Appointments(int appointmentID, String title, String description, String location, Timestamp start, Timestamp end, String type, int customerID, int userID, int contactID){
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
     *
     * @return appointment ID
     */
    public int getAppointmentID() {
        return appointmentID;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return start date
     */
    public Timestamp getStart() {
        return start;
    }

    /**
     *
     * @return end date
     */
    public Timestamp getEnd() {
        return end;
    }

    /**
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return contact ID
     */
    public int getContactID() {
        return contactID;
    }
}
