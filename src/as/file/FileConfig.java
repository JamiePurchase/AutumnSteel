package as.file;

import java.io.File;

public class FileConfig
{
    // Config
    private String file;

    // Account
    private int accountID = 0;
    private String accountUsername = "";
    private String accountPassword = "";
    private boolean accountRemember = false;

    public FileConfig()
    {
        this.file = new File(".").getAbsolutePath();
    }

}