package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Button playGameBtn;

    @FXML
    private ChoiceBox<Integer> numCardsHorChoiceBox;

    @FXML
    private ChoiceBox<Integer> numCardsVerChoiceBox;

    @FXML
    private Label errorLabel;

    @FXML
    private void initialize() {
        numCardsVerChoiceBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4));
        numCardsVerChoiceBox.getSelectionModel().select(1);
        numCardsHorChoiceBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5));
        numCardsHorChoiceBox.getSelectionModel().select(1);

        numCardsVerChoiceBox.setOnAction(event -> {
            int numberOfCardsHorizontal = numCardsHorChoiceBox.getValue();
            int numberOfCardsVertical = numCardsVerChoiceBox.getValue();

            errorLabel.setText("");
            playGameBtn.setDisable(false);
            if(!checkConfiguration(numberOfCardsHorizontal, numberOfCardsVertical)) {
                playGameBtn.setDisable(true);
                errorLabel.setText("*This configuration is not possible");
            }
        });
        numCardsHorChoiceBox.setOnAction(numCardsVerChoiceBox.getOnAction());

        playGameBtn.setOnAction(event -> {

        });
    }

    public boolean checkConfiguration(int horizontal, int vertical) {
        return (horizontal * vertical) % 2 == 0;
    }
}
