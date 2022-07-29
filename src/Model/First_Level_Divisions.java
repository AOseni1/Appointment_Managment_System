package Model;

import DAO.FirstLevelDivisionsDAO;
import javafx.collections.ObservableList;

public class First_Level_Divisions {

    private int divisionID;
    private String division;
    private int countryID;

    public First_Level_Divisions(int divisionID, String division, int countryID) {
        this.divisionID = divisionID;
        this.division = division;
        this.countryID = countryID;


    }

    /**
     * @return get division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * @return division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @return get country ID
     */
    public int getCountryID() {
        return countryID;
    }

    public static ObservableList<First_Level_Divisions> getFirstLevelDivisions() {
        return getFirstLevelDivisions();
    }

    @Override
    public String toString() {
        return (division);
    }
}




