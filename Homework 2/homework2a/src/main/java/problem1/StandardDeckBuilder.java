package problem1;

/**
 * A builder class to build a Standard Deck
 *
 * @author Sushmita Chaudhari
 */
class StandardDeckBuilder implements AbstractDeckBuilder{
    @Override
    public Deck makeDeck() {
        return new StandardDeck();
    }
}