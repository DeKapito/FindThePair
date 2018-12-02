package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Card;

import java.util.List;

public class MainViewController {

    @FXML
    private BorderPane mainBorderPane;

    private GridPane fieldGridPane;

    @FXML
    private void initialize() {
        createGrid();
    }

    private void createGrid() {
        fieldGridPane = new GridPane();

        for (int i = 0; i < 2; i++) {
            for(int k = 0; k < 2; k++) {
                ImageView imageView = new ImageView(new Image("resources/images/main-icon.png"));
                fieldGridPane.add(imageView, i, k);
            }
        }

        fieldGridPane.setAlignment(Pos.CENTER);
        mainBorderPane.setCenter(fieldGridPane);
    }
}
