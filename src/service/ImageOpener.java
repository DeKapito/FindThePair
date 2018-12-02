package service;

import javafx.scene.image.Image;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ImageOpener {
    private static final String IMAGES_FOLDER = "../resources/images";
    private static final String HIDDEN_IMAGE_PATH = "resources/hidden-img.png";

    public List<URI> getCardImages() {

        File imageFolder = null;
        try {
            imageFolder = new File(getClass().getResource(IMAGES_FOLDER).toURI());
        } catch (URISyntaxException e) {
            //TODO: exit
            e.printStackTrace();
        }

        File[] imageFiles = imageFolder.listFiles();
        List<URI> images = new ArrayList<>();

        Arrays.stream(imageFiles).forEach(image -> images.add(image.toURI()));

        return images;
    }

    public Image getHiddenCardImage() {
        return new Image(HIDDEN_IMAGE_PATH);
    }
}
