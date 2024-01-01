import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        Label l = new Label("Hello, this is a calculator.");
        Scene scene = new Scene(new StackPane(l), 240, 380);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}