package DAO;


import Model.First_Level_Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLevelDivisionsDAO {

    public static ObservableList<First_Level_Divisions> getAllFirstLevelDivisions(int country_ID){
        ObservableList <First_Level_Divisions> allFirstLevelDivisions = FXCollections.observableArrayList();
        String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = ?";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, country_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int divisionID = rs.getInt("Division_ID");
                String division = rs.getString("Division");
                int countryID = rs.getInt("country_ID");
                First_Level_Divisions first_level_divisions = new First_Level_Divisions(divisionID, division, countryID);
                allFirstLevelDivisions.add(first_level_divisions);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allFirstLevelDivisions;
    }
}
