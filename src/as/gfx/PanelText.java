package as.gfx;

import java.awt.Graphics;
import java.awt.Rectangle;

public class PanelText extends Panel
{
    private String text;

    public PanelText(String text, int posX, int posY, int sizeX, int sizeY)
    {
        super(new Rectangle(posX, posY, sizeX, sizeY));
        this.text = text;
    }

    public PanelText(String text, Rectangle rect)
    {
        super(rect);
        this.text = text;
    }
    
    public int getTextX()
    {
        return this.getRect().x + 15;
    }
    
    public int getTextY()
    {
        return this.getRect().y + 27;
    }

    public void render(Graphics g)
    {
        super.render(g);
        this.renderText(g);
    }
    
    public void renderText(Graphics g)
    {
        g.setColor(Colour.getColor("PANEL_TEXT"));
        g.setFont(Fonts.getFont("PANEL_BOLD"));
        g.drawString("HINT", this.getTextX(), this.getTextY());
        g.setFont(Fonts.getFont("PANEL_STANDARD"));
        g.drawString(this.text, this.getTextX() + 75, this.getTextY());
    }
    
    public void setText(String text)
    {
        this.text = text;
    }

}