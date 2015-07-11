package as.battle;

import java.awt.Graphics;

public class PanelMenuOption
{
    private PanelMenu menu;
    private String name;
    private int posX, posY;
    private String action;

    public PanelMenuOption(PanelMenu menu, String name, int posX, int posY)
    {
        this.menu = menu;
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.action = action;
    }
    
    private int getDrawPosX()
    {
        return this.menu.getRect().x + posX;
    }
    
    private int getDrawPosY()
    {
        return this.menu.getRect().y + posY;
    }
    
    public void render(Graphics g)
    {
        g.drawString(name, this.getDrawPosX(), this.getDrawPosY());
    }
    
    public void select()
    {
        
    }

}