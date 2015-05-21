package as.input;

import as.app.Engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{

    @Override
    public void keyTyped(KeyEvent e)
    {
        Engine.getState().type(e);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Engine.getState().type(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //
    }
    
}