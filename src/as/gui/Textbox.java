package as.gui;

import as.gfx.Colour;
import as.gfx.Fonts;
import as.gfx.Text;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFormattedTextField;

public class Textbox
{
    private String value;
    private boolean focus;
    private int drawX;
    private int drawY;
    private int sizeX;
    private int sizeY;
    private NexusRect nexus;
    private int tick;
    
    public Textbox(int posX, int posY)
    {
        this.value = "";
        this.focus = false;
        this.drawX = posX;
        this.drawY = posY;
        this.sizeX = 300;
        this.sizeY = 40;
        this.nexus = new NexusRect(this.drawX, this.drawY - 30, this.sizeX, this.sizeY);
        this.tick = 0;
    }
    
    public void backspace()
    {
        if(this.value.length() > 0) {this.value = this.value.substring(0, this.value.length() - 1);}
    }
    
    public boolean getCollide(Point point)
    {
        return this.nexus.getCollide(point);
    }
    
    public boolean getFocus()
    {
        return this.focus;
    }
    
    public String getValue()
    {
        return this.value;
    }
    
    public void render(Graphics g)
    {
        // Background
        g.setColor(Colour.getColor("RED2"));
        g.fillRect(this.drawX, this.drawY - 30, this.sizeX, this.sizeY);
        
        // Border
        g.setColor(Colour.getColor("RED"));
        g.fillRect(this.drawX, this.drawY - 30, this.sizeX, this.sizeY);
        
        // Text
        String valueString = this.value;
        if(this.focus && this.tick < 30) {valueString = this.value + "|";}
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("BLACK"));
        Text.write(g, valueString, this.drawX + 10, this.drawY);
    }
    
    public void setFocus(boolean value)
    {
        this.focus = value;
    }
    
    public void tick()
    {
        this.tick += 1;
        if(this.tick > 60)
        {
            this.tick = 0;
        }
    }
    
    public void type(String character)
    {
        this.value = this.value + character;
    }
    
}