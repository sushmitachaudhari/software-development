package problem2;

/**
 * A Rank interface which represents Rank of a card
 *
 * @author Sushmita Chaudhari
 */
public interface Rank {
    String getName();//"TWO"
    int getPips(); // 2 - 10; no pips for face cards
}
