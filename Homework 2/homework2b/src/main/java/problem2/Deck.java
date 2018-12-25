package problem2;

/**
 * An interface of Deck class
 *
 * @author Sushmita Chaudhari
 */
public interface Deck {
    void shuffle();
    void sort(String guidance);
    void cut(int cutpoint);
    Card pullCard();
    Boolean emptyDeck();
    int officialSize();
}
