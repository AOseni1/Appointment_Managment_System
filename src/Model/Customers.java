package Model;

import DAO.FirstLevelDivisionsDAO;
import javafx.collections.ObservableList;

public class Customers {


    private int customerID;
    private String customerName;
    private String address;
    private String phoneNumber;
    private String postalCode;
    private int divisionID;
    private int countryID;

    public Customers(int customerID, String customerName, String address, String phoneNumber, String postalCode, int divisionID, int countryID){
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.divisionID = divisionID;
        this.countryID = countryID;
    }

    /**
     *
     * @return the customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @return postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @return division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * this gets the country ID
     * @return country ID
     */
    public int getCountryID() {
        return countryID;
    }

    public String toString(){
        return (customerID + " - " + customerName);
    }
}

