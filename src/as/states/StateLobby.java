package as.states;

import as.gfx.Drawing;
import as.gfx.Text;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateLobby extends State
{

    public StateLobby()
    {
        
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        Text.write(g, "Lobby", 300, 300);
    }
    
    public void tick()
    {
        
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        
    }
    
    public void type(KeyEvent e)
    {
        
    }
}