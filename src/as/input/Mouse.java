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
    
    private String getButton(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1) {return "LEFT";}
        if(e.getButton() == MouseEvent.BUTTON2) {return "WHEEL";}
        if(e.getButton() == MouseEvent.BUTTON3) {return "RIGHT";}
        return "";
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        Engine.setMousePoint(new Point(e.getX(), e.getY()));
        Engine.inputMouse(e, "MOVE", this.getButton(e));
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        Engine.inputMouse(e, "CLICK", this.getButton(e));
    }
    
    @Override
    public void mouseReleased (MouseEvent e)
    {
        Engine.inputMouse(e, "CLICK_DONE", this.getButton(e));
    }

}