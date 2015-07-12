package as.account;

import as.server.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountGateway
{

    public static Account loadAccount(int accountID)
    {
        ArrayList<String> data;
        try
        {
            data = new Request("accountLoad", "accountID=" + accountID).get();
            //if(data)
            //return new Account(Integer.parseInt(data.get(0)), data.get(1), data.get(2));
            return new Account(0, "Jamie", "UK", new Title(0, "Developer", "Unknown"));
        }
        catch (IOException e) {System.out.println(e);}
        return null;
    }

}