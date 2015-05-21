package as.gfx;

import java.awt.Color;

public class Colour
{
    
    public static Color getColor(String colour)
    {
        if(colour == "BLACK") {return getColorRGB(0, 0, 0);}
        if(colour == "SHADOW") {return getColorRGB(25, 25, 25);}
        if(colour == "STEEL") {return getColorRGB(125, 125, 125);}
        if(colour == "RED") {return getColorRGB(170, 0, 0);}
        if(colour == "RED2") {return getColorRGB(45, 0, 0);}
        return Color.WHITE;
    }
    
    public static Color getColorRGB(int r, int g, int b)
    {
        float hsb[] = Color.RGBtoHSB(r,g,b,null);
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }
    
}