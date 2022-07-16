package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Reports implements Initializable {

    @FXML
    private ToggleGroup CustomerTG;

    @FXML
    private RadioButton customerByCountryRadioButton;

    @FXML
    private TableColumn<?, ?> customerIDColumn;

    @FXML
    private TableColumn<?, ?> startDateColumn;

    @FXML
    private TableColumn<?, ?> typeColumn;

    @FXML
    private RadioButton customerByTypeRadioButton;

    @FXML
    private TableColumn<?, ?> endDateColumn;

    @FXML
    private TableColumn<?, ?> startTimeColumn;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private Button returnToMainMenuButton;

    @FXML
    private RadioButton customersByMonthRadioButton;

    @FXML
    private ChoiceBox<?> monthChoiceBox;

    @FXML
    private TableColumn<?, ?> appointmentIDColumn;

    @FXML
    private TableColumn<?, ?> endTimeColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    void onActionReturnToMainMenu(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
