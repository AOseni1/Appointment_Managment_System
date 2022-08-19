package DAO;

import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {

    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> allUsers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM users";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userID = rs.getInt("User_ID");
                String userName = rs.getString("User_Name");
                String password = rs.getString("password");
                Users users = new Users(userID, userName, password);
                allUsers.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsers;
    }

    public static int userPasswordCheck(String username, String password) {
        String sql = "SELECT * FROM users WHERE User_Name = ? AND Password = ? ";
        try {
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("user_Name").equals(username)) ;
                if (rs.getString("Password").equals(password)) ;
                return rs.getInt("user_ID");
            }

            if (username.isEmpty() || password.isEmpty());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return 0;
    }
}



