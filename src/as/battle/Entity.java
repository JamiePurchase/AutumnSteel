package as.battle;

import as.app.Engine;
import as.gfx.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity
{
    private Force force;
    private boolean select;
    private String name;
    private Node node;
    
    // Animation
    private boolean animActive;
    private int animTickNow, animTickMax;
    private int animFrameNow, animFrameMax;

    public Entity(Force force, String name, Node node)
    {
        this.force = force;
        this.select = false;
        this.name = name;
        this.node = node;
        
        // Animation
        this.animActive = false;
    }
    
    public int getAnimFrame()
    {
        return this.animFrameNow;
    }
    
    public abstract BufferedImage getDrawImage();
    
    public int getDrawOffsetX()
    {
        return this.force.getBattle().getScrollX() * 50;
    }
    
    public int getDrawOffsetY()
    {
        return this.force.getBattle().getScrollX() * 75;
    }

    public abstract int getDrawPosX();
    public abstract int getDrawPosY();
    
    public Force getForce()
    {
        return this.force;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public Node getNode()
    {
        return this.node;
    }
    
    public boolean isSelected()
    {
        return this.select;
    }
    
    public boolean isVisible()
    {
        return this.getForce().getBattle().isVisible(this.getNode());
    }
    
    public void render(Graphics g)
    {
        if(Engine.getDevActive()) {this.renderNexus(g);}
        if(this.isSelected()) {this.renderSelect(g);}
        g.drawImage(this.getDrawImage(), this.getDrawPosX(), this.getDrawPosY(), null);
    }
    
    private void renderNexus(Graphics g)
    {
        this.getNode().renderNexus(g);
    }
    
    private void renderSelect(Graphics g)
    {
        g.drawImage(Drawing.getImage("forces/tile3purple.png"), this.getDrawPosX(), this.getDrawPosY(), null);
    }
    
    public void select()
    {
        this.select(true);
    }
    
    public void select(boolean select)
    {
        this.select = select;
        if(select == false) {this.selectNull();}
    }
    
    private void selectNull()
    {
        // The battle state resets the selection data
        this.getForce().getBattle().select();
    }
    
    public void setAnimation(boolean active)
    {
        this.animActive = active;
    }
    
    public void setAnimation(boolean active, int tickMax, int frameMax)
    {
        this.animActive = active;
        this.animTickNow = 0;
        this.animTickMax = tickMax;
        this.animFrameNow = 0;
        this.animFrameMax = frameMax;
    }
    
    public void setNode(Node location)
    {
        this.node = location;
    }
    
    public void tick()
    {
        if(this.animActive) {this.tickAnim();}
    }
    
    public void tickAnim()
    {
        this.animTickNow ++;
        if(this.animTickNow == this.animTickMax)
        {
            this.animTickNow = 0;
            this.animFrameNow ++;
            if(this.animFrameNow == this.animFrameMax)
            {
                this.animFrameNow = 0;
            }
        }
    }

}