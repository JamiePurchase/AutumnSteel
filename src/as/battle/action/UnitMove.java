package as.battle.action;

import as.battle.EntityUnit;
import as.battle.Node;
import as.gfx.Colour;
import java.awt.Graphics;

public class UnitMove extends Unit
{

    public UnitMove(EntityUnit unit, Node node)
    {
        super(unit, node, Colour.getColorRGB(125, 50, 125));
    }

    public void action()
    {
        this.getUnit().move(this.getNode());
    }

}