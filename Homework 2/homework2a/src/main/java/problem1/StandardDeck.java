package problem1;

import java.util.*;

/**
 * An Standard Deck class which implements Deck interface
 *
 * @author Sushmita Chaudhari
 */
public class StandardDeck extends DefaultDeck{


    /**
     * Standard Deck constructor
     */
    StandardDeck()
    {
        specialDeck = new ArrayList<>();

        for(Suit suit : SuitEnum.values())
        {
            for(Rank rank : RankEnum.values())
            {
                specialDeck.add(new CardClass(rank, suit));
            }
        }
        super.setNumberOfCardsDealt(0);
        super.setOfficialSize(specialDeck.size());
    }

}
