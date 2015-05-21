package as.server;

import as.debug.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Request
{
    private String url;

    public Request(String url)
    {
        this.url = "http://autumn-steel.co.nf/remote/" + url + ".php";
    }

    public Request(String url, String variables)
    {
        this.url = "http://autumn-steel.co.nf/remote/" + url + ".php" + "?" + variables;
    }
    
    public String get() throws IOException
    {
        // Request
        URL http = new URL(this.url);
        BufferedReader webRead = new BufferedReader(new InputStreamReader(http.openStream()));
        //Console.write("Server Request: " + http);
        
        // Compile the data into a string
        String webData = "";
        String webLine;
        int webRows = 0;
        while((webLine = webRead.readLine()) != null)
        {
            //Console.write(webLine);
            webData = webData + webLine;
            webRows += 1;
        }
        
        // Close the stream
        webRead.close();
        //Console.write("Request Completed");
        return webData;
    }

}