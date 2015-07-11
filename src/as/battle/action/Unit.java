package as.battle.action;

import as.battle.EntityUnit;
import as.battle.Node;
import as.gfx.Colour;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Unit
{
    private EntityUnit unit;
    private Node node;
    private Color highlight;

    public Unit(EntityUnit unit, Node node, Color highlight)
    {
        this.unit = unit;
        this.node = node;
        this.highlight = highlight;
    }
    
    public abstract void action();
    
    public Node getNode()
    {
        return this.node;
    }
    
    public EntityUnit getUnit()
    {
        return this.unit;
    }
    
    public void render(Graphics g)
    {
        this.node.renderHighlight(g, this.highlight);
    }

}