package as.states;

import as.gfx.Colour;
import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateBattle extends State
{
    
    public StateBattle()
    {
        
    }
    
    public void render(Graphics g)
    {
        // TEMP
        g.setColor(Colour.getColorRGB(240, 228, 184));
        g.fillRect(0, 0, 1366, 768);
        
        // TEMP
        g.drawImage(Drawing.getImage("forces/tile2.png"), 500, 200, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 600, 200, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 700, 200, null);
        //
        g.drawImage(Drawing.getImage("forces/tile2.png"), 450, 275, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 550, 275, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 650, 275, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 750, 275, null);
        //
        g.drawImage(Drawing.getImage("forces/tile2.png"), 500, 350, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 600, 350, null);
        g.drawImage(Drawing.getImage("forces/tile2.png"), 700, 350, null);
        
        // TEMP
        g.drawImage(Drawing.getImage("forces/standard1.png"), 470, 260, null);
        g.drawImage(Drawing.getImage("units(old)/samurai/0.png"), 510, 330, null);
        
        // TEMP
        g.drawImage(Drawing.getImage("forces/building1.png"), 700, 300, null);
    }
    
    public void tick()
    {
        //
    }

    public void touch(MouseEvent e, boolean p)
    {
        //
    }

    public void type(KeyEvent e)
    {
        //
    }
    
}