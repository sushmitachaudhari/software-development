package problem2;

import java.util.List;

/**
 * An interface Hand - simulates a player in game in real life
 *
 * @author Sushmita Chaudhari
 */
public interface Hand {
    List<Card> showCards();
    void accept(Card card);
    Card pullCard();
    Boolean hasCard(Card card);
    void sort(String bySuitRankBoth);
    void shuffle();

    /* added as per discussion with Professor since we have to tests these*/
    Boolean hasSuit(Suit suit);
    Boolean hasRank(Rank rank);
}
