package controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import service.ImageOpener;

import java.net.URI;
import java.util.List;

public class MainViewController {

    @FXML
    private BorderPane mainBorderPane;

    private GridPane fieldGridPane;

    @FXML
    private void initialize() {
        createGrid(600, 600);
    }

    private void createGrid(double height, double width) {
        fieldGridPane = new GridPane();

        ImageOpener imageOpener = new ImageOpener();
        List<URI> images = imageOpener.getCardImages();

        for (int i = 0; i < 2; i++) {
            for(int k = 0; k < 2; k++) {
                ImageView imageView = new ImageView(new Image(((List) images).get(k).toString()));
                imageView.setFitHeight(height / 2);
                imageView.setFitWidth(width / 2);

                fieldGridPane.add(imageView, i, k);
            }
        }

        fieldGridPane.setAlignment(Pos.CENTER);
        mainBorderPane.setCenter(fieldGridPane);
    }
}
