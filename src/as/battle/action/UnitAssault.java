package as.battle.action;

import as.battle.EntityUnit;
import as.battle.Node;
import as.gfx.Colour;
import java.awt.Graphics;

public class UnitAssault extends Unit
{
    private EntityUnit target;

    public UnitAssault(EntityUnit unit, Node node, EntityUnit target)
    {
        super(unit, node, Colour.getColorRGB(125, 50, 50));
        this.target = target;
    }

    public void action()
    {
        this.getUnit().assault(this.target);
    }

}