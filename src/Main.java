import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.WindowsManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent parent = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
//        primaryStage.setTitle("FindTheCouples");
//        primaryStage.setScene(new Scene(parent));
//        primaryStage.setMaximized(true);
//        primaryStage.getIcons().add(new Image("resources/main-icon.png"));
//        primaryStage.show();

        WindowsManager.showPlayWindow();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
