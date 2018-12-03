package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import service.InformationSingleton;
import service.WindowsManager;

public class FinishGameController {

    @FXML
    private Button mainMenuBtn;

    @FXML
    private Label resultErrorsLabel;

    @FXML
    private Label resultTimeLabel;

    @FXML
    private Button playAgainBtn;

    private InformationSingleton informationSingleton;

    @FXML
    private void initialize() {
        informationSingleton = InformationSingleton.getInformationSingleton();

        playAgainBtn.setOnAction(event -> {
            Stage stage = (Stage) playAgainBtn.getScene().getWindow();
            stage.close();
            WindowsManager.showPlayWindow();
        });

        mainMenuBtn.setOnAction(event -> {
            Stage stage = (Stage) playAgainBtn.getScene().getWindow();
            stage.close();
            WindowsManager.showMainMenuWindow();
        });

        resultErrorsLabel.setText(informationSingleton.getCountErrors().toString());
    }
}
