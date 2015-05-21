package as.gui;

import java.awt.Graphics;
import javax.swing.JFormattedTextField;

public class Textbox extends JFormattedTextField
{
    private int posX;
    private int posY;
    
    public Textbox(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
        this.setValue("HELLO");
    }
    
    public void render(Graphics g)
    {
        this.paint(g);
    }
    
}