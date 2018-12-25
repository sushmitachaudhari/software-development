package problem1;

import java.util.List;

/**
 * An interface Hand - simulates a player in game in real life
 *
 * @author Sushmita Chaudhari
 */
public interface Hand {
    List<Card> showCards();
    void accept(Card card);
    Card pullCard();//assume first card
    Boolean hasCard(Card cardToFind);
    void sort(String guidance);
    void shuffle();

    /* added as per discussion with Professor since we have to tests these*/
    Boolean hasSuit(Suit suit);
    Boolean hasRank(Rank rank);
}
