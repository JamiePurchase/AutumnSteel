package as.server;

import as.debug.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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
    
    public ArrayList<String> get() throws IOException
    {
        // Request
        URL http = new URL(this.url);
        BufferedReader read = new BufferedReader(new InputStreamReader(http.openStream()));
        Console.write("Server Request: " + http);
        
        // Compile the data into a string
        ArrayList<String> data = new ArrayList();
        String webLine;
        while((webLine = read.readLine()) != null)
        {
            System.out.println(webLine);
            data.add(webLine);
        }
        
        // Close the stream
        read.close();

        //Console.write("Request Completed");
        return data;
    }

}