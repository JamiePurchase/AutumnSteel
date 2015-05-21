package as.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Text
{
    
    public static int getTextWidth(Graphics g, String text)
    {
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics().getFontMetrics(g.getFont()).stringWidth(text);
    }

    public static void write(Graphics g, String write, int posX, int posY)
    {
        g.drawString(write, posX, posY);
    }

    public static void write(Graphics g, String write, int posX, int posY, String align)
    {
        if(align == "CENTER") {posX = posX - (getTextWidth(g, write) / 2);}
        if(align == "RIGHT") {posX = posX - getTextWidth(g, write);}
        g.drawString(write, posX, posY);
    }
    
}