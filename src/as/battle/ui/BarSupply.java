package as.battle.ui;

import as.battle.Force;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import java.awt.Graphics;

public class BarSupply
{
    private Force force;
    private int barX, barY, barW, barH;
    private int countX, countY, countW, countH;

    public BarSupply(Force force)
    {
        this.force = force;
        
        // Progress Bar
        this.barX = 15;
        this.barY = 105;
        this.barW = 102;
        this.barH = 10;
        
        // Count Box
        this.countX = 114;
        this.countY = 89;
        this.countW = 30;
        this.countH = 25;
    }
    
    public void render(Graphics g)
    {
        this.renderBar(g);
        this.renderCount(g);
    }

    private void renderBar(Graphics g)
    {
        // Background
        g.setColor(Colour.getColorRGB(0, 0, 0));
        g.fillRect(this.barX + 2, this.barY, this.barW - 4, this.barH - 2);
        
        // Progress
        g.setColor(Colour.getColorRGB(153, 87, 189));
        g.fillRect(this.barX + 2, this.barY, this.force.getSupplyPercent(), this.barH - 2);
        
        // Border
        g.setColor(Colour.getColorRGB(97, 48, 122));
        g.fillRect(this.barX, this.barY, 2, this.barH);
        g.fillRect(this.barX + this.barW - 2, this.barY, 2, this.barH);
        g.fillRect(this.barX, this.barY + this.barH - 2, this.barW, 2);
    }

    private void renderCount(Graphics g)
    {
        // Background
        g.setColor(Colour.getColorRGB(0, 0, 0));
        g.fillRect(this.countX, this.countY, this.countW, this.countH);
        
        // Value
        g.setColor(Colour.getColorRGB(153, 87, 189));
        g.setFont(Fonts.getFont("PANEL_SUPPLY_COUNT"));
        Text.write(g, this.force.getSupplyCountAsString(), this.countX + (this.countW / 2), this.countY + 19, "CENTER");
        
        // Border
        g.setColor(Colour.getColorRGB(97, 48, 122));
        g.drawRect(this.countX, this.countY, this.countW, this.countH);
        g.drawRect(this.countX + 1, this.countY + 1, this.countW - 2, this.countH - 2);
    }

}