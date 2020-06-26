import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task2 extends Application {
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calc_window.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Calc");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
