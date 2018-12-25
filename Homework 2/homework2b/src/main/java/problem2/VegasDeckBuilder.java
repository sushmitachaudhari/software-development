package problem2;


/**
 * A builder class to build a Vegas Deck
 *
 * @author Sushmita Chaudhari
**/
class VegasDeckBuilder {
    private int numberOfDecks;

    VegasDeckBuilder setNumberOfDecks(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        return this;
    }

    Deck makeDeck() {
        return new VegasDeck(numberOfDecks);
    }
}