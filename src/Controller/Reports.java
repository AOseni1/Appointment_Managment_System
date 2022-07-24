package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Reports implements Initializable {

    Stage stage;
    Parent scene;

    @FXML
    private ComboBox<?> reportsCountryCountComboBox;

    @FXML
    private ComboBox<?> contactComboBox;

    @FXML
    private TableColumn<?, ?> customerIDColumn;

    @FXML
    private TableColumn<?, ?> startDateColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private TableColumn<?, ?> endDateColumn;

    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private ComboBox<?> reportsMonthComboBox;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private Button returnToMainMenuButton;

    @FXML
    private ComboBox<?> reportsTypeComboBox;

    @FXML
    private TableColumn<?, ?> appointmentIDColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

        @FXML
        void onActionReturnToMainMenu(ActionEvent event) throws IOException {
            stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("/View/LandingPage.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
