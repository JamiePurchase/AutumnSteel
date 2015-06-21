package as.battle;

import as.account.Banner;
import as.app.Engine;
import as.card.Card;
import as.debug.Console;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gfx.Text;
import as.gui.BoardTile;
import as.gui.NexusRect;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BattleOld
{
    // Battle
    private int battleID;
    private String battleType;
    private String battleBkg;
    private boolean battlePause;
    private String battlePhase;
    private int battlePhaseTick, battlePhaseTickMax;
    
    // Display
    private boolean displayGrid;
    
    // Players
    private Player playerAlly;
    private Player playerEnemy;
    private BoardTile[][] playerTileAlly = new BoardTile[2][4];
    private BoardTile[][] playerTileEnemy = new BoardTile[2][4];
    
    // Units
    private Unit[] unitAlly = new Unit[8];
    private int unitAllyCount;
    private Unit[] unitEnemy = new Unit[8];
    private int unitEnemyCount;
    private boolean unitSelect;
    private int unitSelectAlly;
    
    // Turns
    private boolean turnStart;
    private int turnCount;
    private int turnPlayer;
    
    // Input
    private boolean inputListen;
    
    // Cards
    private boolean cardHold;
    //private int cardHold - identifier?
    
    // Temp
    private boolean tempSelect;
    private NexusRect tempNexus;
    
    public BattleOld(int battleID, String type, Player host, Player enemy)
    {
        // Battle
        this.battleID = battleID;
        this.battleType = type;
        this.battleBkg = "forest2";
        this.battlePause = false;
        this.battlePhase = "INIT";
        this.battlePhaseTick = 0;
        this.battlePhaseTickMax = 30;
        
        // Display
        this.displayGrid = false;
        
        // Player (Ally)
        this.playerAlly = host;
        this.playerTileAlly[0][0] = new BoardTile(300, 200);
        this.playerTileAlly[0][1] = new BoardTile(300, 300);
        this.playerTileAlly[0][2] = new BoardTile(300, 400);
        this.playerTileAlly[0][3] = new BoardTile(300, 500);
        this.playerTileAlly[1][0] = new BoardTile(400, 200);
        this.playerTileAlly[1][1] = new BoardTile(400, 300);
        this.playerTileAlly[1][2] = new BoardTile(400, 400);
        this.playerTileAlly[1][3] = new BoardTile(400, 500);

        // Player (Enemy)
        this.playerEnemy = enemy;
        this.playerTileEnemy[0][0] = new BoardTile(966, 200);
        this.playerTileEnemy[0][1] = new BoardTile(966, 300);
        this.playerTileEnemy[0][2] = new BoardTile(966, 400);
        this.playerTileEnemy[0][3] = new BoardTile(966, 500);
        this.playerTileEnemy[1][0] = new BoardTile(866, 200);
        this.playerTileEnemy[1][1] = new BoardTile(866, 300);
        this.playerTileEnemy[1][2] = new BoardTile(866, 400);
        this.playerTileEnemy[1][3] = new BoardTile(866, 500);
        
        // Units (Ally)
        this.unitAllyCount = 0;
        /*this.unitAlly[0] = new Unit(0, "Samurai", "FRONT", 1);
        this.playerTileAlly[1][1].setUnit(true, 0);
        this.unitAlly[1] = new Unit(0, "Archer", "BACK", 2);
        this.unitAlly[2] = new Unit(0, "Knight", "FRONT", 3);
        this.unitAlly[3] = new Unit(0, "Mage", "BACK", 0);
        this.unitAllyCount = 4;*/
        this.unitSelect = false;
        this.unitSelectAlly = 0;
        
        // Units (Enemy)
        this.unitEnemyCount = 0;
        /*this.unitEnemy[0] = new Unit(1, "Archer", "BACK", 1);
        this.unitEnemy[1] = new Unit(1, "Berserker", "FRONT", 2);
        this.unitEnemyCount = 2;*/
        
        // Cards
        this.cardHold = false;
        
        // Turns
        this.turnStart = false;
        this.turnCount = 0;
        this.turnPlayer = 0;
        
        // Temp
        this.tempSelect = false;
        
        // Input
        this.inputListen = true;
    }
    
    public String getBattlePhase()
    {
        return this.battlePhase;
    }
    
    public Player getPlayerAlly()
    {
        return this.playerAlly;
    }
    
    public Player getPlayerEnemy()
    {
        return this.playerEnemy;
    }
    
    public void highlightClear()
    {
        for(int row = 0; row <= 1; row++)
        {
            for(int tile = 0; tile < 4; tile++)
            {
                this.playerTileAlly[row][tile].setHighlight(0);
            }
        }
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderCastle(g);
        renderTiles(g);
        renderDeck(g);
        renderUnits(g);
        renderTurnInfo(g);
        renderBanner(g);
        //renderInterface(g);
        
        if(this.battlePhase == "CARD_INIT")
        {
            renderCardStart(g);
        }
        
        if(this.battlePhase == "TURN")
        {
            renderHand(g);
            
            // Temp
            if(this.cardHold)
            {
                // NOTE: may want to use a separate mouse movement listener for this (dragging?)
                //Drawing.drawImageOpaque(g, Drawing.getImage("interface/cardFS.png"), Engine.getMousePoint().x - 50, Engine.getMousePoint().y - 75, 0.5f);
                
                // NOTE: we need to use the BufferedImage created by getAnimImage() and draw that with opacity
                Card cardTemp = new Card("1");
                cardTemp.renderOpaque(g);
            }
        }
        
        // Temp
        //new Card("1").render(g);
    }
    
    public void renderBackground(Graphics g)
    {
        //g.drawImage(Drawing.getImage("background/" + this.battleBkg + ".png"), 0, 0, null);
        g.drawImage(Drawing.getImage("background/table.png"), 0, 0, null);
    }
    
    public void renderBanner(Graphics g)
    {
        g.drawImage(Drawing.getImage("interface/hudPlayers.png"), 0, 0, null);
    }
    
    public void renderBannerOld(Graphics g)
    {
        // Background
        /*g.setColor(Colour.getColor("STEEL"));
        g.fillRect(0, 0, 400, 150);
        g.fillRect(966, 0, 400, 150);*/
        
        // Border
        g.setColor(Colour.getColor("BLACK"));
        g.drawRect(225, 50, 300, 50);
        //g.fillRect(399, 0, 2, 150);
        
        // Text
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("WHITE"));
        Text.write(g, this.playerAlly.getAccountUsername(), 250, 50);
        Text.write(g, this.playerEnemy.getAccountUsername(), 1316, 50, "RIGHT");
        
        // Player
        new Banner(0, 1).render(g, 50, 25);
        
        // Opponent
        new Banner(0, 1).render(g, 1116, 25);
    }
    
    public void renderCardStart(Graphics g)
    {
        Drawing.fadeScreen(g);
        new Card("1").render(g, "LARGE", 195, 250);
        new Card("2").render(g, "LARGE", 395, 250);
        new Card("3").render(g, "LARGE", 595, 250);
        new Card("4").render(g, "LARGE", 795, 250);
        new Card("5").render(g, "LARGE", 995, 250);
    }
    
    public void renderCastle(Graphics g)
    {
        // Flag Background
        g.setColor(Colour.getColorRGB(25, 75, 50));
        g.fillRect(65, 320, 120, 50);
        
        // Castle Image
        g.drawImage(Drawing.getImage("castle/0.png"), 50, 300, null);
        
        // Statistics
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("BLACK"));
        g.drawString("HP: " + playerAlly.getStatHealth(), 60, 275);
        g.drawString("AP: " + playerAlly.getStatAction(), 60, 310);
    }
    
    public void renderDeck(Graphics g)
    {
        // Deck Image
        g.drawImage(Drawing.getImage("interface/deck.png"), 50, 450, null);
        
        // Deck Statistics
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("BLACK"));
        g.drawString("DECK: " + playerAlly.getCardDeck().getCount(), 60, 600);
    }
    
    public void renderHand(Graphics g)
    {
        new Card("1").render(g, "SMALL", 413, 630);
        new Card("2").render(g, "SMALL", 523, 630);
        new Card("3").render(g, "SMALL", 633, 630);
        new Card("4").render(g, "SMALL", 743, 630);
        new Card("5").render(g, "SMALL", 853, 630);
    }
    
    public void renderInterface(Graphics g)
    {
        // Background
        g.setColor(Colour.getColor("STEEL"));
        g.fillRect(0, 618, 1366, 150);
        
        // Border
        g.setColor(Colour.getColor("BLACK"));
        g.fillRect(0, 618, 1366, 2);
    }
    
    public void renderTiles(Graphics g)
    {
        // Grid
        if(this.displayGrid)
        {
            g.setColor(Color.BLACK);
            g.drawRect(300, 300, 100, 100);
        }
        
        // Ally
        for(int tile = 0; tile < 4; tile++)
        {
            this.playerTileAlly[0][tile].render(g);
            this.playerTileAlly[1][tile].render(g);
        }
        
        // Enemy
        for(int tile = 0; tile < 4; tile++)
        {
            this.playerTileEnemy[0][tile].render(g);
            this.playerTileEnemy[1][tile].render(g);
        }
    }
    
    public void renderTurnInfo(Graphics g)
    {
        // NOTE: consider the styling of the frames later
        g.setColor(Color.BLACK);
        g.fillRect(608, 0, 150, 50);
        g.setFont(Fonts.getFont("Standard"));
        g.setColor(Colour.getColor("RED"));
        Text.write(g, "Turn Info", 683, 25, "CENTER");
    }
    
    public void renderUnits(Graphics g)
    {
        // Ally
        for(int unit = 0; unit < this.unitAllyCount; unit++)
        {
            this.unitAlly[unit].render(g);
        }
        
        // Enemy
        for(int unit = 0; unit < this.unitEnemyCount; unit++)
        {
            this.unitEnemy[unit].render(g);
        }
    }
    
    public void setBattlePhase(String phase, int tick, boolean listen)
    {
        this.battlePhase = phase;
        this.battlePhaseTick = 0;
        this.battlePhaseTickMax = tick;
        this.inputListen = listen;
    }
    
    public void tick()
    {
        if(this.battlePhase == "INIT")
        {
            this.battlePhaseTick += 1;
            if(this.battlePhaseTick > this.battlePhaseTickMax)
            {
                this.battlePhase = "CARD_INIT";
                this.battlePhaseTick = 0;
                this.inputListen = true;
            }
        }
        if(this.battlePhase == "CARD_DONE")
        {
            this.battlePhaseTick += 1;
            if(this.battlePhaseTick > this.battlePhaseTickMax)
            {
                this.battlePhase = "TURN";
                this.battlePhaseTick = 0;
                this.inputListen = true;
            }
        }
    }
    
    public void touch(MouseEvent e, boolean p)
    {
        if(p)
        {
            if(this.battlePhase == "CARD_INIT")
            {
                // Reveal cards
                this.battlePhase = "CARD_DONE";
                this.battlePhaseTick = 0;
            }
            if(this.battlePhase == "TURN")
            {
                touchHand(e);
            }

            if(this.inputListen)
            {
                touchInterface(e);

                // No unit currently selected
                //touchUnit(e);

                // Unit selected, actions available
                //touchTile(e);
                // touch hotspot?
            }
        }
        else
        {
            NexusRect top = new NexusRect(0, 0, 1366, 200);
            if(cardHold && top.getCollide(e.getPoint()))
            {
                Console.writeError("hand released at top of screen");
            }
        }
    }
    
    public void touchHand(MouseEvent e)
    {
        // Temp (card one)
        NexusRect hand1 = new NexusRect(413, 650, 100, 100);
        if(hand1.getCollide(e.getPoint()))
        {
            cardHold = true;
            this.playerTileAlly[0][0].setHighlight(1);
        }
        
        // Temp (slot one)
        if(this.playerTileAlly[0][0].getCollide(e.getPoint()))
        {
            // create unit
            this.cardHold = false;
            this.unitAlly[0] = new Unit(0, "Archer", "BACK", 0);
            this.playerTileAlly[0][0].setUnit(true, 0);
            this.unitAllyCount += 1;
            this.highlightClear();
            int newAmount = this.playerAlly.getStatAction() - 1;
            this.playerAlly.setStatAction(newAmount);
            // NOTE: create a method in the player class that allows x action to be taken off
        }
    }
    
    public void touchInterface(MouseEvent e)
    {
    }
    
    public void touchTile(MouseEvent e)
    {
        for(int row = 0; row <= 1; row++)
        {
            for(int tile = 0; tile < 4; tile++)
            {
                if(this.playerTileAlly[row][tile].getCollide(e.getLocationOnScreen()))
                {
                    if(this.playerTileAlly[row][tile].getUnit())
                    {
                        this.unitAlly[this.playerTileAlly[row][tile].getUnitAlly()].setSelect(true);
                        this.unitSelect = true;
                        this.unitSelectAlly = this.playerTileAlly[row][tile].getUnitAlly();
                        this.displayGrid = true;
                    }
                }
            }
        }
    }
    
    public void touchUnit(MouseEvent e)
    {
        if(this.inputListen)
        {
            /*for(int unit = 0; unit < this.unitAllyCount; unit++)
            {
                if(this.playerAlly[unit].getCollide(e.getLocationOnScreen()))
                {
                    this.unitSelect = true;
                    this.unitSelectAlly = unit;
                }
            }*/
        }
    }
    
}