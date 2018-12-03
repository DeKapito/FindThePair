package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowsManager {

    private static final String PLAY_WINDOW_VIEW = "/view/MainView.fxml";
    private static final String FINISH_GAME_WINDOW_VIEW = "/view/FinishGame.fxml";

    private static final String MAIN_ICON_PATH = "resources/main-icon.png";
    private static final String WINDOWS_TITLE = "FindTheCouples";

    public static void showPlayWindow() {
        Stage stage = loadWindow(WINDOWS_TITLE, PLAY_WINDOW_VIEW);
        stage.setMaximized(true);
        stage.show();
    }

    public static void showFinishGameWindow() {
        Stage stage = loadWindow(WINDOWS_TITLE, FINISH_GAME_WINDOW_VIEW);
        stage.show();
    }

    private static Stage loadWindow(String windowTitle, String viewPath) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Stage stage = new Stage();
            stage.setTitle(windowTitle);
            stage.getIcons().add(new Image(MAIN_ICON_PATH));

            fxmlLoader.setLocation(WindowsManager.class.getResource(viewPath));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            stage.setScene(scene);

            return stage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
