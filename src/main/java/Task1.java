import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task1 extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("chat_window.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Chat");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
