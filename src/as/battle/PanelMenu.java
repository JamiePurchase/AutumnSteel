package as.battle;

import as.app.Engine;
import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PanelMenu extends Panel
{
    private boolean menuActive;
    private BufferedImage background;
    private ArrayList<PanelMenuOption> optionArray;
    private int optionNow;

    public PanelMenu(Rectangle rect)
    {
        super(rect);
        this.menuActive = false;
        this.background = null;
        this.optionArray = new ArrayList();
        this.optionNow = 0;
    }

    public void addOption(String name, int posX, int posY)
    {
        this.optionArray.add(new PanelMenuOption(this, name, posX, posY));
    }
    
    public boolean getActive()
    {
        return this.menuActive;
    }
    
    public BufferedImage getBackground()
    {
        return this.background;
    }
    
    public Graphics2D getBackgroundNew()
    {
        this.background = new BufferedImage(Engine.width, Engine.height, BufferedImage.TYPE_INT_ARGB);
        return this.background.createGraphics();
    }
    
    public void inputKey(String key)
    {
        if(key.equals("ENTER"))
        {
            // this.optionArray.get(optionNow).select();
            // need to attach action events to the options
            
            if(this.optionNow == 0) {this.setActive(false);}
        }
        if(key.equals("UP"))
        {
            if(this.optionNow > 0) {this.optionNow --;}
        }
        if(key.equals("DOWN"))
        {
            if(this.optionNow < this.optionArray.size() - 1) {this.optionNow ++;}
        }
        if(key.equals("ESCAPE")) {this.setActive(false);}
    }

    public void render(Graphics g)
    {
        g.drawImage(this.getBackground(), 0, 0, null);
        Drawing.fadeScreen(g);
        this.renderBackground(g);
        this.renderOptions(g);
    }
    
    private void renderOptions(Graphics g)
    {
        for(int x = 0; x < this.optionArray.size(); x++)
        {
            this.optionArray.get(x).render(g);
        }
    }
    
    public void setActive(boolean active)
    {
        this.menuActive = active;
    }
    
    public void setBackground(BufferedImage image)
    {
        this.background = image;
    }

}