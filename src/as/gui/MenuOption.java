package as.gui;

import as.app.Engine;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Fonts;
import as.gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class MenuOption
{
    private String text;
    private int posX;
    private int posY;
    private NexusRect nexus;
    private boolean select;
    
    public MenuOption(String text, int posX, int posY)
    {
        this.text = text;
        this.posX = posX;
        this.posY = posY;
        this.nexus = new NexusRect(this.posX, this.posY - 30, 200, 40);
        this.select = false;
    }
    
    public boolean getCollide(Point point)
    {
        return this.nexus.getCollide(point);
    }
    
    public void render(Graphics g)
    {
        // Shadow
        g.setColor(Colour.getColor("SHADOW"));
        g.fillRect(this.posX + 2, this.posY - 28, 200, 40);
        
        // Test
        if(this.select)
        {
            // Background
            g.setColor(Colour.getColor("STEEL"));
            g.fillRect(this.posX + 1, this.posY - 29, 200, 40);

            // Border
            g.setColor(Colour.getColor("BLACK"));
            g.drawRect(this.posX + 1, this.posY - 29, 200, 40);

            // Text
            g.setFont(Fonts.getFont("Standard"));
            g.setColor(Colour.getColor("BLACK"));
            Text.write(g, this.text, this.posX + 11, this.posY + 1);
        }
        else
        {
            // Background
            g.setColor(Colour.getColorRGB(75, 75, 75));
            if(this.nexus.getHover()) {g.setColor(Colour.getColorRGB(125, 125, 125));}
            g.fillRect(this.posX, this.posY - 30, 200, 40);

            // Border
            g.setColor(Colour.getColor("BLACK"));
            g.drawRect(this.posX, this.posY - 30, 200, 40);

            // Text
            g.setFont(Fonts.getFont("Standard"));
            g.setColor(Colour.getColor("BLACK"));
            Text.write(g, this.text, this.posX + 10, this.posY);
        }
    }
    
    public void setSelect(boolean value)
    {
        this.select = value;
    }
    
}