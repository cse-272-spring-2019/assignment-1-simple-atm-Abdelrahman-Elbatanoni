/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.form;

import java.util.HashMap;

/**
 *
 * @author boda
 */
public class Client {
    HashMap usersDictionary;
    private int balance;
    private String type;
  private int counter;
  private String [] history=new String[5];
        private int nextcounter;
    public Client(){
        usersDictionary=new HashMap();
        usersDictionary.put("1234","1234");
    }
    public boolean validate(String password)
    {
        boolean validationresult=false;
        String fetchedpassword=(String)usersDictionary.get(password);
        if(fetchedpassword!=null)
        {
            validationresult=fetchedpassword.equals(password);
        }
        return validationresult;
    }
    public void setbalance(int balance){
        this.balance += balance;
    }

    public int getBalance() {
        return balance;
    }
    public boolean validation(int amount){
        if(amount > balance)
            return false;
        else
            return true;
    }    
   public void writetransaction(String string){
        if(counter +1 >4){
            for(int i=0;i<4;i++){
                history[i]=history[i+1];
            }
            history[4]=string;
        }
        else{
          counter++;
          history[counter]=string;
          nextcounter++;
        }
       
   }

 public String previoushistory(){
        
        return history[--counter];
    }
      public String nexthistory(){
        
        return history[++counter];
      }

public boolean nextButton(){
        if (counter +1 >=nextcounter)
            return false;
        else
            return true;      
    }
    public boolean previousbutton(){
        if(this.counter -1 <0)
            return false;
        else
            return true;
    }

}
