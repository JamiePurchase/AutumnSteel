package as.battle;

import as.card.Card;
import as.card.Deck;

public class Player
{
    // Player
    private int accountID;
    private String accountUsername;
    
    // Stats
    private int statAction;
    private int statHealth;
    
    // Cards (Deck)
    private Deck cardDeck;
    
    // Cards (Hand)
    private Card[] cardHand = new Card[30];
    private int cardHandCount;
    
    public Player(int accountID)
    {
        // Player
        this.accountID = accountID;
        this.accountUsername = "Jamie";
    }
    
    public String getAccountUsername()
    {
        return this.accountUsername;
    }
    
    public Deck getCardDeck()
    {
        return this.cardDeck;
    }
    
    public int getCardDeckCount()
    {
        return this.cardDeck.getCount();
    }
    
    //public getCardHand()
    
    public int getStatAction()
    {
        return this.statAction;
    }
    
    public int getStatHealth()
    {
        return this.statHealth;
    }
    
    public void setCardDeck(Deck deck)
    {
        this.cardDeck = deck;
    }
    
    public void setStatAction(int value)
    {
        this.statAction = value;
    }
}