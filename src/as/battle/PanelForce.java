package as.battle;

import as.account.Account;
import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.states.StateBattle;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PanelForce extends Panel
{
    private StateBattle battle;
    private Force force;
    private Account account;

    public PanelForce(StateBattle battle, Force force, Account account)
    {
        super(new Rectangle(0, 0, Engine.width, 51), true, true, false);
        this.battle = battle;
        this.force = force;
        this.account = account;
        this.setColours("PANEL_BACKGROUND_FORCE", "PANEL_BORDER_FORCE", null);
        this.setBorders(false, true, false, false, 2, 0);
    }

    public void render(Graphics g)
    {
        super.render(g);
        this.renderAccount(g);
        this.renderResources(g);
    }
    
    private void renderAccount(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/uiForce.png"), 0, 0, null);
        g.drawImage(Drawing.resize(Drawing.getImage("forces/crest1.png"), 130, 90), 15, 15, null);
    }
    
    private void renderResources(Graphics g)
    {
        //
    }

}