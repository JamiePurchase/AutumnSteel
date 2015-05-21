package as.input;

import as.app.Engine;
import as.debug.Console;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Mouse extends MouseAdapter implements MouseMotionListener
{
    private Point mousePoint;
    
    public Mouse()
    {
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        Engine.setMousePoint(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        Engine.touch(e);
    }

}