package as.card;

import as.app.Display;
import as.app.Engine;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.NexusRect;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
    
    private BufferedImage getAnimImage(String size)
    {
        // NOTE: combine layers (card, picture, text, icons)
        BufferedImage image = Drawing.getImage("interface/cardBack2.png");
        //
        
        // Test 
        //BufferedImage imgNew = new BufferedImage(100, 150, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.drawImage(Drawing.getImage("cards/DarkKnight.png"), 50, 50, null);
        g2d.dispose();
        
        // Return the image of the necessary size
        if(size == "SMALL") {return Drawing.resize(image, 100, 150);}
        return image;
    }
    
    //public void render(Graphics g, int rotate)
    public void render(Graphics g, String size, int posX, int posY)
    {
        // NOTE: change these to use the getAnimImage() method
        if(size == "SMALL")
        {
            // NOTE: use the Drawing resize udf on the main image
            String image = "interface/cardFS.png";
            int wide = 100;
            int high = 150;
            g.drawImage(Drawing.getImage(image), posX, posY, null);

            // Temp
            g.setFont(Fonts.getFont("Standard"));
            g.setColor(Colour.getColor("BLACK"));
            Text.write(g, "1", posX + 10, posY + 30);
        }
        else
        {
            String image = "interface/cardBack.png";
            int wide = 175;
            int high = 225;
            g.drawImage(Drawing.getImage(image), posX, posY, null);
        }
    }
    
    public void renderOpaque(Graphics g)
    {
        Drawing.drawImageOpaque(g, this.getAnimImage("SMALL"), Engine.getMousePoint().x - 50, Engine.getMousePoint().y - 75, 0.5f);
    }
}