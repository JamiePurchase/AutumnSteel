package as.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class StateOld
{
    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract void touch(MouseEvent e, boolean p);
    public abstract void type(KeyEvent e);
}