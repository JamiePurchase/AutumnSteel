package as.states;

import as.account.AccountGateway;
import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.server.Request;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateInit extends State
{
    private String action = "LOAD";

    public StateInit()
    {
        //System.out.println(new File(".").getAbsolutePath());
        //this.configFind();

        //System.out.println(AccountGateway.loadAccount(0));
        
        // TEMP
        try {System.out.println(new Request("accountLoad", "accountID=1").get());}
        catch (IOException e) {System.out.println(e);}
        System.exit(0);
    }
    
    private void configFind()
    {
        
    }
    
    public void inputKeyPress(String key)
    {
        //
    }
    
    public void inputKeyRelease(String key)
    {
        //
    }
    
    public void inputMouseClickL(MouseEvent e)
    {
        //
    }
    
    public void inputMouseClickR(MouseEvent e)
    {
        //
    }
    
    public void inputMouseMove(MouseEvent e)
    {
        //
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        g.drawImage(Drawing.getImage("interface/php.png"), 208, 325, null);
        g.drawImage(Drawing.getImage("interface/java2.png"), 608, 275, null);
        g.drawImage(Drawing.getImage("interface/mySql.png"), 908, 300, null);
        renderAction(g);
        renderInformation(g);
    }
    
    public void renderAction(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        //Text.write(g, this.actionString, 683, 718, "CENTER");
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
        //this.actionTick += 1;
        tickAction();
    }
    
    public void tickAction()
    {
        /*if(this.action == 1)
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
                //Engine.setState(new StateTitle());
            }
        }*/
    }

}