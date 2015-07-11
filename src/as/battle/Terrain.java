package as.battle;

import as.states.StateBattle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Terrain
{
    private StateBattle battle;
    private Node node;
    private BufferedImage image;
    
    // TEMP
    private int offsetX, offsetY;

    public Terrain(StateBattle battle, Node node, BufferedImage image)
    {
        this.battle = battle;
        this.node = node;
        this.image = image;
        this.offsetX = 0;
        this.offsetY = 0;
    }

    public Terrain(StateBattle battle, Node node, BufferedImage image, int moveX, int moveY)
    {
        this.battle = battle;
        this.node = node;
        this.image = image;
        this.offsetX = moveX;
        this.offsetY = moveY;
    }
    
    private int getDrawPosX()
    {
        return this.node.getPosX() + this.offsetX + this.battle.getScrollX();
    }
    
    private int getDrawPosY()
    {
        return this.node.getPosY() + this.offsetY + this.battle.getScrollY();
    }
    
    public void render(Graphics g)
    {
        g.drawImage(this.image, this.getDrawPosX(), this.getDrawPosY(), null);
    }

}