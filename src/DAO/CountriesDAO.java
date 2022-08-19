package DAO;

import Model.Countries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountriesDAO {

    public static ObservableList <Countries> getAllCountries(){
        ObservableList <Countries> allCountries = FXCollections.observableArrayList();
        String sql = "SELECT * FROM countries";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int countryID = rs.getInt("Country_ID");
                String country = rs.getString("Country");
                Countries c = new Countries(countryID, country);
                allCountries.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCountries;
    }

    }
//public static ObservableList<Countries> getCountryAppointments(String countryName) {
//    ObservableList<Countries> countryList = getAllCountries();
//    ObservableList<Countries>filteredList = countryList.filtered(a -> {
//        if(a.getCountryName() == countryName){
//            return true;
//        }
//        return false;
//    });
//    return filteredList;


