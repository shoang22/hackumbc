import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        Controller controllerInstance = new Controller();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(controllerInstance);
        primaryStage.setTitle("Application");
        primaryStage.setScene(new Scene(root, 830, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
