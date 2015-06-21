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
        
        renderGrid(g);
        
        // TEMP
        /*g.drawImage(Drawing.getImage("forces/tile2.png"), 500, 200, null);
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
        g.drawImage(Drawing.getImage("forces/tile2.png"), 700, 350, null);*/
        
        // TEMP
        g.drawImage(Drawing.getImage("forces/standard1.png"), 470, 260, null);
        g.drawImage(Drawing.getImage("units(old)/samurai/0.png"), 510, 340, null);
        g.drawImage(Drawing.getImage("units(old)/archer/0.png"), 610, 190, null);
        
        // TEMP
        g.drawImage(Drawing.getImage("forces/building1.png"), 700, 300, null);
    }
    
    public void renderGrid(Graphics g)
    {
        for(int x = 0; x < 15; x++)
        {
            for(int y = 0; y < 12; y++)
            {
                int posX = 100 * x - 100;
                int posY = 75 * y - 100;
                if(y % 2 != 0) {posX = posX + 50;}
                g.drawImage(Drawing.getImage("forces/tile2.png"), posX, posY, null);
            }
        }
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