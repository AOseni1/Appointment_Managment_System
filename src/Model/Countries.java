package Model;

import javafx.collections.ObservableList;

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

    public static ObservableList<Countries> getCountries() {return getCountries();}
    @Override
    public String toString(){
        return (countryID + " - " + countryName);
    }
}
