package as.states;

import as.gfx.Drawing;
import as.gfx.Text;
import as.gui.Textbox;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JFormattedTextField;

public class StateLogin extends State
{
    private String state;
    private Textbox inputUsername;
    private Textbox inputPassword;

    public StateLogin()
    {
        this.state = "WAIT";
        inputUsername = new Textbox(600, 350);
        inputPassword = new Textbox(600, 400);
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        if(this.state == "WAIT")
        {
            Text.write(g, "Username", 400, 350);
            Text.write(g, "Password", 400, 400);
            inputUsername.render(g);
            inputPassword.render(g);
        }
    }
    
    public void tick()
    {
        
    }
    
    public void touch(MouseEvent e)
    {
        
    }
    
}