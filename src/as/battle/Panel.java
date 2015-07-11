package as.battle;

import as.gfx.Colour;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Panel
{
    private Rectangle rect;
    private boolean drawBackground, drawBorder, drawShadow;
    private boolean drawBorderN, drawBorderS, drawBorderE, drawBorderW;
    private String rgbBackground, rgbBorder, rgbShadow;
    private int widthBorder, widthShadow;

    public Panel(Rectangle rect)
    {
        this.rect = rect;
        this.drawBackground = true;
        this.drawBorder = true;
        this.drawBorderE = true;
        this.drawBorderN = true;
        this.drawBorderS = true;
        this.drawBorderW = true;
        this.drawShadow = true;
        this.rgbBackground = "PANEL_BACKGROUND";
        this.rgbBorder = "PANEL_BORDER";
        this.rgbShadow = "PANEL_SHADOW";
        this.widthBorder = 1;
        this.widthShadow = 2;
    }

    public Panel(Rectangle rect, boolean background, boolean border, boolean shadow)
    {
        this.rect = rect;
        this.drawBackground = background;
        this.drawBorder = border;
        this.drawShadow = shadow;
    }
    
    public Rectangle getRect()
    {
        return this.rect;
    }

    public void render(Graphics g)
    {
        this.renderBackground(g);
    }

    public void renderBackground(Graphics g)
    {
        // Shadow
        if(this.drawShadow)
        {
            g.setColor(Colour.getColor(this.rgbShadow));
            for(int s = 0; s < this.widthShadow; s++)
            {
                g.fillRect(this.rect.x + s + 1, this.rect.y + s + 1, this.rect.width, this.rect.height);
            }
        }
        
        // Background
        if(this.drawBackground)
        {
            g.setColor(Colour.getColor(this.rgbBackground));
            g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
        }
        
        // Border
        if(this.drawBorder)
        {
            g.setColor(Colour.getColor(this.rgbBorder));
            if(this.drawBorderN) {g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.widthBorder);}
            if(this.drawBorderS) {g.fillRect(this.rect.x, this.rect.y + this.rect.height - this.widthBorder, this.rect.width, this.widthBorder);}
            if(this.drawBorderW) {g.fillRect(this.rect.x, this.rect.y, this.widthBorder, this.rect.height);}
            if(this.drawBorderE) {g.fillRect(this.rect.x + this.rect.width - widthBorder, this.rect.y, this.widthBorder, this.rect.height);}
        }
    }
    
    public void setBorders(boolean n, boolean s, boolean e, boolean w, int border, int shadow)
    {
        this.drawBorderE = e;
        this.drawBorderN = n;
        this.drawBorderS = s;
        this.drawBorderW = w;
        this.widthBorder = border;
        this.widthShadow = shadow;
    }
    
    public void setColours(String background, String border, String shadow)
    {
        if(background != null) {this.rgbBackground = background;}
        if(border != null) {this.rgbBorder = border;}
        if(shadow != null) {this.rgbShadow = shadow;}
    }

}