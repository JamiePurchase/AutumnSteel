package as.battle;

import as.gfx.Tileset;
import as.states.StateBattle;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Force
{
    private StateBattle battle;
    private String name;
    private ArrayList<EntityBuilding> building;
    private ArrayList<EntityFlag> flag;
    private ArrayList<EntityUnit> unit;

    public Force(StateBattle battle, String name)
    {
        this.battle = battle;
        this.name = name;
        this.building = new ArrayList();
        this.flag = new ArrayList();
        this.unit = new ArrayList();
    }
    
    public int addBuilding(String name, Node node, String type, String visual, int offsetX, int offsetY)
    {
        this.building.add(new EntityBuilding(this, name, node, type, visual, offsetX, offsetY));
        return this.building.size();
    }
    
    public int addFlag(Node node, Tileset tileset)
    {
        this.flag.add(new EntityFlag(this, node, tileset));
        return this.flag.size();
    }
    
    public int addUnit(String name, Node node, String type, String visual, String direction)
    {
        this.unit.add(new EntityUnit(this, name, node, type, visual, direction));
        return this.unit.size();
    }
    
    public StateBattle getBattle()
    {
        return this.battle;
    }
    
    public ArrayList<EntityBuilding> getBuilding()
    {
        return this.building;
    }
    
    public EntityBuilding getBuilding(int pos)
    {
        return this.building.get(pos);
    }
    
    public EntityBuilding getBuilding(Node node)
    {
        for(int x = 0; x < this.building.size(); x++)
        {
            if(this.building.get(x).getNode().match(node)) {return this.building.get(x);}
        }
        return null;
    }
    
    public ArrayList<EntityFlag> getFlag()
    {
        return this.flag;
    }
    
    public EntityFlag getFlag(int pos)
    {
        return this.flag.get(pos);
    }
    
    public ArrayList<EntityUnit> getUnit()
    {
        return this.unit;
    }
    
    public EntityUnit getUnit(int pos)
    {
        return this.unit.get(pos);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String inputClick(Point point)
    {
        // Check Units
        String check = this.inputClickUnit(point);
        if(check != "") {return check;}
        
        // Nothing was Selected
        /*this.selectNull();
        this.battle.select();*/
        // NOTE: need to reconsider this section (causing selectNull to occur when it shouldn't)
        return "";
    }
    
    private String inputClickUnit(Point point)
    {
        for(int x = 0; x < this.unit.size(); x++)
        {
            if(this.unit.get(x).getNode().getNexus().contains(point))
            {
                this.selectNull();
                this.unit.get(x).select();
                this.battle.select(this.unit.get(x));
                return "UNIT: " + x;
            }
        }
        return "";
    }
    
    public void ready()
    {
        for(int x = 0; x < this.unit.size(); x++)
        {
            this.unit.get(x).setReady();
        }
    }
    
    public void render(Graphics g)
    {
        if(this.building.size() > 0) {this.renderBuilding(g);}
        if(this.flag.size() > 0) {this.renderFlag(g);}
        if(this.unit.size() > 0) {this.renderUnit(g);}
    }
    
    private void renderBuilding(Graphics g)
    {
        for(int x = 0; x < this.building.size(); x++)
        {
            this.building.get(x).render(g);
        }
    }
    
    private void renderFlag(Graphics g)
    {
        for(int x = 0; x < this.flag.size(); x++)
        {
            this.flag.get(x).render(g);
        }
    }
    
    private void renderUnit(Graphics g)
    {
        for(int x = 0; x < this.unit.size(); x++)
        {
            if(this.unit.get(x).isVisible()) {this.unit.get(x).render(g);}
        }
    }
    
    private void selectNull()
    {
        this.selectNullBuilding();
        this.selectNullUnit();
    }
    
    private void selectNullBuilding()
    {
        for(int x = 0; x < this.building.size(); x++)
        {
            this.building.get(x).select(false);
        }
    }
    
    private void selectNullUnit()
    {
        for(int x = 0; x < this.unit.size(); x++)
        {
            this.unit.get(x).select(false);
        }
    }
    
    public void tick()
    {
        this.tickFlag();
    }
    
    private void tickFlag()
    {
        for(int x = 0; x < this.flag.size(); x++)
        {
            this.flag.get(x).tick();
        }
    }

}