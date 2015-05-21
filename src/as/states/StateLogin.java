package as.states;

import as.account.Account;
import as.app.Engine;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.MenuOption;
import as.gui.Textbox;
import as.server.Request;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;

public class StateLogin extends State
{
    private String message;
    private Textbox inputUsername;
    private Textbox inputPassword;
    private MenuOption optionLogin;
    private boolean listenTouch;
    private boolean listenType;

    public StateLogin()
    {
        message = "Enter your username and password";
        inputUsername = new Textbox(600, 325);
        inputUsername.setFocus(true);
        inputPassword = new Textbox(600, 400);
        optionLogin = new MenuOption("LOGIN", 600, 475);
        listenTouch = true;
        listenType = true;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/logo.png"), 333, 50, null);
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, message, 683, 250, "CENTER");
        Text.write(g, "Username", 400, 325);
        Text.write(g, "Password", 400, 400);
        inputUsername.render(g);
        inputPassword.render(g);
        optionLogin.render(g);
    }
    
    public void submit()
    {
        message = "Logging in...";
        listenTouch = false;
        listenType = false;
        String response = "";
        try
        {
            response = new Request("login", "username=" + inputUsername.getValue() + "&password=" + inputPassword.getValue()).get();
            
            // Debug
            Console.write("Login Request: login.php?username=" + inputUsername.getValue() + "&password=" + inputPassword.getValue());
            Console.write(response);
            
            String[] responseArray = response.split("\\|");
            if(responseArray[0].equals("ERROR"))
            {
                if(responseArray[1].equals("1"))
                {
                    message = "Username not recognized";
                }
                if(responseArray[1].equals("2"))
                {
                    message = "Password was incorrect";
                }
            }
            if(responseArray[0].equals("SUCCESS"))
            {
                int accountID = Integer.parseInt(responseArray[1]);
                Engine.setAccount(new Account(accountID));
                Engine.setState(new StateTitle());
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(StateLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        listenTouch = true;
        listenType = true;
    }
    
    public void tick()
    {
        inputUsername.tick();
        inputPassword.tick();
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        if(this.listenTouch && p)
        {
            // NOTE: focus should be a property of this class of type abstract form control
            if(inputUsername.getCollide(e.getPoint()))
            {
                inputUsername.setFocus(true);
                inputPassword.setFocus(false);
            }
            if(inputPassword.getCollide(e.getPoint()))
            {
                inputPassword.setFocus(true);
                inputUsername.setFocus(false);
            }
            /*if(optionLogin.getCollide(e.getPoint()))
            {
                this.submit();
            }*/
        }
    }
    
    public void type(KeyEvent e)
    {
        if(this.listenType)
        {
            // Debug
            System.out.println(e.getKeyCode());
            
            // NOTE: the Textbox class should take-in the KeyEvent and be capable of working out if
            // it's a letter to add, delete key is pressed or whatever
            if(Character.isLetter(e.getKeyChar()))
            {
                if(inputUsername.getFocus())
                {
                    inputUsername.type(Character.toString(e.getKeyChar()));
                }
                if(inputPassword.getFocus())
                {
                    inputPassword.type(Character.toString(e.getKeyChar()));
                }
            }
            /*if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                this.submit();
            }*/
            /*if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE);
            {
                if(inputUsername.getFocus())
                {
                    inputUsername.backspace();
                }
                if(inputPassword.getFocus())
                {
                    inputPassword.backspace();
                }
            }*/
        }
    }
    
}