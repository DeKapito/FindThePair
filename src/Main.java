import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        primaryStage.setTitle("FindTheCouples");
        primaryStage.setScene(new Scene(parent, 300, 275));
        primaryStage.getIcons().add(new Image("resources/images/main-icon.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}