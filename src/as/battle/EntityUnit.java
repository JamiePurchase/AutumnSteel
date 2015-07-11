package as.battle;

import as.battle.stats.Value;
import as.battle.stats.ValuePortion;
import as.battle.ui.BarHealth;
import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class EntityUnit extends Entity
{
    // Unit
    private String type;
    private BufferedImage visual;
    private String direction;
    private boolean ready;
    
    // Stats
    private HashMap<String, ValuePortion> statsCondition;
    private HashMap<String, Value> statsAttributes;

    public EntityUnit(Force force, String name, Node node, String type, String visual, String direction)
    {
        super(force, name, node);
        this.type = type;
        this.visual = Drawing.getImage(visual);
        this.direction = direction;
        this.ready = false;
        createStats();
    }
    
    public void assault(EntityUnit target)
    {
        // NOTE: build the action
        // animate the attack
        // inflict the damage
        this.setStatsCondition("ENERGY", -1);
        this.select(false);
    }
    
    private void createStats()
    {
        // Condition
        this.statsCondition = new HashMap<>();
        this.statsCondition.put("HEALTH", new ValuePortion(20, 100));
        this.statsCondition.put("ENERGY", new ValuePortion(1, 1));
        
        // Attributes
        this.statsAttributes = new HashMap<>();
        this.statsAttributes.put("STRENGTH", new Value(5));
    }
    
    public void garrison(EntityBuilding building)
    {
        this.setNode(building.getNode());
        building.garrison(this);
        this.setStatsCondition("ENERGY", -1);
        this.select(false);
    }
    
    public ArrayList<as.battle.action.Unit> getAction()
    {
        if(this.getStatsCondition("ENERGY").getValue() > 0)
        {
            // NOTE: simply get potential nodes then do all other logic here
            return getNode().getAdjacent(this);
        }
        return null;
    }
    
    public BufferedImage getDrawImage()
    {
        if(this.direction.equals("W")) {return Drawing.flipImage(this.visual);}
        return this.visual;
    }
    
    public int getDrawPosX()
    {
        return this.getNode().getPosX() + this.getDrawOffsetX();
    }
    
    public int getDrawPosY()
    {
        return this.getNode().getPosY() + this.getDrawOffsetY();
    }
    
    public boolean getReady()
    {
        return this.ready;
    }
    
    public Value getStatsAttributes(String index)
    {
        return this.statsAttributes.get(index);
    }
    
    public ValuePortion getStatsCondition(String index)
    {
        return this.statsCondition.get(index);
    }
    
    public boolean isEnemy(EntityUnit entity)
    {
        if(this.getForce() == entity.getForce()) {return false;}
        return true;
        // NOTE: not all other forces are enemies (check diplomacy between forces)
    }
    
    public boolean isGarrisoned()
    {
        if(this.getForce().getBuilding(this.getNode()) != null) {return true;}
        return false;
    }
    
    public void move(Node location)
    {
        this.setNode(location);
        this.setStatsCondition("ENERGY", -1);
        // NOTE: do we need to remove selection after moving?
        // we should certainly not do so if the unit has more energy
        //this.select(false);
    }
    
    public void render(Graphics g)
    {
        super.render(g);
        this.renderBarHealth(g);
    }
    
    public void renderBarHealth(Graphics g)
    {
        new BarHealth(this).render(g);
    }
    
    public void select()
    {
        super.select();
    }
    
    public void select(boolean selected)
    {
        super.select(selected);
        if(selected == false) {this.selectAction();}
    }
    
    private void selectAction()
    {
        // Forces the battle state to renew the action nodes
        this.getForce().getBattle().select(this);
    }
    
    public void setReady()
    {
        this.setReady(true);
    }
    
    public void setReady(boolean ready)
    {
        this.ready = ready;
    }
    
    public void setStatsCondition(String index, int value)
    {
        this.getStatsCondition(index).setValue(value);
    }
    
    public void tick()
    {
        //
    }

}