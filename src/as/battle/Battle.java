package as.battle;

import as.account.Banner;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Fonts;
import as.gui.BoardTile;
import as.gui.NexusRect;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Battle
{
    // Battle
    private int battleID;
    private String battleType;
    private String battleBkg;
    private boolean battlePause;
    
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
    
    // Turns
    private boolean turnStart;
    private int turnCount;
    private int turnPlayer;
    
    // Temp
    private boolean tempSelect;
    
    public Battle(int battleID, String type, Player host, Player enemy)
    {
        // Battle
        this.battleID = battleID;
        this.battleType = type;
        this.battleBkg = "forest";
        this.battlePause = false;
        
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
        this.unitAlly[0] = new Unit(0, "Samurai", "FRONT", 1);
        this.unitAlly[1] = new Unit(0, "Archer", "BACK", 2);
        this.unitAlly[2] = new Unit(0, "Knight", "FRONT", 3);
        this.unitAlly[3] = new Unit(0, "Mage", "BACK", 0);
        this.unitAllyCount = 4;
        
        // Units (Enemy)
        this.unitEnemy[0] = new Unit(1, "Archer", "BACK", 1);
        this.unitEnemy[1] = new Unit(1, "Berserker", "FRONT", 2);
        this.unitEnemyCount = 2;
        
        // Turns
        this.turnStart = false;
        this.turnCount = 0;
        this.turnPlayer = 0;
        
        // Temp
        this.tempSelect = false;
    }
    
    public Player getPlayerAlly()
    {
        return this.playerAlly;
    }
    
    public Player getPlayerEnemy()
    {
        return this.playerEnemy;
    }
    
    public void render(Graphics g)
    {
        renderBackground(g);
        renderCastle(g);
        renderTiles(g);
        renderDeck(g);
        renderUnits(g);
        renderBanner(g);
        renderInterface(g);
    }
    
    public void renderBackground(Graphics g)
    {
        g.drawImage(Drawing.getImage("background/" + this.battleBkg + ".png"), 0, 0, null);
    }
    
    public void renderBanner(Graphics g)
    {
        // Background
        g.setColor(Colour.getColor("STEEL"));
        g.fillRect(0, 0, 400, 150);
        g.fillRect(966, 0, 400, 150);
        
        // Border
        g.setColor(Colour.getColor("BLACK"));
        g.fillRect(0, 149, 400, 2);
        g.fillRect(399, 0, 2, 150);
        
        // Player
        new Banner(0, 1).render(g, 50, 25);
        
        // Opponent
        new Banner(0, 1).render(g, 1116, 25);
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
        g.drawImage(Drawing.getImage("cards/deck.png"), 50, 450, null);
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
        
        // Temp
        //if(this.tempSelect) {g.drawImage(Drawing.getImage("units/select1.png"), 300, 300, null);}
    }
    
    public void touch(MouseEvent e)
    {
        NexusRect nr = new NexusRect(300, 300, 100, 100);
        if(nr.getCollide(e.getLocationOnScreen()))
        {
            this.tempSelect = true;
        }
    }
    
}