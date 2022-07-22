package Model;

public class Countries {
    private int countryID;
    private String countryName;

    public Countries(int countryID, String countryName){
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /**
     *
     * @return countryID
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     *
     * @return country name
     */
    public String getCountryName() {
        return countryName;
    }
}
