package as.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class State
{
    public abstract void render(Graphics g);
    public abstract void tick();
    public abstract void touch(MouseEvent e);
}