package homework5;

import java.util.ArrayList;

/**
 * An Standard Deck class which implements Deck interface
 *
 * @author Sushmita Chaudhari
 */

class StandardDeck extends DefaultDeck {

    private static StandardDeck standardDeckInstance;

    //create the deck for standard decktype
    /**
     * Standard Deck constructor
     */
    private StandardDeck()
    {
        specialDeck = new ArrayList<>();

        for(SuitEnum suit : SuitEnum.values())
        {
            for(RankEnum rank : RankEnum.values())
            {
                specialDeck.add(new CardClass(rank, suit));
            }
        }
        setNumberOfCardsDealt(0);
        setOfficialSize(specialDeck.size());
    }

    /* singleton implementation and lazy initialization*/
    /**
     *
     * @return instance of Standard Deck instance
     */
    static StandardDeck getStandardDeckInstance()
    {
        if(standardDeckInstance == null)
        {
            standardDeckInstance = new StandardDeck();
        }
        return standardDeckInstance;
    }

    /**
     * clear the instance
     */
    static void clear() {
        standardDeckInstance = null;
    }
}
