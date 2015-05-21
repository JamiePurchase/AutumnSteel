package as.execute;

import as.app.Engine;
import as.battle.Battle;
import as.battle.Player;
import as.card.Deck;
import as.states.StateBattle;

public class Tutorial
{
    public static void executeTutorial()
    {
        // Create Player Object
        Player host = new Player(Engine.getAccount().getAccountID());
        
        // Create Opponent Object
        Player enemy = new Player(0);
        
        // Create Opponent Deck
        Deck enemyDeck = new Deck();
        //enemyDeck[0] = new Card("", "Card 1", "INFANTRY");
        
        // Create Battle Object
        Battle battle = new Battle(0, "TUTORIAL", host, enemy);
        
        // Launch Battle State
        Engine.setState(new StateBattle(battle));
    }
}