package as.menu;

import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Fonts;
import as.gfx.PanelText;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class Menu
{
    // Visual
    private String title;
    private PanelText hint;

    // Frame
    private int tickNow, tickMax, frameNow, frameMax;
    
    // Input
    //private ArrayList<ActionKey> inputKey;
    //private ArrayList<ActionNexus> inputNexus;

    public Menu(String title)
    {
        // Visual
        this.title = title;
        this.hint = new PanelText("HELLO", 15, Engine.height - 55, Engine.width - 30, 40);
        
        // Frame
        this.tickNow = 0;
        this.tickMax = 12;
        this.frameNow = 0;
        this.frameMax = 0;
        
        // Input
        //this.inputKey = new ArrayList();
        //this.inputNexus = new ArrayList();
        
        // NOTE: we need each menu to have a collection of keyboard and nexus objects
        // rather than calling inputMouseClick(), just say inputKey() or inputNexus()
    }
    
    public abstract void inputKeyPress(String key);

    public void inputMouseClickL(MouseEvent e)
    {
        System.out.println("*** MENU DETECTED CLICK");
        // loop through inputNexus and see if something was clicked on
        this.hint.setText("CLICK");
    }

    public void inputMouseClickR(MouseEvent e)
    {
        //
    }
    
    public void render(Graphics g)
    {
        this.renderBackground(g);
        this.renderTitle(g);
        this.renderMenu(g);
        this.renderHint(g);
        // NOTE: consider a help bar at the bottom that hints at how to navigate
    }
    
    public void renderBackground(Graphics g)
    {
        g.setColor(Colour.getColor("MENU_BACKGROUND"));
        g.fillRect(0, 0, Engine.width, Engine.height);
    }
    
    public void renderHint(Graphics g)
    {
        hint.render(g);
    }
    
    public abstract void renderMenu(Graphics g);
    
    public void renderTitle(Graphics g)
    {
        g.setColor(Colour.getColor("MENU_TEXT"));
        g.setFont(Fonts.getFont("MENU_TITLE"));
        g.drawString(this.title, 150, 65);
        g.fillRect(135, 75, 250, 3);
    }

    public void tick()
    {
        this.tickFrame();
    }

    private void tickFrame()
    {
        this.tickNow ++;
        if(this.tickNow >= this.tickMax)
        {
            this.tickNow = 0;
            this.frameNow ++;
            if(this.frameNow >= this.frameMax)
            {
                this.frameNow = 0;
            }
        }
    }

}