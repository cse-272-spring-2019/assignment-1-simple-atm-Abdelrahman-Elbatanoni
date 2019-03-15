/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author boda
 */
public class EnterAmount {
     Scene scene;
    Stage stage;
    HomeScreen homescreen;
    Transaction transaction;
    
    public EnterAmount(Stage stage)
    {
        this.stage=stage;
    }
    
    public void preparescene(){
         TextField textfield=new TextField("");
         
         Button one=new Button("1");
         Button two=new Button("2");
         Button three=new Button("3");
         Button four=new Button("4");
         Button five=new Button("5");
         Button six=new Button("6");
         Button seven=new Button("7");
         Button eight=new Button("8");
         Button nine=new Button("9");
         Button zero=new Button("0");
         Button submit=new Button("submit");
         Button back=new Button("Back");
         GridPane grid=new GridPane();
          grid.add(textfield, 3, 2);
         grid.add(submit, 4, 5);
           grid.add(one, 0, 1);
           grid.add(two, 1,1 );
           grid.add(three, 2, 1);
           grid.add(four, 0, 2);
           grid.add(five, 1, 2);
           grid.add(six, 2, 2);
           grid.add(seven, 0, 3);
           grid.add(eight, 1, 3);
           grid.add(nine, 2, 3);
           grid.add(zero, 1, 4);
           grid.add(back, 3, 5);
          scene =new Scene(grid,400,200);
           
           one.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + one.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           two.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + two.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           three.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + three.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           four.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + four.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           five.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + five.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           six.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + six.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           seven.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + seven.getText();    
                textfield.setText(textFieldNewString);
                
            }
           });
           eight.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + eight.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           nine.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + nine.getText();    
                textfield.setText(textFieldNewString);
            }
           });
           zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String textFieldNewString = textfield.getText() + zero.getText();    
                textfield.setText(textFieldNewString);
            }
           });
            submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(homescreen.transaction.getType()== "deposit"){
                    int balance = Integer.parseInt(textfield.getText());
                    homescreen.transaction.setAmount(balance);
                    homescreen.client.setbalance(balance);
                    textfield.clear();
                    homescreen.client.writetransaction("Operation: " +homescreen.transaction.getType() + 
                            "---Value : " + homescreen.transaction.getAmount());
                    stage.setScene(homescreen.getScene());
                    
                }
                else{
                    
                    int balance = Integer.parseInt(textfield.getText());
                    if(balance <homescreen.client.getBalance()){
                    homescreen.transaction.setAmount(balance);
                    homescreen.client.setbalance(- balance);
                    textfield.clear();
                    homescreen.client.writetransaction("Operation: " +homescreen.transaction.getType() + 
                            "---Value : " + homescreen.transaction.getAmount());
                    stage.setScene(homescreen.getScene());
                    }
                    else
                    {
                        Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setHeaderText(null);
                        alertunsucc.setContentText("No enough balance");
                        alertunsucc.showAndWait();
                    }
                }
                 
            }
           });
          back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textfield.clear();
                 stage.setScene(homescreen.getScene());
            }
           });
    }

    public Scene getScene() {
        return scene;
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }
}
