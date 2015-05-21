package as.account;

import as.debug.Console;
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
    private Banner banner;
    
    public Account(int id)
    {
        this.accountID = id;
    }
    
    public int getAccountID()
    {
        return this.accountID;
    }
    
    public void updateOnline()
    {
        try
        {
            new Request("updateOnline", "accountID=" + this.accountID).get();
        }
        catch (Exception ex)
        {
            Logger.getLogger(StateTitle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}