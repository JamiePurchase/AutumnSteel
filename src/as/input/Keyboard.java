package as.input;

import as.app.Engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
    
    private String getKeyName(KeyEvent e)
    {
        // Command Keys
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {return "ENTER";}
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {return "ESCAPE";}
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {return "SPACE";}
        
        // Directional Keys
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {return "DOWN";}
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {return "LEFT";}
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {return "RIGHT";}
        if(e.getKeyCode() == KeyEvent.VK_UP) {return "UP";}
        
        // Unknown Key
        return "";
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if(this.getKeyName(e) != null) {Engine.getState().inputKey(this.getKeyName(e), "PRESS");}
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(this.getKeyName(e) != null) {Engine.getState().inputKey(this.getKeyName(e), "PRESS");}
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(this.getKeyName(e) != null) {Engine.getState().inputKey(this.getKeyName(e), "PRESS_DONE");}
    }
    
}