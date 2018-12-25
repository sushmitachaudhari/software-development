package problem1;

/**
 * A builder class to build a Vegas Deck
 *
 * @author Sushmita Chaudhari
 */

class VegasDeckBuilder implements AbstractDeckBuilder{
    private int numberOfDecks;

    //set the number of decks in Vegas
    VegasDeckBuilder setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        return this;
    }
    //create Vegas deck
    @Override
    public Deck makeDeck() {
        return new VegasDeck(numberOfDecks);
    }
}