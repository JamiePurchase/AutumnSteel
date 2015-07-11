package as.states;

import as.account.Account;
import as.account.Banner;
import as.app.Engine;
import as.debug.Console;
import as.execute.Tutorial;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.MenuOption;
import as.server.Request;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class StateTitle extends StateOld
{
    // Listeners
    private boolean listenTouch;
    
    // Options
    private MenuOption[] option = new MenuOption[4];
    private boolean optionSelect;
    private int optionSelectID;
    private int optionSelectTick;
    
    // Hints
    private String[] hintText = new String[4];
    private int hintNow = 0;
    private int hintTick = 0;
    private int hintWait = 360;
    
    private int tick;
    
    public StateTitle()
    {
        // Listeners
        this.listenTouch = true;
        
        // Temp
        this.tick = 0;
        
        // Options
        this.option[0] = new MenuOption("CAMPAIGN", 800, 300);
        this.option[1] = new MenuOption("MULTIPLAYER", 800, 350);
        this.option[2] = new MenuOption("TUTORIAL", 800, 400);
        this.option[3] = new MenuOption("OPTIONS", 800, 450);
        this.optionSelect = false;
        this.optionSelectID = 0;
        this.optionSelectTick = 0;
        
        // Hints
        this.hintNow = 0;
        this.hintText[0] = "Welcome to Autumn Steel";
        this.hintText[1] = "Learn the basics by playing through the tutorial";
        this.hintText[2] = "Challenge other players by entering the lobby";
        this.hintText[3] = "More information at autumn-steel.co.nf";
        this.hintTick = 0;
        this.hintWait = 360;
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderOptions(g);
        renderHint(g);
        renderInformation(g);
    }
    
    public void renderBackground(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/title.png"), 0, 0, null);
        g.drawImage(Drawing.getImage("interface/logo2.png"), 333, 50, null);
    }
    
    public void renderHint(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, this.hintText[this.hintNow], 50, 718);
    }
    
    public void renderInformation(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, Engine.getAppVersion(), 1316, 718, "RIGHT");
    }
    
    public void renderOptions(Graphics g)
    {
        for(int x = 0; x < this.option.length; x++)
        {
            this.option[x].render(g);
        }
    }
    
    public void tick()
    {
        this.tick += 1;
        tickHints();
        if(this.optionSelect) {tickOptions();}
    }
    
    public void tickHints()
    {
        this.hintTick += 1;
        if(this.hintTick > this.hintWait)
        {
            this.hintNow += 1;
            this.hintTick = 0;
            if(this.hintNow >= this.hintText.length)
            {
                this.hintNow = 0;
            }
        }
    }
    
    public void tickOptions()
    {
        this.optionSelectTick += 1;
        if(this.optionSelectTick > 5)
        {
            tickOptionsExecute();
        }
    }
    
    public void tickOptionsExecute()
    {
        
        // Campaign
        if(this.optionSelectID == 0)
        {
            //Engine.setState(new StateBattle());
        }
        
        // Multiplayer
        if(this.optionSelectID == 1)
        {
            //Engine.setState(new StateBattle());
        }
        
        // Tutorial
        if(this.optionSelectID == 2) {Tutorial.executeTutorial();}
        
        // Options
        //if(this.optionSelectID == 3) {Engine.setState(new StateOptions());}
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        if(this.listenTouch && p) {touchOptions(e);}
    }
    
    public void touchOptions(MouseEvent e)
    {
        for(int x = 0; x < this.option.length; x++)
        {
            if(this.option[x].getCollide(e.getLocationOnScreen()))
            {
                this.option[x].setSelect(true);
                this.optionSelect = true;
                this.optionSelectID = x;
                this.optionSelectTick = 0;
                this.listenTouch = false;
            }
        }
    }
    
    public void type(KeyEvent e)
    {
        
    }
}