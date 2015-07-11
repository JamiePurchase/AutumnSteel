package as.input;

import as.battle.Node;
import java.awt.Point;
import java.awt.Polygon;

public class Nexus
{
    private Polygon area;

    public Nexus(Node node)
    {
        this.area = node.getNexus();
    }

    public boolean intersect(Point point)
    {
        if(this.area.contains(point)) {return true;}
        return false;
    }

}