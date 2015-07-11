package as.battle;

import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EntityBuilding extends Entity
{
    private String type;
    private BufferedImage visual;
    private int offsetX, offsetY;
    private int statHealth;
    private ArrayList<EntityUnit> garrison;

    public EntityBuilding(Force force, String name, Node node, String type, String visual, int offsetX, int offsetY)
    {
        super(force, name, node);
        this.type = type;
        this.visual = Drawing.getImage(visual);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.garrison = new ArrayList();
    }
    
    public void garrison(EntityUnit unit)
    {
        this.garrison.add(unit);
    }
    
    public BufferedImage getDrawImage()
    {
        return this.visual;
    }
    
    public int getDrawPosX()
    {
        return this.getNode().getPosX() + this.offsetX + this.getDrawOffsetX();
    }
    
    public int getDrawPosY()
    {
        return this.getNode().getPosY() + this.offsetY + this.getDrawOffsetY();
    }
    
    public ArrayList<EntityUnit> getGarrison()
    {
        return this.garrison;
    }
    
    public void tick()
    {
        //
    }

}