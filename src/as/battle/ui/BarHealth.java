package as.battle.ui;

import as.battle.EntityUnit;
import as.gfx.Colour;
import as.gfx.Drawing;
import java.awt.Graphics;

public class BarHealth
{
    private EntityUnit unit;

    public BarHealth(EntityUnit unit)
    {
        this.unit = unit;
    }
    
    private int getPosX()
    {
        return this.unit.getDrawPosX();
    }
    
    private int getPosY()
    {
        return this.unit.getDrawPosY() - 25;
    }

    public void render(Graphics g)
    {
        // Shadow
        /*g.setColor(Colour.getColor("UI_BAR_SHADOW"));
        g.fillRect(this.getPosX() + 1, this.getPosY() + 1, 100, 25);
        g.fillRect(this.getPosX() + 2, this.getPosY() + 2, 100, 25);

        // Background
        g.setColor(Colour.getColor("UI_BAR_BACKGROUND"));
        g.fillRect(this.getPosX(), this.getPosY(), 100, 25);*/
        
        // TEMP
        Drawing.drawImageOpaque(g, Drawing.getImage("interface/barHealthBackground.png"), this.getPosX(), this.getPosY(), 0.5f);

        // Health
        g.setColor(Colour.getColor("UI_BAR_HEALTH"));
        g.fillRect(this.getPosX() + 2, this.getPosY() + 2, (int)this.unit.getStatsCondition("HEALTH").asPercent(), 19);
        
        g.drawImage(Drawing.getImage("interface/barHealthBorder.png"), this.getPosX(), this.getPosY(), null);
    }

}