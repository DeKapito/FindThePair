package controller;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Card;
import model.PlayField;
import service.WindowsManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainViewController {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label scoreLabel;

    private GridPane fieldGridPane;

    private PlayField playField;
    private List<Card> cards;
    private Map<Card, ImageView> cardImageViewMap = new HashMap<>();

    public MainViewController() {
        playField = new PlayField(4, 2);
        cards = playField.getCards();
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> createGrid(playField, mainBorderPane.getScene().widthProperty(), mainBorderPane.getScene().heightProperty()));
    }

    private void createGrid(PlayField playField, ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        fieldGridPane = new GridPane();
        fieldGridPane.setPadding(new Insets(10));

        int index = 0;
        for (int i = 0; i < playField.getNumberOfCardsHorizontal(); i++) {
            for(int k = 0; k < playField.getNumberOfCardsVertical(); k++) {
                ImageView imageView = new ImageView(playField.getHiddenCardImage());
                imageView.fitWidthProperty().bind(heightProperty.divide(5));
                imageView.fitHeightProperty().bind(heightProperty.divide(5));

                cardImageViewMap.put(cards.get(index), imageView);
                imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, clickOnCardHandler(cards.get(index), imageView));

                GridPane.setMargin(imageView, new Insets(10));
                fieldGridPane.add(imageView, i, k);

                index++;
            }
        }

        fieldGridPane.setAlignment(Pos.CENTER);
        mainBorderPane.setCenter(fieldGridPane);
    }

    private EventHandler clickOnCardHandler(Card card, ImageView imageView) {
        return e -> {
            playField.openCard(card);
            imageView.setImage(card.getImageFile());

            new Thread(() -> {
                if(playField.getLastSelectedCard() == null) {
                    fieldGridPane.setDisable(true);

                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                    for(Card cardMap : cardImageViewMap.keySet()) {
                        if(!cardMap.isFound()) {
                            cardImageViewMap.get(cardMap).setImage(playField.getHiddenCardImage());
                        }
                    }
                    fieldGridPane.setDisable(false);
                }
            }).start();

            if(playField.isFinish()) {
                Stage stage = (Stage)imageView.getScene().getWindow();
                stage.close();
                WindowsManager.showFinishGameWindow();
            }
        };
    }
}
