package as.card;

import as.app.Display;
import as.gfx.Drawing;
import java.awt.Graphics;

public class Card
{
    private String cardCode;
    private String cardName;
    private String cardType;
    
    public Card(String code)
    {
        this.cardCode = code;
        this.cardName = "";
        this.cardType = "";
    }
    
    public Card(String code, String name, String type)
    {
        this.cardCode = code;
        this.cardName = name;
        this.cardType = type;
    }
    
    public void render(Graphics g, int rotate)
    {
        Drawing.rotate(g, Drawing.getImage("units/samurai.png"), Display.getCanvas());
    }
}