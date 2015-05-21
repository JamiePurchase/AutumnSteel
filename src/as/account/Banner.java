package as.account;

import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.Image;

public class Banner
{
    private Image background;
    private Image emblem;
    
    public Banner(int bkg, int emblem)
    {
        this.background = Drawing.getImage("banner/bkg/" + bkg + ".png");
        this.emblem = Drawing.getImage("banner/emblem/" + emblem + ".png");
    }
    
    public void render(Graphics g, int posX, int posY)
    {
        g.drawImage(this.background, posX, posY, null);
        g.drawImage(this.emblem, posX, posY, null);
    }
}