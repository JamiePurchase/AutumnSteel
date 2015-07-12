package as.battle.ui;

import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Fonts;
import as.gfx.Text;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ToolButton
{
    private String value;
    private Rectangle rect;
    
    public ToolButton(String value, int posX, int posY, int sizeX, int sizeY)
    {
        this.value = value;
        this.rect = new Rectangle(posX, posY, sizeX, sizeY);
    }
    
    public void render(Graphics g)
    {
        // Background
        g.setColor(Colour.getColor("BUTTON_BACKGROUND_FORCE"));
        if(this.rect.contains(Engine.getMousePoint())) {g.setColor(Colour.getColor("BUTTON_HOVER_FORCE"));}
        g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
        
        // Text
        g.setColor(Colour.getColor("BUTTON_TEXT_FORCE"));
        g.setFont(Fonts.getFont("BUTTON_STANDARD"));
        Text.write(g, this.value, this.rect.x + (this.rect.width / 2), this.rect.y + 22, "CENTER");
        
        // Border
        g.setColor(Colour.getColor("BUTTON_BORDER_FORCE"));
        g.drawRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
    }

}