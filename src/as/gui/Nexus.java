package as.gui;

import as.app.Engine;
import java.awt.Point;

public abstract class Nexus
{
    public abstract boolean getCollide(Point point);
    
    public boolean getHover()
    {
        return this.getCollide(Engine.getMousePoint());
    }
}