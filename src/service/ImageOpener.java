package service;

import javafx.scene.image.Image;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ImageOpener {
    private static final String IMAGES_FOLDER = "resources/images/";
    private static final String HIDDEN_IMAGE_PATH = "resources/hidden-img.png";

    public List<Image> getCardImages() {

//        File imageFolder = null;
//        try {
//            imageFolder = new File(getClass().getResource(IMAGES_FOLDER).toURI());
//        } catch (URISyntaxException e) {
//            //TODO: exit
//            e.printStackTrace();
//        }
//
//        File[] imageFiles = imageFolder.listFiles();
//        List<Image> images = new ArrayList<>();
//
//        Arrays.stream(imageFiles).forEach(image -> images.add(new Image(image.toURI().toString())));

        List<Image> images = new ArrayList<>();
        Image image;

        for(int i = 0; i < 10; i++) {
            try {
                image = new Image(IMAGES_FOLDER + i + ".jpg");
            } catch (IllegalArgumentException e) {
                break;
            }

            images.add(image);
        }

        return images;
    }

    public Image getHiddenCardImage() {
        return new Image(HIDDEN_IMAGE_PATH);
    }
}
