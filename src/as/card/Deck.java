package as.card;

import as.file.Froth;

public class Deck
{
    private Card[] cards;
    
    // NOTE: as with various other classes, we are using alternate constructors for building objects in different ways
    public Deck(Froth load)
    {
        this.cards = new Card[30];
    }
}