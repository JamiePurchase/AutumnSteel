package as.battle;

import as.card.Deck;

public class Player
{
    // Player
    private int accountID;
    
    // Stats
    private int statAction;
    private int statHealth;
    
    // Cards
    private Deck cardDeck;
    
    public Player(int accountID)
    {
        // Player
        this.accountID = accountID;
    }
    
    public Deck getCardDeck()
    {
        return this.cardDeck;
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
}