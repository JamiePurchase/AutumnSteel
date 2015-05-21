package as.gui;

import as.gfx.Colour;
import java.awt.Graphics;

public class BoardTile
{
    private int posX;
    private int posY;
    private NexusRect nexus;
    
    public BoardTile(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.nexus = new NexusRect(posX, posY, 100, 100);
    }
    
    public void render(Graphics g)
    {
        this.render(g, false);
    }
    
    public void render(Graphics g, boolean grid)
    {
        if(this.nexus.getHover())
        {
            g.setColor(Colour.getColorRGB(125, 125, 125));
            g.fillRect(this.posX, this.posY, 100, 100);
        }
        if(grid)
        {
            g.setColor(Colour.getColor("STEEL"));
            g.drawRect(this.posX, this.posY, 100, 100);
        }
    }
}