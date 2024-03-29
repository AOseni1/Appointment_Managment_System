package Main;

import DAO.*;
import Model.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        primaryStage.setTitle("Appointment Management System");
        primaryStage.setScene(new Scene(root, 575, 415));
        primaryStage.show();
    }


    public static void main(String[] args){

//        Locale.setDefault(new Locale("fr"));

        JDBC.openConnection();

            launch(args);

            JDBC.closeConnection();
        }

    }
