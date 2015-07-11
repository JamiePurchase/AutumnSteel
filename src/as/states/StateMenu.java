package as.states;

import as.menu.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class StateMenu extends State
{
    private Menu menu;

    public StateMenu()
    {
        // Initial Menu
        this.setMenu(new MenuDev());
    }
    
    public Menu getMenu()
    {
        return this.menu;
    }

    public void inputKeyPress(String key)
    {
        this.menu.inputKeyPress(key);
    }

    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputMouseClickL(MouseEvent e)
    {
        System.out.println("*** STATE DETECTED CLICK");
        this.menu.inputMouseClickL(e);
    }
    
    public void inputMouseClickR(MouseEvent e)
    {
        //
    }

    public void inputMouseMove(MouseEvent e)
    {
        //
    }

    public void render(Graphics g)
    {
        this.menu.render(g);
    }
    
    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public void tick()
    {
        this.menu.tick();
    }
    
}
