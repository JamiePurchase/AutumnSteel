package as.battle;

import as.account.Account;
import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.states.StateBattle;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PanelEntity extends Panel
{
    private StateBattle battle;
    private Force force;
    private Account account;

    public PanelEntity(StateBattle battle, Force force, Account account)
    {
        super(new Rectangle(0, Engine.height - 120, Engine.width, 120), true, true, false);
        this.battle = battle;
        this.force = force;
        this.account = account;
        this.setColours("PANEL_BACKGROUND_FORCE", "PANEL_BORDER_FORCE", null);
        this.setBorders(true, false, false, false, 2, 0);
    }

    public void render(Graphics g)
    {
        super.render(g);
        this.renderEntity(g);
    }
    
    private void renderEntity(Graphics g)
    {
        if(this.battle.selectUnit != null)
        {
            // Name (TEMP)
            g.setColor(Colour.getColor("PANEL_TEXT"));
            g.setFont(Fonts.getFont("PANEL_ENTITY"));
            g.drawString(this.battle.selectUnit.getName(), 40, this.getRect().y + 30);
            
            // Stats (TEMP)
            String textHealth = this.battle.selectUnit.getStatsCondition("HEALTH").getValue() + "/" + this.battle.selectUnit.getStatsCondition("HEALTH").getValueMax();
            String textEnergy = this.battle.selectUnit.getStatsCondition("ENERGY").getValue() + "/" + this.battle.selectUnit.getStatsCondition("ENERGY").getValueMax();
            g.setFont(Fonts.getFont("PANEL_STANDARD"));
            g.drawString("HEALTH", 30, this.getRect().y + 65);
            g.drawString(textHealth, 160, this.getRect().y + 65);
            g.drawString("ENERGY", 30, this.getRect().y + 95);
            g.drawString(textEnergy, 160, this.getRect().y + 95);
        }
    }

}