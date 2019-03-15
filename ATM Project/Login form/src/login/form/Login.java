/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boda
 */
public class Login {
   Client client;
    HomeScreen homescreen;
    Stage stage;
    public Login(Stage stage)
    {
        this.stage=stage;
    }
    
Scene scene;
    public void preparescene() {
        client = new Client();
       Label passwordlabel=new Label("Password:");
       Label validationlabel=new Label();
       PasswordField passwordfield=new PasswordField();
       Button submit=new Button("submit");
       GridPane grid=new GridPane();
       grid.add(passwordlabel, 0, 0);
       grid.add(passwordfield, 1, 0);
       grid.add(submit, 1, 1);
       grid.add(validationlabel, 1, 2);
       submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String password=passwordfield.getText();
                boolean valid =client.validate(password);
                if(valid)
                {
                  passwordfield.clear();
                  stage.setScene(homescreen.getScene());
                }
                else
                {
                    passwordfield.clear();
                     validationlabel.setText("Invalid Password");
                }
            }
       });
     scene =new Scene(grid,400,200);
    }
    public Scene getScene(){
        return this.scene;
    }

    public void setHomescreen(HomeScreen homescreen) {
        this.homescreen = homescreen;
    }
    
}
