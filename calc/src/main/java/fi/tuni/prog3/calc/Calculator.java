package fi.tuni.prog3.calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Calculator
 * 
 * Creator: Timi Autio
 * 
 * A simple calculator app made with JavaFX. At the moment contains add,
 * subtract, multiply and divide operations.
 */
public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");
        
        // Using grid to place the components
        GridPane grid = new GridPane();
        
        // Creating the scene window
        var scene = new Scene(grid, 400, 300);
        stage.setScene(scene);
        
        // Text label 1
        Label textLabel1 = new Label("First operand:");
        textLabel1.setId("labelOp1");
        grid.add(textLabel1, 0, 1);

        // Text label 2
        Label textLabel2 = new Label("Second operand:");
        textLabel2.setId("labelOp2");
        grid.add(textLabel2, 0, 2);        
        
        // Result label
        Label labelRes = new Label("Result:");
        labelRes.setId("labelRes");
        grid.add(labelRes, 0, 3);    
        
        
        // Input field 1
        TextField inputField1 = new TextField();
        inputField1.setId("fieldOp1");
        grid.add(inputField1, 1, 1);

        // Input field 2
        TextField inputField2 = new TextField();
        inputField2.setId("fieldOp2");
        grid.add(inputField2, 1, 2);
        
        // Result label
        Label fieldRes = new Label("");
        fieldRes.setId("fieldRes");
        grid.add(fieldRes, 1, 3);
        fieldRes.setBackground(
                new Background(
                new BackgroundFill(
                        Color.WHITE, 
                        new CornerRadii(0), 
                        new Insets(0)
                )));
        
        
        // Create buttons in horizontal layout
        HBox hbBtn = new HBox(10);
        grid.add(hbBtn, 1, 4);
        
        Button btnAdd = new Button("Add");
        btnAdd.setId("btnAdd");
        hbBtn.getChildren().add(btnAdd);
        
        Button btnSub = new Button("Subtract");
        btnSub.setId("btnSub");
        hbBtn.getChildren().add(btnSub);

        Button btnMul = new Button("Multiply");
        btnMul.setId("btnMul");
        hbBtn.getChildren().add(btnMul);

        Button btnDiv = new Button("Divide");
        btnDiv.setId("btnDiv");
        hbBtn.getChildren().add(btnDiv);
        
        
        // Actions to the buttons. Buttons print the result with two decimals.

        // Add action
        btnAdd.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                var a = Double.parseDouble(inputField1.getText());
                var b = Double.parseDouble(inputField2.getText());
                var c = a + b;
                
                fieldRes.setText(String.format("%.2f", c));
                
            }
        });
        
        // Subtracting action
        btnSub.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                var a = Double.parseDouble(inputField1.getText());
                var b = Double.parseDouble(inputField2.getText());
                var c = a - b;
                
                fieldRes.setText(String.format("%.2f", c));
                
            }
        });
            
        // Multiply action
        btnMul.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                var a = Double.parseDouble(inputField1.getText());
                var b = Double.parseDouble(inputField2.getText());
                var c = a * b;
                
                fieldRes.setText(String.format("%.2f", c));
                
            }
        });
        
        // Divide action
        btnDiv.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                var a = Double.parseDouble(inputField1.getText());
                var b = Double.parseDouble(inputField2.getText());
                var c = (a / b);
                
                fieldRes.setText(String.format("%.2f", c));
            }
        });
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}