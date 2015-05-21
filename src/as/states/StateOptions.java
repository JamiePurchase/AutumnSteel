package as.states;

import as.gfx.Colour;
import as.gfx.Drawing;
import as.gui.Frame;
import as.gui.MenuOption;
import java.awt.Graphics;
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
    }
    
    public void renderBackground(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/title.png"), 0, 0, null);
        g.drawImage(Drawing.getImage("interface/logo2.png"), 333, 50, null);
        
        // NOTE: glaze the entire screen over
    }
    
    public void renderOptions(Graphics g)
    {
        this.optionDone.render(g);
    }
    
    public void tick()
    {
        
    }
    
    public void touch(MouseEvent e)
    {
        if(this.listenTouch) {touchOptions(e);}
    }
    
    public void touchOptions(MouseEvent e)
    {
        
                /*this.option[x].setSelect(true);
                this.optionSelect = true;
                this.optionSelectID = x;
                this.optionSelectTick = 0;
                this.listenTouch = false;*/
    }
}