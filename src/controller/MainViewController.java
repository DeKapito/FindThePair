package controller;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.ImageOpener;

import java.net.URI;
import java.util.List;

public class MainViewController {

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private Label scoreLabel;

    private GridPane fieldGridPane;

    @FXML
    private void initialize() {
        Platform.runLater(() -> createGrid(mainBorderPane.getScene().widthProperty(), mainBorderPane.getScene().heightProperty()));
    }

    private void createGrid(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        fieldGridPane = new GridPane();
        fieldGridPane.setPadding(new Insets(10));

        ImageOpener imageOpener = new ImageOpener();
        List<URI> images = imageOpener.getCardImages();

        for (int i = 0; i < 5; i++) {
            for(int k = 0; k < 4; k++) {
                ImageView imageView = new ImageView(new Image(((List) images).get(k).toString()));

                imageView.fitWidthProperty().bind(heightProperty.divide(5));//.set(0.8 * (width / 5));
                imageView.fitHeightProperty().bind(heightProperty.divide(5));//.set(0.8 * (height / 4));

                GridPane.setMargin(imageView, new Insets(10));
                fieldGridPane.add(imageView, i, k);
            }
        }

        fieldGridPane.setAlignment(Pos.CENTER);
        mainBorderPane.setCenter(fieldGridPane);
    }
}
