package as.states;

import as.account.Account;
import as.account.Banner;
import as.battle.Battle;
import as.card.Card;
import as.battle.Unit;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gui.NexusRect;
import as.server.Request;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateBattle extends State
{
    // Battle
    private Battle battle;
    
    // Server
    private int serverTick;
    
    // Temp
    private boolean tempSelect;
    
    public StateBattle(Battle battle)
    {
        // Battle
        this.battle = battle;
        
        // Server
        this.serverTick = 0;
        
        // Temp
        this.tempSelect = false;
    }
    
    public void render(Graphics g)
    {
        this.battle.render(g);
    }
    
    public void tick()
    {
        tickServer();
    }
    
    public void tickServer()
    {
        this.serverTick += 1;
        if(this.serverTick > 120)
        {
            // Temp
            //new Account().updateOnline();
            
            this.serverTick = 0;
        }
    }
    
    public void touch(MouseEvent e)
    {
        this.battle.touch(e);
    }
    
}