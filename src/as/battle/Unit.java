package as.battle;

import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Unit
{
    // Unit
    private int unitSide;
    private String unitCode;
    private String unitName;
    
    // Formation
    private String formRow;
    private int formCol;
    
    // Stat
    private int statHealth;
    private int statAttack;
    private int statDefend;
    
    private boolean actionReady;
    
    // Effect
    private Effect[] effectData = new Effect[10];
    private int effectCount;
    
    private BufferedImage image;
    private boolean opponent;
    
    public Unit(int side, String code, String formRow, int formCol)
    {
        this.unitSide = side;
        this.unitCode = code;
        this.unitName = "";
        this.formRow = formRow;
        this.formCol = formCol;
        this.actionReady = false;
        this.image = Drawing.getImage("units/" + this.unitCode + "/0.png");
    }
    
    private BufferedImage getDrawImage()
    {
        if(this.unitSide == 1) {return Drawing.flipImage(this.image);}
        return this.image;
    }
    
    private int getDrawPosX()
    {
        if(this.unitSide == 0)
        {
            if(this.formRow == "FRONT") {return 400;}
            return 300;
        }
        else
        {
            if(this.formRow == "FRONT") {return 866;}
            return 966;
        }
    }
    
    private int getDrawPosY()
    {
        return (100 * this.formCol) + 200;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.getDrawImage(), this.getDrawPosX(), this.getDrawPosY(), null);
    }
}