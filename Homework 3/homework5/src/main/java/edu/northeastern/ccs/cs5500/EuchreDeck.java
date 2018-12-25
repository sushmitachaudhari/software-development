package edu.northeastern.ccs.cs5500;

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
        specialDeck = new ArrayList<Card>();

        //Rank for Euchre Deck from Default Rank implementation
        RankEnum[] euchreRanks = getEuchreRanks();

        //Creating Euchre Deck
        for(SuitEnum suit: SuitEnum.values())
        {
            for(RankEnum rank: euchreRanks)
            {
               specialDeck.add(new CardClassAdapter(rank, suit));
            }
        }
        super.setNumberOfCardsDealt(0);
        super.setOfficialSize(specialDeck.size());
    }

    /* singleton implementation and lazy initialization*/
    /* get EuchreDeck instance */
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

        //Building the Rank for Euchre Deck from Default Rank implementation
        for(int i = NO_CARDS_STANDARD - NO_OF_CARDS, j = 1; i < rankEnums.length; i++, j++)
        {
            euchreRanks[j] = rankEnums[i];
        }
        return euchreRanks;
    }



}
