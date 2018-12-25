package problem1;

import java.util.ArrayList;

/**
 * An Euchre Deck class which extends DefaultDeck class
 *
 * A Euchre deck, which is composed of 9, 10, J, Q, K, and A of the four suits  24 cards in total.
 *
 * @author Sushmita Chaudhari
 */
class EuchreDeck extends DefaultDeck {

    private static final int NO_OF_CARDS = 5;
    private static final int NO_CARDS_STANDARD = 13;


    /**
     * Euchre Deck constructor
     */
    EuchreDeck()
    {
        //Euchre Deck
        specialDeck = new ArrayList<>();

        //Rank for Euchre Deck is different than other decks
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

    /**
     * Rank values for Euchre Deck - A, 9, 10, J, Q, K
     * @return RankEnum array of rank values for Euchre Deck
     */
    private static  RankEnum[] getEuchreRanks()
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
