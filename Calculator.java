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
        Button button7 = new Btn("7",60,60,20);
        Button button8 = new Btn("8",60,60,20);
        Button button9 = new Btn("9",60,60,20);
        Button buttonMultiply = new Btn("x",60,60,20,"#fbbf24");
        Button buttonC = new Btn("C",60,60,20);
        Button buttonNegative = new Btn("+/-",60,60,20);
        Button buttonModulo = new Btn("%",60,60,15);
        Button buttonDivision = new Btn("÷",60,60,20,"#fbbf24");

        HBox hbx1 = new HBox();
        hbx1.getChildren().addAll(button0,buttonVirgule,buttonEqual);
        HBox hbx2 = new HBox();
        hbx2.getChildren().addAll(button1,button2,button3,buttonPlus);
        HBox hbx3 = new HBox();
        hbx3.getChildren().addAll(button4,button5,button6,buttonMinus);
        HBox hbx4 = new HBox();
        hbx4.getChildren().addAll(button7,button8,button9,buttonMultiply);
        HBox hbx5 = new HBox();
        hbx5.getChildren().addAll(buttonC,buttonNegative,buttonModulo,buttonDivision);

        
        Label l = new Label("0");
        l.setPrefHeight(30);
        l.setPrefWidth(240);
        l.setStyle(" -fx-background-color: #475569; -fx-font-size: 30 ; -fx-text-fill: #f8fafc;");
        StackPane headLabel = new StackPane();
        headLabel.getChildren().add(l);



        button9.setOnAction(e -> {
            System.out.println("9 clicked!");
            
            Label insideCalc = (Label) headLabel.getChildren().get(0);
            String textCalc = insideCalc.getText() ;
            if (textCalc.equals("0")) {
                textCalc = "9";
            } else {
                textCalc += "9";
            }
            System.out.println(textCalc);
            headLabel.getChildren().remove(0);
            Label l9 = new Label(textCalc);
            headLabel.getChildren().add(l9);
        });



        VBox root = new VBox();
        root.getChildren().addAll(headLabel,hbx5,hbx4,hbx3,hbx2, hbx1);

        Scene scene = new Scene(root, 240, 330);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}