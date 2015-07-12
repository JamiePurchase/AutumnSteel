package as.battle;

import as.account.Account;
import as.app.Engine;
import as.battle.ui.BarSupply;
import as.battle.ui.ToolButton;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.states.StateBattle;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PanelForce extends Panel
{
    private StateBattle battle;
    private Force force;
    private Account account;
    private BarSupply supply;
    private ToolButton buttonMenu;

    public PanelForce(StateBattle battle, Force force, Account account)
    {
        super(new Rectangle(0, 0, Engine.width, 51), true, true, false);
        this.battle = battle;
        this.force = force;
        this.account = account;
        this.supply = new BarSupply(force);
        this.buttonMenu = new ToolButton("MENU", 1276, 10, 80, 30);
        this.setColours("PANEL_BACKGROUND_FORCE", "PANEL_BORDER_FORCE", null);
        this.setBorders(false, true, false, false, 2, 0);
    }

    public void render(Graphics g)
    {
        super.render(g);
        this.renderAccount(g);
        this.renderOptions(g);
        this.renderResources(g);
    }
    
    private void renderAccount(Graphics g)
    {
        // Toolbar
        g.drawImage(Drawing.getImage("interface/uiForce.png"), 0, 0, null);
        
        // Crest and Supply Bar
        g.drawImage(Drawing.resize(Drawing.getImage("forces/crest1.png"), 130, 90), 15, 15, null);
        this.supply.render(g);
        
        // Account Name
        g.setColor(Colour.getColor("MENU_TEXT"));
        g.setFont(Fonts.getFont("PANEL_BOLD"));
        g.drawString(this.account.getUsername(), 165, 35);
        g.setFont(Fonts.getFont("PANEL_ITALIC"));
        g.drawString(this.account.getTitle().getName(), 165, 65);
    }
    
    private void renderOptions(Graphics g)
    {
        this.buttonMenu.render(g);
    }
    
    private void renderResources(Graphics g)
    {
        //
    }

}