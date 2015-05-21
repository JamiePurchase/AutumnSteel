package as.gui;

import java.awt.Point;

public class NexusCircle extends Nexus
{
    private int posX;
    private int posY;
    private final int radius;
    
    public NexusCircle(int posX, int posY, int radius)
    {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }
    
    public boolean getCollide(Point point)
    {
        if(Math.sqrt((point.x - this.posX) * (point.x - this.posX) + (point.y - this.posY) * (point.y - this.posY)) <= radius)
        {
            return true;
        }
        return false;
    }
}