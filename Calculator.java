// export PATH_TO_FX=/Users/farawa/Downloads/javafx-sdk-21.0.1/lib 
// javac --module-path $PATH_TO_FX --add-modules javafx.controls Calculator.java ; java --module-path $PATH_TO_FX --add-modules javafx.controls Calculator
// javac --module-path /Users/farawa/Downloads/javafx-sdk-21.0.1/lib --add-modules javafx.controls Calculator.java ; java --module-path /Users/farawa/Downloads/javafx-sdk-21.0.1/lib --add-modules javafx.controls Calculator


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
        this.setStyle("-fx-background-color: "+color+"; -fx-text-fill: white; -fx-font-size: "+fontSize+";-fx-font-weight: bold;  -fx-border-color: #94a3b8; -fx-focus-color: transparent; -fx-inner-border: transparent;");
    }
}

class Calculation {
    double firstDouble ;
    double secondDouble ;
    char operation ;
    char savedOperation ;
    double result ;

    Calculation(double firstDouble , double secondDouble , char operation) {
        this.firstDouble = firstDouble ;
        this.secondDouble = secondDouble ;
        this.operation = operation ;
    }

    public void setFirstDouble (double firstDouble) {
        this.firstDouble = firstDouble ;
    }

    public void setSecondDouble (double secondDouble) {
        this.secondDouble = secondDouble ;
    }

    public void setOperation (char operation) {
        this.operation = operation ;
    }

    public void setResult(double result) {
        this.result = result ;
    }

    public char getOperation() {
        return this.savedOperation ;
    }
}


public class Calculator extends Application {

    void updatePanel(StackPane headLabel, String textCalc) {
        Label labelToAdd = new Label(textCalc);
        labelToAdd.setPrefHeight(50);
        labelToAdd.setPrefWidth(240);
        labelToAdd.setStyle(" -fx-background-color: #475569; -fx-font-size: 30 ; -fx-text-fill: #f8fafc; -fx-alignment: center-right; -fx-padding: 0 10 0 0;");
        headLabel.getChildren().remove(0);headLabel.getChildren().add(labelToAdd);
    }

    @Override
    public void start(Stage stage) {

        Calculation calc = new Calculation(0, 0, ' ');
        
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
        Button buttonC = new Btn("C",60,60,20,"#64748b");
        Button buttonNegative = new Btn("+/-",60,60,20,"#64748b");
        Button buttonModulo = new Btn("%",60,60,15,"#64748b");
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
        l.setPrefHeight(50);
        l.setPrefWidth(240);
        l.setStyle(" -fx-background-color: #475569; -fx-font-size: 30 ; -fx-text-fill: #f8fafc; -fx-alignment: center-right; -fx-padding: 0 10 0 0;");
        StackPane headLabel = new StackPane();
        headLabel.getChildren().add(l);

        Button[] buttons = {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9} ;
        Button[] buttonsOp = {buttonDivision,buttonMultiply,buttonPlus, buttonMinus , buttonEqual};
        char[] buttonsCharOp = {'÷','x','+','-','='};
        
        for (int i=0;i<5;i++) {
            String btnStyle = buttonsOp[i].getStyle();
            int bntNum = i ;

            buttonsOp[i].setOnMousePressed(event -> {
                buttonsOp[bntNum].setStyle(btnStyle+"-fx-background-color: #a16207;"); 
            });

            buttonsOp[i].setOnMouseReleased(event -> {
                buttonsOp[bntNum].setStyle(btnStyle); 
            });
            
            if (i<4) {
                buttonsOp[i].setOnAction(e -> {
                    Label insideCalc = (Label) headLabel.getChildren().get(0);
                    double firstElem = Double.parseDouble(insideCalc.getText()) ;
                    calc.setFirstDouble(firstElem);
                    calc.setOperation(buttonsCharOp[bntNum]);
                });
            }
        }

        buttonEqual.setOnAction(e->{
            Label insideCalc = (Label) headLabel.getChildren().get(0);
            double secondElem = Double.parseDouble(insideCalc.getText()) ;
            System.out.println("First elem : "+calc.firstDouble+" , Second elem : "+secondElem);
            double result = calc.firstDouble*secondElem ;
            calc.setResult(result);
            updatePanel(headLabel, String.valueOf(result));
        });

        // display number when ints clicked
        for (int i=0; i<10;i++) {
            int btnNum = i ;
            String btnStyle = buttons[btnNum].getStyle();

            buttons[btnNum].setOnMousePressed(event -> {
                buttons[btnNum].setStyle(btnStyle+"-fx-background-color: #9ca3af;"); 
            });

            buttons[btnNum].setOnMouseReleased(event -> {
                buttons[btnNum].setStyle(btnStyle); 
            });
            buttons[i].setOnAction(e -> {
                System.out.println(btnNum+" clicked!");
                
                Label insideCalc = (Label) headLabel.getChildren().get(0);
                String textCalc = insideCalc.getText() ;
                if (textCalc.equals("0")) {
                    textCalc = String.valueOf(btnNum);
                } else {
                    if (calc.operation == ' ') {
                        textCalc += String.valueOf(btnNum);
                    }
                    // } else {
                    //     calc.savedOperation = calc.operation ;
                    //     calc.operation = ' ';
                    //     calc.firstDouble = Double.parseDouble(textCalc);
                    //     textCalc = String.valueOf(btnNum) ;
                    // }
                }
                updatePanel(headLabel, textCalc);

                if (calc.operation == ' ') {
                    calc.setFirstDouble(Double.parseDouble(textCalc));
                } else {
                    calc.setSecondDouble(Double.parseDouble(textCalc));
                }
            });
        }


        buttonVirgule.setOnAction(e -> {
            System.out.println(", clicked!");
            Label insideCalc = (Label) headLabel.getChildren().get(0);
            String textCalc = insideCalc.getText() ;
            if (textCalc.indexOf(".")==-1) {
                textCalc += ".";
            }
            Label labelToAdd = new Label(textCalc);
            labelToAdd.setPrefHeight(50);
            labelToAdd.setPrefWidth(240);
            labelToAdd.setStyle(" -fx-background-color: #475569; -fx-font-size: 30 ; -fx-text-fill: #f8fafc; -fx-alignment: center-right; -fx-padding: 0 10 0 0;");
            headLabel.getChildren().remove(0);headLabel.getChildren().add(labelToAdd);
        });

        buttonC.setOnAction(e -> {
            System.out.println("C clicked!");
            calc.setOperation(' ');
            String textCalc = "0";
            Label labelToAdd = new Label(textCalc);
            labelToAdd.setPrefHeight(50);
            labelToAdd.setPrefWidth(240);
            labelToAdd.setStyle(" -fx-background-color: #475569; -fx-font-size: 30 ; -fx-text-fill: #f8fafc; -fx-alignment: center-right; -fx-padding: 0 10 0 0;");
            headLabel.getChildren().remove(0);headLabel.getChildren().add(labelToAdd);
        });



        VBox root = new VBox();
        root.getChildren().addAll(headLabel,hbx5,hbx4,hbx3,hbx2, hbx1);

        Scene scene = new Scene(root, 240, 350);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}