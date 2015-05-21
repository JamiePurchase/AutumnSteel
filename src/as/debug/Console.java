package as.debug;

public class Console
{

    public static void write(String write)
    {
        System.out.println(write);
    }
    
    public static void writeError(String write)
    {
        System.out.println((char)27 + "[31m" + write + (char)27 + "[0m");
    }
    
}