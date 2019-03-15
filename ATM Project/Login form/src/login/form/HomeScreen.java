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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author boda
 */
public class HomeScreen {
    Scene scene;
    Login login;
    Stage stage;
    EnterAmount enteramount;
    int balance=0;
    Transaction transaction;
    HomeScreen homescreen;
    Client client;
    public HomeScreen(Stage stage)
    {
        this.stage=stage;
    }
    public void preparescene(){
        transaction = new Transaction();
        client = new Client();
         Label welcome=new Label("Welcome!");
         Label data=new Label("         balance="+balance);
         
         Button deposit=new Button("Deposit");
         Button withdraw=new Button("Withdraw");
         Button balance=new Button("Balance Inquiry");
         Button previous=new Button("Previous");
         Button next=new Button("Next");
         Button logout=new Button("LogOut");
         GridPane grid=new GridPane();
           grid.add(welcome,10,0);
           grid.add(deposit, 0, 1);
           grid.add(withdraw, 0, 2);
           grid.add(balance, 0, 3);
           grid.add(previous, 0, 4);
           grid.add(next, 0, 5);
           grid.add(logout, 0, 6);
           grid.add(data, 2, 3);
          scene =new Scene(grid,400,200);
          deposit.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 transaction.setType("deposit");
                 stage.setScene(enteramount.getScene());
                 
             }
             
       });
          withdraw.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 transaction.setType("withdraw");
                 stage.setScene(enteramount.getScene());
             }
             
       });
           balance.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                
                data.setText("         Balance =" + client.getBalance());
                
client.writetransaction("Operation:BalanceInquiry---Value: " + client.getBalance());
             }
             
       });
          
           previous.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                  if(client.previousbutton())
                 data.setText(client.previoushistory());
                else{
                     Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setContentText("Error,!!");
                        alertunsucc.showAndWait();
                }
              
             }
             
       });
           next.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                  if(client.nextButton())
                      data.setText(client.nexthistory());
                else
                {
                    Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setContentText("Error,!!");
                        alertunsucc.showAndWait();
                }
             }    
       });
           logout.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event){
               stage.setScene(login.getScene());
             }
             
       });
    }
    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setEnteramount(EnterAmount enteramount) {
        this.enteramount = enteramount;
    }
}
