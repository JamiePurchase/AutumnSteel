package as.card;

import as.app.Display;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.NexusRect;
import java.awt.Graphics;

public class Card
{
    // Card Details
    private String cardCode;
    private String cardName;
    private String cardType;
    
    // Animation
    private boolean animPlay;
    private String animPhase;
    private int animTick;
    
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
    
    //public void render(Graphics g, int rotate)
    public void render(Graphics g, String size, int posX, int posY)
    {
        if(size == "SMALL") {this.renderSmall(g, posX, posY);}
        else
        {
            String image = "interface/cardBack.png";
            int wide = 175;
            int high = 225;
            g.drawImage(Drawing.getImage(image), posX, posY, null);
        }
    }
    
    public void renderSmall(Graphics g, int posX, int posY)
    {
        String image = "interface/cardFS.png";
        int wide = 100;
        int high = 150;
        g.drawImage(Drawing.getImage(image), posX, posY, null);
        
        // Temp
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("BLACK"));
        Text.write(g, "1", posX + 10, posY + 30);
    }
}