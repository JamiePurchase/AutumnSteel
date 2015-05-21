package as.gfx;

import java.awt.Font;

public class Fonts 
{
    
    public static Font getFont(String font)
    {
        if(font == "Standard") {return new Font("Times New Roman", Font.PLAIN, 26);}
        return new Font("Times New Roman", Font.PLAIN, 26);
    }
    
}