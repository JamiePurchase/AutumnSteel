package as.battle;

import as.battle.action.UnitAssault;
import as.battle.action.UnitMove;
import as.gfx.Colour;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Node
{
    private int posX, posY;

    public Node(int posX, int posY)
    {
        this.posX = posX;
        this.posY = posY;
    }
    
    public ArrayList<as.battle.action.Unit> getAdjacent(EntityUnit unit)
    {
        // List of adjacent nodes
        ArrayList<Node> nodes = this.getAdjacentNode();
        
        // Loop through all possible nodes and determine potential actions
        ArrayList<as.battle.action.Unit> actions = new ArrayList();
        for(int x = 0; x < nodes.size(); x++)
        {
            // NOTE: check for solid terrain
            //if(nodes.get(x).isTerrain) - change the next if to an else if
            
            // Check for a unit at this node
            if(unit.getForce().getBattle().getUnit(nodes.get(x)) != null)
            {
                EntityUnit entity = unit.getForce().getBattle().getUnit(nodes.get(x));
                if(unit.isEnemy(entity));
                {
                    actions.add(new UnitAssault(unit, nodes.get(x), entity));
                }
            }
            
            // NOTE: check for collectables and suchlike
            
            // Able to move into this node if it is empty
            else if(nodes.get(x).isEmpty())
            {
                actions.add(new UnitMove(unit, nodes.get(x)));
            }
        }
        return actions;
    }
    
    public ArrayList<Node> getAdjacentNode()
    {
        return this.getAdjacentNode(1);
    }
    
    public ArrayList<Node> getAdjacentNode(int radius)
    {
        // Create a list of immediate nodes
        ArrayList<Node> nodes = new ArrayList();
        nodes.add(new Node(this.getNodeX() + 1, this.getNodeY() - 1));
        nodes.add(new Node(this.getNodeX() + 2, this.getNodeY()));
        nodes.add(new Node(this.getNodeX() + 1, this.getNodeY() + 1));
        nodes.add(new Node(this.getNodeX() - 1, this.getNodeY() + 1));
        nodes.add(new Node(this.getNodeX() - 2, this.getNodeY()));
        nodes.add(new Node(this.getNodeX() - 1, this.getNodeY() - 1));
        
        // Expand the list if necessary
        ArrayList<Node> extra = new ArrayList();
        if(radius == 2)
        {
            // Loop through all adjacent nodes
            for(int x = 0; x < nodes.size(); x++)
            {
                // Create a list of more nodes
                extra = nodes.get(x).getAdjacentNode();
                
                // Add nodes to the main list only they haven't been added already
                for(int y = 0; y < extra.size(); y++)
                {
                    if(!nodes.contains(extra.get(y))) {nodes.add(extra.get(y));}
                }
            }
        }
        
        // Return the nodes
        return nodes;
    }
    
    public Polygon getNexus()
    {
        int pointX[] = {this.getPosX() + 50, this.getPosX(), this.getPosX(), this.getPosX() + 50, this.getPosX() + 100, this.getPosX() + 100};
        int pointY[] = {this.getPosY(), this.getPosY() + 25, this.getPosY() + 75, this.getPosY() + 100, this.getPosY() + 75, this.getPosY() + 25};
        return new Polygon(pointX, pointY, 6);
    }
    
    public int getNodeX()
    {
        return this.posX;
    }
    
    public int getNodeY()
    {
        return this.posY;
    }

    public int getPosX()
    {
        // Adjust this by taking into account the screen scroll values
        return (this.posX * 50) - 50;
    }

    public int getPosY()
    {
        return (this.posY * 75) - 25;
    }
    
    public boolean isEmpty()
    {
        // NOTE: this needs to be more complex
        // we may want to know if certain objects reside in the node
        return true;
    }
    
    public boolean match(Node node)
    {
        if(this.posX == node.getNodeX() && this.posY == node.getNodeY()) {return true;}
        return false;
    }
    
    public void renderHighlight(Graphics g, Color rgb)
    {
        g.setColor(rgb);
        g.drawPolygon(this.getNexus());
    }
    
    public void renderNexus(Graphics g)
    {
        g.setColor(Colour.getColor("DEV_NEXUS"));
        g.drawPolygon(this.getNexus());
    }

}