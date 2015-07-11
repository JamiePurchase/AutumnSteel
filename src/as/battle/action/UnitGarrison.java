package as.battle.action;

import as.battle.EntityBuilding;
import as.battle.EntityUnit;
import as.battle.Node;
import as.gfx.Colour;
import java.awt.Graphics;

public class UnitGarrison extends Unit
{
    private EntityBuilding building;

    public UnitGarrison(EntityUnit unit, Node node, EntityBuilding building)
    {
        super(unit, node, Colour.getColorRGB(50, 125, 50));
        this.building = building;
    }

    public void action()
    {
        this.getUnit().garrison(this.building);
    }

}