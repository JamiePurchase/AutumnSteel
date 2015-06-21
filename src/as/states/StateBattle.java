package as.states;

import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Tileset;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class StateBattle extends State
{
    int tempFlagTick, tempFlagFrame;
    Tileset tempTileset;
    Boolean tempHighlight;
    
    public StateBattle()
    {
        this.tempFlagTick = 0;
        this.tempFlagFrame = 0;
        this.tempTileset = new Tileset("flagPurple", Drawing.getImage("forces/flagPurple.png"), 100, 100, 4, 1);
        this.tempHighlight = false;
    }
    
    public void render(Graphics g)
    {
        // TEMP
        g.setColor(Colour.getColorRGB(240, 228, 184));
        g.fillRect(0, 0, 1366, 768);
        
        // TEMP (nexus area)
        /*g.setColor(Colour.getColorRGB(25, 75, 25));
        g.fillRect(520, 367, 60, 66);*/
        
        renderGrid(g);
        
        // TEMP FLAG
        g.drawImage(this.tempTileset.getTileAt(this.tempFlagFrame, 0), 470, 260, null);
        
        // TEMP UNIT
        if(this.tempHighlight) {g.drawImage(Drawing.getImage("forces/tile3purple.png"), 500, 350, null);}
        g.drawImage(Drawing.getImage("units(old)/samurai/0.png"), 510, 340, null);
        
        // TEMP UNIT
        g.drawImage(Drawing.getImage("units(old)/archer/0.png"), 610, 190, null);
        
        // TEMP BUILDING
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
        this.tempFlagTick += 1;
        if(this.tempFlagTick > 3)
        {
            this.tempFlagTick = 0;
            this.tempFlagFrame += 1;
            if(this.tempFlagFrame >= 4) {this.tempFlagFrame = 0;}
        }
    }

    public void touch(MouseEvent e, boolean p)
    {
        if(new Rectangle(520, 367, 60, 66).contains(e.getPoint()))
        {
            this.tempHighlight = true;
        }
    }

    public void type(KeyEvent e)
    {
        //
    }
    
}