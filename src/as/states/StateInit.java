package as.states;

import as.account.Account;
import as.app.Engine;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.server.Request;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateInit extends State
{
    private int action;
    private String actionString;
    private int actionTick;
    
    public StateInit()
    {
        this.action = 1;
        this.actionString = "Connecting to server...";
        this.actionTick = 0;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        g.drawImage(Drawing.getImage("interface/java2.png"), 608, 250, null);
        renderAction(g);
        renderInformation(g);
    }
    
    public void renderAction(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, this.actionString, 683, 500, "CENTER");
    }
    
    public void renderInformation(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, Engine.getAppAuthor(), 50, 718);
        Text.write(g, Engine.getAppVersion(), 1316, 718, "RIGHT");
    }
    
    public void tick()
    {
        this.actionTick += 1;
        tickAction();
    }
    
    public void tickAction()
    {
        if(this.action == 1)
        {
            if(this.actionTick > 4)
            {
                // Connect to the server
                String response = "";
                try
                {
                    response = new Request("connect").get();
                    // What if this takes too long?
                }
                catch (Exception ex)
                {
                    Logger.getLogger(StateTitle.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(response.equals("SUCCESS"))
                {
                    this.action = 2;
                    this.actionString = "Connection established.";
                    this.actionTick = 0;
                }
            }
        }
        if(this.action == 2)
        {
            if(this.actionTick > 60)
            {
                //Engine.setState(new StateLogin());
                
                // Temp
                Engine.setAccount(new Account(1));
                Engine.setState(new StateTitle());
            }
        }
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        
    }
    
    public void type(KeyEvent e)
    {
        
    }

}