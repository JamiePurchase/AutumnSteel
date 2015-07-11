package as.battle;

import as.gfx.Colour;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Panel
{
    private Rectangle rect;

    public Panel(Rectangle rect)
    {
        this.rect = rect;
    }
    
    public Rectangle getRect()
    {
        return this.rect;
    }

    public void render(Graphics g)
    {
        this.renderBackground(g);
    }

    public void renderBackground(Graphics g)
    {
        // Shadow
        g.setColor(Colour.getColor("PANEL_SHADOW"));
        g.fillRect(this.rect.x + 1, this.rect.y + 1, this.rect.width, this.rect.height);
        g.fillRect(this.rect.x + 2, this.rect.y + 2, this.rect.width, this.rect.height);
        
        // Background
        g.setColor(Colour.getColor("PANEL_BACKGROUND"));
        g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
        
        // Border
        g.setColor(Colour.getColor("PANEL_BORDER"));
        g.drawRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
    }

}