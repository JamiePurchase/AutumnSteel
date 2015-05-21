package as.gui;

import as.gfx.Colour;
import java.awt.Graphics;
import java.awt.Point;

public class BoardTile
{
    private int posX;
    private int posY;
    private NexusRect nexus;
    private boolean unit;
    private int unitAlly;
    
    public BoardTile(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.nexus = new NexusRect(posX, posY, 100, 100);
        this.unit = false;
        this.unitAlly = 0;
    }
    
    public boolean getCollide(Point point)
    {
        return this.nexus.getCollide(point);
    }
    
    public boolean getUnit()
    {
        return this.unit;
    }
    
    public int getUnitAlly()
    {
        return this.unitAlly;
    }
    
    public void render(Graphics g)
    {
        this.render(g, false);
    }
    
    public void render(Graphics g, boolean grid)
    {
        if(this.nexus.getHover())
        {
            g.setColor(Colour.getColorRGB(125, 125, 125));
            g.fillRect(this.posX, this.posY, 100, 100);
        }
        if(grid)
        {
            g.setColor(Colour.getColor("STEEL"));
            g.drawRect(this.posX, this.posY, 100, 100);
        }
    }
    
    public void setUnit(boolean unit, int ally)
    {
        this.unit = unit;
        this.unitAlly = ally;
    }
}