package as.gui;

import as.app.Engine;
import java.awt.Graphics;
import java.awt.Point;

public class NexusRect extends Nexus
{
    private int posX1;
    private int posY1;
    private int sizeX;
    private int sizeY;
    
    public NexusRect(int posX, int posY, int wide, int high)
    {
        this.posX1 = posX;
        this.posY1 = posY;
        this.sizeX = wide;
        this.sizeY = high;
    }
    
    public boolean getCollide(Point point)
    {
        if(point.x >= this.posX1 && point.x <= this.getPosX2() && point.y >= this.posY1 && point.y <= this.getPosY2())
        {
            return true;
        }
        return false;
    }
    
    private int getPosX2()
    {
        return this.posX1 + this.sizeX;
    }
    
    private int getPosY2()
    {
        return this.posY1 + this.sizeY;
    }
    
    public void renderOutline(Graphics g)
    {
        g.drawRect(this.posX1, this.posY1, this.sizeX, this.sizeY);
    }
}