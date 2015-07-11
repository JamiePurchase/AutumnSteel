package as.battle;

import as.gfx.Text;
import java.awt.Color;
import java.awt.Graphics;

public class BattleTutorial extends BattleOld
{
    private int tutorialStage;
    
    public BattleTutorial(int battleID, String type, Player host, Player enemy)
    {
        super(battleID, type, host, enemy);
        this.tutorialStage = 0;
        this.setBattlePhase("TUTORIAL_INTRO", 0, false);
    }
    
    public void render(Graphics g)
    {
        super.render(g);
        if(this.getBattlePhase().equals("TUTORIAL_INTRO"))
        {
            g.setColor(Color.WHITE);
            g.fillRect(200, 100, 1166, 568);
            g.setColor(Color.BLACK);
            g.drawRect(200, 100, 1166, 568);
            Text.write(g, "TUTORIAL", 683, 300, "CENTER");
        }
    }
    
    public void tick()
    {
        super.tick();
    }
    
}