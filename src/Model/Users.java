package Model;

public class Users {
    private int userID;
    private String userName;
    private String password;

    public Users(int userID, String userName, String password){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
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
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
