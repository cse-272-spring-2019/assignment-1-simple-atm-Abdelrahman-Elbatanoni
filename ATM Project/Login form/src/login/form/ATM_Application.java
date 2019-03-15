/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author boda
 */
public class ATM_Application extends Application  {
 public static void main(String[] args) {
       launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ATM Application");
        Login login=new Login(primaryStage);
        HomeScreen homescreen=new HomeScreen(primaryStage);
        EnterAmount enteramount=new EnterAmount(primaryStage);
        login.preparescene();
        homescreen.preparescene();
        enteramount.preparescene();
        login.setHomescreen(homescreen);
        homescreen.setLogin(login);
        homescreen.setEnteramount(enteramount);
        enteramount.setHomescreen(homescreen);
        primaryStage.setScene(login.getScene());
       primaryStage.show();
    }
    
}
