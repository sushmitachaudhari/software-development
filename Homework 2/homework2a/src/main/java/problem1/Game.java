package problem1;

/**
 * A Game interface
 *
 * @author Sushmita Chaudhari
 */
public interface Game {
    void createDeck(String deckType);
    void createDeck(String deckType, int numberOfDecks);
    void setNumberOfhands(int howManyHands);
    void deal();
}
