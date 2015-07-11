package as.states;

import as.app.Engine;
import as.battle.Entity;
import as.battle.EntityBuilding;
import as.battle.EntityUnit;
import as.battle.Force;
import as.battle.Node;
import as.battle.Panel;
import as.battle.PanelMenu;
import as.battle.Terrain;
import as.battle.action.Unit;
import as.file.FileASB;
import as.gfx.Colour;
import as.gfx.Drawing;
import as.gfx.Tileset;
import as.input.Nexus;
import as.maths.Range;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class StateBattle extends State
{
    // Temp
    int tempFlagTick, tempFlagFrame;
    Tileset tempTileset;
    Boolean tempHighlight;
    
    // Battle
    private int battleID;
    private String battleState;
    private int battleTurnCount, battleTurnForce;
    
    // Graphics
    private ArrayList<Terrain> gfxTerrain;
    private BufferedImage gfxTerrainImage;
    private BufferedImage gfxGrid;
    private int gfxScrollX, gfxScrollY;
    
    // Input
    private Point inputMousePos;
    private int inputMouseTick;
    private ArrayList<Nexus> inputMouseNexus;
    
    // Force
    private ArrayList<Force> force;
    
    // Interface
    private Panel uiInfo;
    // NOTE: use a subclass of panel with text and pictures?
    private PanelMenu uiPause;
    
    // Selection
    public boolean selectActive;
    public EntityUnit selectUnit;
    public ArrayList<Unit> selectUnitAction;
    public EntityBuilding selectBuilding;
    
    public StateBattle()
    {
        // Battle
        this.battleID = 0;
        this.battleState = "INIT";
        this.battleTurnCount = 0;
        this.battleTurnForce = 0;
        
        // Graphics
        this.gfxTerrain = new ArrayList();
        this.gfxTerrainImage = null;
        this.gfxScrollX = 0;
        this.gfxScrollY = 0;
        this.gfxGrid = null;
        
        // Input
        this.inputMousePos = null;
        this.inputMouseTick = 0;
        
        // Force
        this.force = new ArrayList();
        this.selectUnit = null;
        this.selectUnitAction = new ArrayList();
        this.selectBuilding = null;
        
        // Interface
        this.uiInfo = null;
        this.createPause();
        
        // Selection
        this.select();
        
        // Load
        load(new FileASB("", ""));
        
        // TEMP
        Tileset tilesetCliff = new Tileset("terrainCliff", Drawing.getImage("terrain/cliff.png"), 100, 100, 8, 3);
        
        HashMap<String, BufferedImage> terrainCliff = new HashMap<>();
        terrainCliff.put("CORNER_SW_OUT3", tilesetCliff.getTileAtNode(2, 2));
        terrainCliff.put("CORNER_SW_IN1", tilesetCliff.getTileAtNode(4, 2));
        terrainCliff.put("CORNER_SW_OUT2", tilesetCliff.getTileAtNode(5, 3));
        terrainCliff.put("SLOPE_SW_1", tilesetCliff.getTileAtNode(6, 4));
        terrainCliff.put("SLOPE_SW_2", tilesetCliff.getTileAtNode(8, 4));
        terrainCliff.put("CORNER_SW_OUT1", tilesetCliff.getTileAtNode(9, 5));
        terrainCliff.put("EDGE_S_1", tilesetCliff.getTileAtNode(11, 5));
        terrainCliff.put("EDGE_S_2", tilesetCliff.getTileAtNode(13, 5));
        
        this.addTerrain(new Node(6, 0), terrainCliff.get("CORNER_SW_OUT3"));
        this.addTerrain(new Node(8, 0), terrainCliff.get("CORNER_SW_IN1"));
        this.addTerrain(new Node(9, 1), terrainCliff.get("CORNER_SW_OUT2"));
        this.addTerrain(new Node(10, 2), terrainCliff.get("SLOPE_SW_1"));
        this.addTerrain(new Node(12, 2), terrainCliff.get("SLOPE_SW_2"));
        this.addTerrain(new Node(13, 3), terrainCliff.get("CORNER_SW_OUT1"));
        this.addTerrain(new Node(15, 3), terrainCliff.get("EDGE_S_1"));
        this.addTerrain(new Node(17, 3), terrainCliff.get("EDGE_S_2"));
        
        // TEMP
        Tileset tilesetTree = new Tileset("terrainTree", Drawing.getImage("terrain/tree.png"), 100, 100, 4, 1);
        this.addTerrain(new Node(10, 2), Drawing.flipImage(tilesetTree.getTileAt(1, 0)), -22, -30);
        this.addTerrain(new Node(10, 2), Drawing.flipImage(tilesetTree.getTileAt(0, 0)), +22, -12);
        this.addTerrain(new Node(10, 2), tilesetTree.getTileAt(1, 0));
    }
    
    private void advance()
    {
        this.advanceTurn();
        // NOTE: Random Events? Effects? Resource Income? Time limits?
        this.advanceForce();
    }
    
    private void advanceForce()
    {
        for(int x = 0; x < this.force.size(); x++)
        {
            this.force.get(x).ready();
        }
    }
    
    private void advanceTurn()
    {
        this.battleTurnForce ++;
        if(this.battleTurnForce == this.force.size())
        {
            this.battleTurnForce = 0;
            this.battleTurnCount ++;
            //this.advanceTurnSeason ++;
        }
    }
    
    public void addTerrain(Node node, BufferedImage image)
    {
        this.addTerrain(node, image, 0, 0);
    }
    
    public void addTerrain(Node node, BufferedImage image, int offsetX, int offsetY)
    {
        this.gfxTerrain.add(new Terrain(this, node, image, offsetX, offsetY));
    }
    
    private void createPause()
    {
        this.uiPause = new PanelMenu(new Rectangle(258, 184, 850, 400));
        this.uiPause.addOption("RESUME", 50, 50);
        this.uiPause.addOption("OPTIONS", 50, 200);
        this.uiPause.addOption("QUIT", 50, 350);
    }
    
    private Node getNode(Point point)
    {
        int posX = 0;
        int posY = 0;
        for(int x = 0; x < 15; x++)
        {
            for(int y = 0; y < 12; y++)
            {
                posX = 100 * x - 100;
                posY = 75 * y - 100;
                if(y % 2 != 0) {posX = posX + 50;}
                //
            }
        }
        return new Node(posX, posY);
    }
    
    public int getScrollX()
    {
        return this.gfxScrollX;
    }
    
    public int getScrollXMax()
    {
        // NOTE: need to consider the screen width and total board size
        return 10;
    }
    
    public int getScrollY()
    {
        return this.gfxScrollY;
    }
    
    public int getScrollYMax()
    {
        // NOTE: need to consider the screen height and total board size
        return 10;
    }
    
    private Range getScrollRangeX()
    {
        return new Range(this.gfxScrollX, this.gfxScrollX + 28);
    }
    
    private Range getScrollRangeY()
    {
        return new Range(this.gfxScrollY, this.gfxScrollY + 11);
    }
    
    public EntityUnit getUnit(Node node)
    {
        for(int x = 0; x < this.force.size(); x++)
        {
            for(int y = 0; y < this.force.get(x).getUnit().size(); y++)
            {
                if(this.force.get(x).getUnit().get(y).getNode().match(node))
                {
                    return this.force.get(x).getUnit().get(y);
                }
            }
        }
        return null;
    }
    
    public void inputKeyPress(String key)
    {
        if(this.uiPause.getActive()) {this.uiPause.inputKey(key);}
        else
        {
            if(key.equals("ESCAPE")) {this.uiPause.setActive(true);}
            if(key.equals("UP")) {this.setScroll("N");}
            if(key.equals("DOWN")) {this.setScroll("S");}
            if(key.equals("LEFT")) {this.setScroll("W");}
            if(key.equals("RIGHT")) {this.setScroll("E");}
        }
    }
    
    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputMouseClickL(MouseEvent e)
    {
        // NOTE: if event is in hud panels look through those nexus objects
        // otherwise check entities
        
        // TEMP
        System.out.println("*** MOUSE: LEFT CLICK AT " + e.getPoint());
        System.out.println("selectActive: " + this.selectActive + ", selectUnit: " + this.selectUnit);
        for(int x = 0; x < this.force.size(); x++)
        {
            this.force.get(x).inputClick(e.getPoint());
        }
        
        /*for(int x = 0; x < this.inputMouseNexus.size(); x++)
        {
            if(this.inputMouseNexus.get(x).intersect(e.getPoint()))
            {
                //String select = this.inputMouseNexus.get(x)...
            }
        }*/
        
        /*if(new Rectangle(520, 367, 60, 66).contains(e.getPoint()))
        {
            //this.tempHighlight = true;
            this.force.get(0).getUnit(0).select();
        }*/
    }
    
    public void inputMouseClickR(MouseEvent e)
    {
        System.out.println("*** MOUSE: RIGHT CLICK AT " + e.getPoint());
        System.out.println("selectActive: " + this.selectActive + ", selectUnit: " + this.selectUnit);
        // Right click performs various actions, if an entity is selected
        if(this.selectActive)
        {
            //if(this.selectUnit != null) {this.selectUnit...;}
            
            // TESTING
            this.selectUnit.move(new Node(16, 4));
        }
    }

    public void inputMouseMove(MouseEvent e)
    {
        this.inputMousePos = e.getPoint();
        this.inputMouseTick = 0;
        if(this.uiInfo != null) {this.uiInfo = null;}
    }
    
    private String interfaceFind(Point point)
    {
        //if(this.uiStats.intersect(point)) {return "STATS";}
        return "";
    }
    
    public boolean isVisible(Entity entity)
    {
        return this.isVisible(entity.getNode());
    }
    
    public boolean isVisible(Node node)
    {
        if(getScrollRangeX().contains(node.getNodeX()) && getScrollRangeY().contains(node.getNodeY())) {return true;}
        return false;
    }
    
    private void load(FileASB asb)
    {
        // TEMP: Force 1
        Force force1 = new Force(this, "Player");        
        force1.addUnit("Archer", new Node(14, 4), "Archer", "units(old)/archer/0.png", "E");
        force1.addUnit("Samurai", new Node(12, 6), "Samurai", "units(old)/samurai/0.png", "E");
        force1.addBuilding("Build1", new Node(16, 6), "Build1", "buildings/hut.png", 0, -50);
        force1.addBuilding("Tower", new Node(8, 8), "Build1", "buildings/tower.png", 0, -150);
        force1.addFlag(new Node(10, 4), new Tileset("flagPurple", Drawing.getImage("forces/flagPurple.png"), 100, 100, 4, 1));
        this.force.add(force1);
        
        // TEMP: Force 2
        Force force2 = new Force(this, "Computer");
        force2.addUnit("Samurai", new Node(18, 8), "Samurai", "units(old)/samurai/0.png", "W");
        this.force.add(force2);
    }
    
    public void render(Graphics g)
    {
        if(this.uiPause.getActive())
        {
            if(this.uiPause.getBackground() != null) {this.uiPause.render(g);}
            else
            {
                renderApp(uiPause.getBackgroundNew());
                this.uiPause.render(g);
            }
        }
        else {renderApp(g);}
    }
    
    private void renderApp(Graphics g)
    {
        this.renderBackground(g);
        //this.renderGrid(g);
        this.renderTerrain(g);
        this.renderHighlight(g);
        this.renderForce(g);
        this.renderInterface(g);
        
        // Compile the canvas into
        //if(save) {g.dispose();}
    }
    
    private void renderBackground(Graphics g)
    {
        g.setColor(Colour.getColor("TERRAIN_1"));
        g.fillRect(0, 0, Engine.width, Engine.height);
    }
    
    private void renderForce(Graphics g)
    {
        for(int x = 0; x < this.force.size(); x++)
        {
            this.force.get(x).render(g);
        }
    }
    
    private void renderGrid(Graphics g)
    {
        if(this.gfxGrid == null) {this.renderGridDraw(g);}
        g.drawImage(this.gfxGrid, 0, 0, null);
    }
    
    private void renderHighlight(Graphics g)
    {
        //System.out.println("*** RENDER HIGHLIGHT: " + this.selectUnit);
        // NOTE: the highlighted nodes arrayList should probably be a property of this class
        // the list resets when entities are selected or actions occur
        if(this.selectUnit != null && this.selectUnitAction.size() > 0)
        {
            for(int x = 0; x < this.selectUnitAction.size(); x++)
            {
                this.selectUnitAction.get(x).render(g);
            }
        }
    }
    
    private void renderGridDraw(Graphics g)
    {
        BufferedImage tile = Drawing.getImage("forces/tile2.png");
        BufferedImage image = new BufferedImage(Engine.width, Engine.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        int posX, posY;
        for(int x = 0; x < 15; x++)
        {
            for(int y = 0; y < 12; y++)
            {
                posX = 100 * x - 100;
                posY = 75 * y - 100;
                if(y % 2 != 0) {posX = posX + 50;}
                g2d.drawImage(tile, posX, posY, null);
            }
        }
        g2d.dispose();
        this.gfxGrid = image;
    }
    
    private void renderInterface(Graphics g)
    {
        if(this.uiInfo != null) {this.uiInfo.render(g);}
    }
    
    private void renderTerrain(Graphics g)
    {
        if(this.gfxTerrainImage == null) {renderTerrainDraw(g);}
        g.drawImage(this.gfxTerrainImage, 0, 0, null);
    }
    
    private void renderTerrainDraw(Graphics g)
    {
        BufferedImage image = new BufferedImage(Engine.width, Engine.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        for(int x = 0; x < this.gfxTerrain.size(); x++)
        {
            this.gfxTerrain.get(x).render(g2d);
        }
        g2d.dispose();
        this.gfxTerrainImage = image;
    }
    
    public void select()
    {
        this.selectNull();
    }
    
    public void select(EntityBuilding building)
    {
        // Clear Selection
        this.selectNull();
        
        // Select Building
        this.selectActive = true;
        this.selectBuilding = building;
    }
    
    public void select(EntityUnit unit)
    {
        // Clear Selection
        this.selectNull();
        
        // Debug
        System.out.println("*** SELECTED A UNIT: " + unit);
        
        // Select Unit
        this.selectActive = true;
        this.selectUnit = unit;
        this.selectUnitAction = unit.getAction();
    }
    
    private void selectNull()
    {
        // Debug
        System.out.println("*** SELECT NULL WAS CALLED - " + Thread.currentThread().getStackTrace()[3].getMethodName());
        
        // Unselect Entites
        if(this.selectBuilding != null) {this.selectBuilding.select(false);}
        if(this.selectBuilding != null) {this.selectUnit.select(false);}
        
        // Default Values
        this.selectActive = false;
        this.selectBuilding = null;
        this.selectUnit = null;
        this.selectUnitAction = new ArrayList();
    }
    
    public void setScroll(String direction)
    {
        if(direction.equals("E") && this.gfxScrollX < this.getScrollXMax()) {this.gfxScrollX += 1;}
        else if(direction.equals("W") && this.gfxScrollX > 0) {this.gfxScrollX -= 1;}
        else if(direction.equals("N") && this.gfxScrollY < this.getScrollYMax()) {this.gfxScrollY += 1;}
        else if(direction.equals("S") && this.gfxScrollY > 0) {this.gfxScrollY -= 1;}
    }
    
    public void setScrollX(int pos)
    {
        this.gfxScrollX = pos;
    }
    
    public void setScrollY(int pos)
    {
        this.gfxScrollY = pos;
    }
    
    public void tick()
    {
        this.tickMouse();
        this.tickForce();
    }
    
    private void tickForce()
    {
        for(int x = 0; x < this.force.size(); x++)
        {
            this.force.get(x).tick();
        }
    }
    
    private void tickMouse()
    {
        this.inputMouseTick ++;
        if(this.inputMouseTick == 60 && this.inputMousePos != null) {this.tickMouseFind();}
    }
    
    private void tickMouseFind()
    {
        // get the node of the current position
        // if there is an entity at the node then activate the hover
        // use a subclass of panel
        // if the cursor beyond a certain point across and/down then reposition (considering size)
        this.uiInfo = new Panel(new Rectangle(this.inputMousePos.x, this.inputMousePos.y, 100, 50));
    }

    public void type(KeyEvent e)
    {
        //
    }
    
}