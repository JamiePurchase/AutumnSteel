package as.states;

import as.app.Engine;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.Frame;
import as.gui.MenuOption;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class StateOptions extends State
{
    private Frame frame;
    private boolean listenTouch;
    private MenuOption optionDone;
    private boolean optionSelect;
    private int optionSelectID;
    private int optionSelectTick;
    
    public StateOptions()
    {
        this.listenTouch = true;
        this.frame = new Frame(333, 175, 700, 400);
        this.optionDone = new MenuOption("DONE", 800, 520);
        this.optionSelect = false;
        this.optionSelectID = 0;
        //this.optionSelectTick;
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        this.frame.render(g);
        renderOptions(g);
        renderHint(g);
    }
    
    public void renderBackground(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/title.png"), 0, 0, null);
        g.drawImage(Drawing.getImage("interface/logo2.png"), 333, 50, null);
        
        // NOTE: glaze the entire screen over
    }
    
    public void renderHint(Graphics g)
    {
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, "Your settings will be saved locally.", 50, 718);
        Text.write(g, Engine.getAppVersion(), 1316, 718, "RIGHT");
    }
    
    public void renderOptions(Graphics g)
    {
        this.optionDone.render(g);
    }
    
    public void tick()
    {
        
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        if(this.listenTouch && p) {touchOptions(e);}
    }
    
    public void touchOptions(MouseEvent e)
    {
        if(this.optionDone.getCollide(e.getPoint()))
        {
            Engine.setState(new StateTitle());
        }
    }
    
    public void type(KeyEvent e)
    {
        
    }
}