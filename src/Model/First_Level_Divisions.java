package Model;

public class First_Level_Divisions {

    private int divisionID;
    private String division;
    private int countryID;

    public First_Level_Divisions(int divisionID, String division, int countryID){
        this.divisionID = divisionID;
        this.division = division;
        this.countryID = countryID;
    }


    /**
     *
     * @return get division ID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     *
     * @return division
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @return get country ID
     */
    public int getCountryID() {
        return countryID;
    }
}
