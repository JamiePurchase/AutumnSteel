package as.card;

import as.file.Froth;
import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;
    
    public Deck()
    {
        this.cards = new ArrayList<Card>();
    }
    
    // NOTE: as with various other classes, we are using alternate constructors for building objects in different ways
    public Deck(Froth load)
    {
        this.cards = new ArrayList<Card>();
        
        // temp
        this.addCard(new Card("cardCode", "cardName", "cardType"));
    }
    
    public void addCard(Card card)
    {
        this.cards.add(card);
    }
    
    public int getCount()
    {
        return this.cards.size();
    }
    
}