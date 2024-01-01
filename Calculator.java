import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;



public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        Label l = new Label("Hello, this is a calculator.");

        

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");

        button1.setPrefWidth(60);button2.setPrefWidth(60);button3.setPrefWidth(60);

        HBox vbx = new HBox();
        vbx.getChildren.addAll(button1,button2,button3);

        HBox root = new HBox();
        root.getChildren().addAll(vbx, button2, button3);

        Scene scene = new Scene(root, 240, 380);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}