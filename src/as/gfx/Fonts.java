package as.gfx;

import java.awt.Font;

public class Fonts 
{
    
    public static Font getFont(String font)
    {
        if(font == "BUTTON_STANDARD") {return new Font("Segoe Script", Font.PLAIN, 18);}
        if(font == "MENU_STANDARD") {return new Font("Segoe Print", Font.PLAIN, 22);}
        if(font == "MENU_TITLE") {return new Font("Segoe Script", Font.ITALIC, 38);}
        if(font == "PANEL_BOLD") {return new Font("Times New Roman", Font.BOLD, 22);}
        if(font == "PANEL_ITALIC") {return new Font("Times New Roman", Font.ITALIC, 20);}
        if(font == "PANEL_ENTITY") {return new Font("Segoe Print", Font.BOLD, 22);}
        if(font == "PANEL_STANDARD") {return new Font("Times New Roman", Font.PLAIN, 22);}
        if(font == "PANEL_SUPPLY_COUNT") {return new Font("Times New Roman", Font.BOLD, 16);}
        return new Font("Times New Roman", Font.PLAIN, 26);
    }
    
}