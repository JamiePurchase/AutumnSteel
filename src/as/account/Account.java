package as.account;

import as.server.Request;
import as.states.StateTitle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account
{
    private int accountID;
    private String username;
    private String location;
    //private timestamp online;
    //private Banner banner;
    private Title title;
    
    public Account(int id, String username, String location, Title title)
    {
        this.accountID = id;
        this.username = username;
        this.location = location;
        this.title = title;
    }
    
    public int getAccountID()
    {
        return this.accountID;
    }
    
    public Title getTitle()
    {
        return this.title;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void updateOnline()
    {
        try {new Request("updateOnline", "accountID=" + this.accountID).get();}
        catch (Exception e) {System.out.println(e);}
    }

}