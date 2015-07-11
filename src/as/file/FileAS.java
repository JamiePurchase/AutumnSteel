package as.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class FileAS
{
    private String name;
    private String location;
    private ArrayList<String> data;
    private final String comment = "!!";
    private final String separator = System.getProperty("line.separator");

    public FileAS(String name, String location)
    {
        this.name = name;
        this.location = location;
        this.data = new ArrayList();
    }
    
    public ArrayList<String> getData()
    {
        return this.data;
    }
    
    private String getData(int pos)
    {
        return this.data.get(pos);
    }
    
    private String getDataAsString()
    {
        String data = "";
        for(int x = 0; x < this.data.size(); x++)
        {
            data += this.getData(x);
            if(x < this.data.size() - 1) {data += this.separator;}
        }
        return data;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLocation()
    {
        return this.location;
    }
    
    private String getPath()
    {
        return this.location;
    }

    public String[] read() throws IOException
    {
        BufferedReader tr = readBuffer();
        int lineCount = readLines();
        String[] textData = new String[lineCount];
        for(int line = 0; line < lineCount; line++)
        {
            String thisLine  = tr.readLine();
            if(!thisLine.substring(0, 2).equals(this.comment))
            {
                textData[line] = thisLine;
            }
        }
        tr.close();
        return textData;
    }

    private int readLines() throws IOException
    {
        BufferedReader bf = readBuffer();
        int lineCount = 0;
        while(bf.readLine() != null)
        {
            if(bf.readLine().substring(0, 2).equals(this.comment))
            {
                // Comments in froth files are marked with !!
                // They are completely ignored by the system
            }
            else {lineCount ++;}
        }
        bf.close();
        return lineCount;
    }
    
    private BufferedReader readBuffer() throws FileNotFoundException
    {
        return new BufferedReader(new FileReader(this.getPath()));
    }
    
    private void setData(ArrayList<String> data)
    {
        this.data = data;
    }
	
    public void write()
    {
        System.out.println("FWAO");
        try {writeData(this.getDataAsString());}
        catch (IOException e) {e.printStackTrace();}
    }
	
    public void writeData(String data) throws IOException
    {
        PrintWriter write = writePrint(true);
        write.printf("%s" + "%n", data);
        write.close();
    }
    
    private PrintWriter writePrint(boolean append) throws IOException
    {
        return new PrintWriter(new FileWriter(this.getPath(), append));
    }

}