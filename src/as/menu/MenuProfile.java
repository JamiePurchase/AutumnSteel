package as.menu;

import as.gfx.Colour;
import as.gfx.Fonts;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class MenuProfile extends Menu
{

    public MenuProfile()
    {
        super("PROFILE");
    }
    
    public void inputKeyPress(String key)
    {
        //
    }
    
    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputMouseClickL(MouseEvent e)
    {
        super.inputMouseClickL(e);
    }

    public void inputMouseClickR(MouseEvent e)
    {
        super.inputMouseClickR(e);
    }

    public void inputMouseRelease(MouseEvent e)
    {
        //
    }

    public void renderMenu(Graphics g)
    {        
        // Content
        g.setColor(Colour.getColor("MENU_TEXT"));
        g.setFont(Fonts.getFont("MENU_STANDARD"));
        g.drawString("Jamie", 150, 180);
    }

}