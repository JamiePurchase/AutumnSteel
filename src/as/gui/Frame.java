package as.gui;

import as.gfx.Colour;
import java.awt.Graphics;

public class Frame
{
    private int posX1;
    private int posY1;
    private int sizeX;
    private int sizeY;
    
    public Frame(int wide, int high)
    {
        this.posX1 = 638 - (wide / 2);
        this.posY1 = 384 - (high / 2);
        this.sizeX = wide;
        this.sizeY = high;
    }
    
    public Frame(int posX, int posY, int wide, int high)
    {
        this.posX1 = posX;
        this.posY1 = posY;
        this.sizeX = wide;
        this.sizeY = high;
    }
    
    public void render(Graphics g)
    {
        // Shadow
        g.setColor(Colour.getColor("SHADOW"));
        g.fillRect(this.posX1 + 2, this.posY1 + 2, this.sizeX, this.sizeY);
        
        // Background
        g.setColor(Colour.getColor("STEEL"));
        g.fillRect(this.posX1, this.posY1, this.sizeX, this.sizeY);
        
        // Border
        g.setColor(Colour.getColor("BLACK"));
        g.drawRect(this.posX1, this.posY1, this.sizeX, this.sizeY);
    }
}