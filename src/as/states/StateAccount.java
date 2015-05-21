package as.states;

import as.gfx.Drawing;
import as.gfx.Text;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateAccount extends State
{

    public StateAccount()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        Text.write(g, "Username", 300, 300);
        Text.write(g, "Location", 300, 350);
    }
    
    public void tick()
    {
        
    }
    
    public void touch(MouseEvent e)
    {
        
    }
    
    public void type(KeyEvent e)
    {
        
    }
    
}