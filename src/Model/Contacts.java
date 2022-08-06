package Model;

public class Contacts {
    private int contactID;
    private String contact_Name;

    public Contacts(int contactID, String contact_Name){
        this.contactID = contactID;
        this.contact_Name = contact_Name;
    }

    /**
     *
     * @return contact ID
     */
    public int getContactID() {
        return contactID;
    }

    public String getContact_Name() {
        return contact_Name;
    }

    public String toString(){
        return (Integer.toString(contactID )) + " - " + contact_Name;
    }
    }

