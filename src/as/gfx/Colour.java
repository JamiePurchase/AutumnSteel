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
        
        // NEW
        if(colour == "BUTTON_BACKGROUND_FORCE") {return getColorRGB(220, 190, 160);}
        if(colour == "BUTTON_HOVER_FORCE") {return getColorRGB(230, 200, 170);}
        if(colour == "BUTTON_BORDER_FORCE") {return getColorRGB(175, 125, 100);}
        if(colour == "BUTTON_TEXT_FORCE") {return getColorRGB(175, 125, 100);}
        if(colour == "DEV_NEXUS") {return getColorRGB(50, 125, 75);}
        if(colour == "PANEL_BACKGROUND_FORCE") {return getColorRGB(200, 170, 140);}
        if(colour == "PANEL_BORDER_FORCE") {return getColorRGB(175, 125, 100);}
        if(colour == "MENU_BACKGROUND") {return getColorRGB(240, 228, 184);}
        if(colour == "MENU_TEXT") {return getColorRGB(0, 0, 0);}
        if(colour == "PANEL_BACKGROUND") {return getColorRGB(255, 255, 255);}
        if(colour == "PANEL_BORDER") {return getColorRGB(0, 0, 0);}
        if(colour == "PANEL_SHADOW") {return getColorRGB(200, 200, 200);}
        if(colour == "PANEL_TEXT") {return getColorRGB(0, 0, 0);}
        if(colour == "TERRAIN_1") {return getColorRGB(240, 228, 184);}
        if(colour == "UI_BAR_BACKGROUND") {return getColorRGB(0, 0, 0);}
        if(colour == "UI_BAR_HEALTH") {return getColorRGB(200, 20, 20);}
        if(colour == "UI_BAR_SHADOW") {return getColorRGB(20, 20, 20);}
        return Color.WHITE;
    }
    
    public static Color getColorRGB(int r, int g, int b)
    {
        float hsb[] = Color.RGBtoHSB(r,g,b,null);
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }
    
}