package as.account;

public class AccountGateway
{
    public Account loadAccount(int accountID)
    {
        // NOTE: need to ask the server for the account details
        // account object (alternate?) constructor should take in all details
        return new Account(accountID);
    }
}