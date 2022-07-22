package Model;

public class Customers {


    private int customerID;
    private String customerName;
    private String address;
    private int phoneNumber;
    private String postalCode;
    private int divisionID;

    public Customers(int customerID, String customerName, String address, int phoneNumber, String postalCode, int divisionID){
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.divisionID = divisionID;
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
    public int getPhoneNumber() {
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
}
