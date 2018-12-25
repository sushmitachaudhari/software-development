package homework5;

import java.util.ArrayList;

/**
 * An Euchre Deck class which implements Deck interface
 *
 * @author Sushmita Chaudhari
 */
class EuchreDeck extends DefaultDeck {

    private static final int NO_OF_CARDS = 5;
    private static final int NO_CARDS_STANDARD = 13;

    private static EuchreDeck euchreDeckInstance;

    //Singleton
    /**
     * Euchre Deck constructor
     */
    private EuchreDeck()
    {
        //Euchre Deck
        specialDeck = new ArrayList<>();

        //Rank for Euchre Deck from Default Rank implementation
        RankEnum[] euchreRanks = getEuchreRanks();

        //Creating Euchre Deck
        for(SuitEnum suit: SuitEnum.values())
        {
            for(RankEnum rank: euchreRanks)
            {
               specialDeck.add(new CardClass(rank, suit));
            }
        }
        super.setNumberOfCardsDealt(0);
        super.setOfficialSize(specialDeck.size());
    }

    /* singleton implementation and lazy initialization*/
    /* get EuchreDeck instance */

    /**
     *
     * @return instance of Euchre deck instance
     */
    static EuchreDeck getEuchreDeckInstance()
    {
        if(euchreDeckInstance == null)
        {
            euchreDeckInstance = new EuchreDeck();
        }

        return euchreDeckInstance;
    }

    /**
     * Rank values for Euchre Deck - A, 9, 10, J, Q, K
     * @return RankEnum array of rank values for Euchre Deck
     */
    private RankEnum[] getEuchreRanks()
    {
        RankEnum[] rankEnums = RankEnum.values();
        RankEnum[] euchreRanks = new RankEnum[NO_OF_CARDS + 1];

        euchreRanks[0] = rankEnums[0];

        int j = 1;
        //Building the Rank for Euchre Deck from Default Rank implementation
        for(int i = NO_CARDS_STANDARD - NO_OF_CARDS; i < rankEnums.length; i++, j++)
        {
            euchreRanks[j] = rankEnums[i];
        }
        return euchreRanks;
    }

    /**
     * clears the deck instance
     */
    static void clear() {
        euchreDeckInstance = null;
    }


}
