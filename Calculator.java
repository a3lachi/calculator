import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

class Btn extends Button {
    Btn(String label , int width, int height, int fontSize) {
        super(label);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setStyle("-fx-font-size: "+fontSize+";");
        this.setStyle("-fx-background-color: #334155; -fx-text-fill: white; -fx-font-size: "+fontSize+"; -fx-font-weight: bold; -fx-border-color: #94a3b8; -fx-focus-color: transparent; -fx-inner-border: transparent;");
    }

    Btn(String label , int width, int height, int fontSize, String color) {
        super(label);
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.setStyle("-fx-background-color: "+color+"; -fx-text-fill: white; -fx-font-size: "+fontSize+";");
    }
}

public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        Label l = new Label("Hello, this is a calculator.");

        
        // Button button0 = new Button("0");button0.setStyle("-fx-font-size: 20;");
        Btn button0 = new Btn("0",120,60,20);
        Button buttonVirgule = new Btn(",",60,60,20);
        Button buttonEqual = new Btn("=",60,60,20,"#fbbf24");

        Button button1 = new Btn("1",60,60,20);
        Button button2 = new Btn("2",60,60,20);
        Button button3 = new Btn("3",60,60,20);
        Button buttonPlus = new Btn("+",60,60,20,"#fbbf24");

        Button button4 = new Btn("4",60,60,20);
        Button button5 = new Btn("5",60,60,20);
        Button button6 = new Btn("6",60,60,20);
        Button buttonMinus = new Btn("-",60,60,20,"#fbbf24");

        HBox hbx1 = new HBox();
        hbx1.getChildren().addAll(button0,buttonVirgule,buttonEqual);


        HBox hbx2 = new HBox();
        hbx2.getChildren().addAll(button1,button2,button3,buttonPlus);

        HBox hbx3 = new HBox();
        hbx3.getChildren().addAll(button4,button5,button6,buttonMinus);

        

        VBox root = new VBox();
        root.getChildren().addAll(hbx3,hbx2, hbx1);

        Scene scene = new Scene(root, 240, 380);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}