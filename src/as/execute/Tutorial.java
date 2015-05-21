package as.execute;

import as.app.Engine;
import as.battle.Battle;
import as.battle.Player;
import as.card.Deck;
import as.file.Froth;
import as.states.StateBattle;

public class Tutorial
{
    public static void executeTutorial()
    {
        // Create Player
        Player player = new Player(Engine.getAccount().getAccountID());
        player.setStatAction(3);
        Deck playerDeck = new Deck(new Froth("decks/deck1"));
        
        // Create Opponent Object
        Player opponent = new Player(0);
        Deck opponentDeck = new Deck(new Froth("decks/deck2"));
        //enemyDeck[0] = new Card("", "Card 1", "INFANTRY");
        
        // Create Battle Object
        Battle battle = new Battle(0, "TUTORIAL", player, opponent);
        
        // Launch Battle State
        Engine.setState(new StateBattle(battle));
    }
}