package as.app;

import as.account.Account;
import as.debug.Console;
import as.input.Keyboard;
import as.input.Mouse;
import as.states.State;
import as.states.StateInit;
import as.states.StateLogin;
import as.states.StateTitle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Engine extends JPanel implements Runnable
{
    private static final String appAuthor = "Jamie Purchase";
    private static final String appVersion = "Version 0.1 (21/05/2015)";
    private static final long serialVersionUID = 1L;
    public static Display display;
    public static int width, height;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private static Keyboard keyboard;
    private static Mouse mouse;
    private static Point mousePoint;
    private static State state;
    private static Account account;

    public Engine()
    {
        // Main Settings
        this.width = 1366;
        this.height = 768;

        // Input Devices
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
    }

    private void init()
    {
        // Create Display
        this.display = new Display();

        // Initial State
        this.setState(new StateInit());
        
        // Temp
        /*this.setAccount(new Account(1));
        this.setState(new StateTitle());*/
    }
    
    public static Account getAccount()
    {
        return account;
    }
    
    public static String getAppAuthor()
    {
        return appAuthor;
    }
    
    public static String getAppVersion()
    {
        return appVersion;
    }
    
    public static Keyboard getKeyboard()
    {
        return keyboard;
    }
    
    public static Mouse getMouse()
    {
        return mouse;
    }
    
    public static Point getMousePoint()
    {
        return mousePoint;
    }

    public static String getResourcePath()
    {
        return "C:/Users/Jamie/Documents/NetBeansProjects/AutumnSteel/";
    }
    
    public static State getState()
    {
        return state;
    }

    private void render()
    {
        // Buffer strategy
        bs = this.display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            this.display.getCanvas().createBufferStrategy(3);
            return;
        }

        // Graphics start
        g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // Graphics draw
        if(this.state != null)
        {
            this.getState().render(g);
        }

        // Graphics done
        bs.show();
        g.dispose();
    }

    public void run()
    {
        // Render speed
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        // Create window
        init();

        // Main game loop
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if(delta >= 1)
            {			
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000)
            {
                ticks = 0;
                timer = 0;
            }
        }

        // End game
        stop();
    }
    
    public static void setAccount(Account newAccount)
    {
        account = newAccount;
    }
    
    public static void setMousePoint(Point newPoint)
    {
        mousePoint = newPoint;
    }
    
    public static void setState(State newState)
    {
        state = newState;
    }

    public synchronized void start()
    {
        if(running==false)
        {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop()
    {
        if(running==true)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void tick()
    {
        // Network Update
        //tickNetwork();

        // State
        this.getState().tick();
    }
    
    public static void touch(MouseEvent e, boolean pressed)
    {
        getState().touch(e, pressed);
    }
}