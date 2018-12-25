package problem1;

/**
 * A Euchre Deck builder
 *
 * @author Sushmita Chaudhari
 */
class EuchreDeckBuilder implements AbstractDeckBuilder{

    //making the Euchre Deck
    @Override
    public Deck makeDeck() { return new EuchreDeck();
    }
}