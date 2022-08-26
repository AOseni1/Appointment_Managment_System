package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sqlUser";
    private static final String password = "Passw0rd!";
    public static Connection connection =null;

    /**
     * Starts the database connection
     * @return
     */
    public static Connection openConnection(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbUrl, userName, password);
            System.out.println("Connection successful");
        } catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;

    }


    /**
     * Closes the database connection
     */
        public static void closeConnection(){
            try{
                connection.close();
                System.out.println("Connection closed");
            }
            catch(Exception e){
                System.out.println("Error:" + e.getMessage());
            }
        }

    }

