package as.states;

import as.account.Account;
import as.account.Banner;
import as.battle.BattleOld;
import as.card.Card;
import as.battle.Unit;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gui.NexusRect;
import as.server.Request;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StateBattleOld extends State
{
    // Battle
    private BattleOld battle;
    
    // Server
    private int serverTick;
    
    // Temp
    private boolean tempSelect;
    
    public StateBattleOld(BattleOld battle)
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
        this.battle.tick();
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
    
    public void touch(MouseEvent e, boolean p)
    {
        if(p) {this.battle.touch(e, p);}
    }
    
    public void type(KeyEvent e)
    {
        
    }
    
}