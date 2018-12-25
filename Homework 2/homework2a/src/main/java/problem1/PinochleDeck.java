package problem1;

import java.util.ArrayList;

/**
 * An Pinochle Deck class which implements Deck interface
 *
 *  @author Sushmita Chaudhari
 */
class PinochleDeck extends DefaultDeck {

    private static final int NO_OF_CARDS = 5;
    private static final int NO_CARDS_STANDARD = 13;


    /**
     * Pinochle Deck constructor
     */
    PinochleDeck()
    {
        specialDeck = new ArrayList<>();

        RankEnum[] pinochleRanks = getPinochleRank();

        for(SuitEnum suit : SuitEnum.values())
        {
            for(RankEnum rank : pinochleRanks)
            {
                specialDeck.add(new CardClass(rank, suit));
            }
        }
        specialDeck.addAll(new ArrayList<>(specialDeck));

        super.setNumberOfCardsDealt(0);
        super.setOfficialSize(specialDeck.size());

    }

    /**
     * Rank values for Pinochle Deck - A, 9, 10, J, Q, K
     * @return RankEnum array of rank values for Pinochle Deck
     */
    private RankEnum[] getPinochleRank()
    {
        RankEnum[] rankEnums = RankEnum.values();
        RankEnum[] pinochleRanks = new RankEnum[NO_OF_CARDS + 1];

        pinochleRanks[0] = rankEnums[0];

        //Building the Rank for Euchre Deck from Default Rank implementation
        for(int i = NO_CARDS_STANDARD - NO_OF_CARDS, j = 1; i < rankEnums.length; i++, j++)
        {
            pinochleRanks[j] = rankEnums[i];
        }
        return pinochleRanks;
    }

}
