package as.battle;

import as.gfx.Drawing;
import as.gfx.Tileset;
import java.awt.image.BufferedImage;

public class EntityFlag extends Entity
{
    // Animation
    private Tileset tileset;
    private int tickNow, tickMax, frameNow, frameMax;

    public EntityFlag(Force force, Node node, Tileset tileset)
    {
        super(force, "FLAG", node);
        this.tileset = tileset;
        this.tickNow = 0;
        this.tickMax = 12;
        this.frameNow = 0;
        this.frameMax = 4;
    }
    
    public BufferedImage getDrawImage()
    {
        return this.tileset.getTileAt(this.frameNow, 0);
    }
    
    public int getDrawPosX()
    {
        return this.getNode().getPosX() + 20 + this.getDrawOffsetX();
    }
    
    public int getDrawPosY()
    {
        return this.getNode().getPosY() - 10 + this.getDrawOffsetY();
    }
    
    public void tick()
    {
        this.tickNow += 1;
        if(this.tickNow > this.tickMax)
        {
            this.tickNow = 0;
            this.frameNow += 1;
            if(this.frameNow >= this.frameMax) {this.frameNow = 0;}
        }
    }

}