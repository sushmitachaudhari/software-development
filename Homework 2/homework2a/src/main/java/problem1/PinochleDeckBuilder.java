package problem1;

/**
 * A builder class to build a Pinochle Deck
 *
 * @author Sushmita Chaudhari
 */
class PinochleDeckBuilder implements AbstractDeckBuilder{

    @Override
     public Deck makeDeck() {
        return new PinochleDeck();
    }
}