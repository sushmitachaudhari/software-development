
package edu.northeastern.ccs.cs5500;

import org.junit.Assert;
import org.junit.Test;


import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

public class CardClassAdapterTest {

    /**
     * A test to check a card is correctly created and the card has the right rank and suit.
     */
    @Test
    public void createCard() {

        for (Rank rank : RankEnum.values()) {
            for (Suit suit : SuitEnum.values()) {
                Card card = new CardClassAdapter(rank, suit);

                Assert.assertEquals("The cards of each kind of Rank is constructed.", card.getRank(), rank);
                Assert.assertEquals("The cards of each kind of Suit is constructed.", card.getSuit(), suit);
            }
        }
    }



    /**
     * A test to check a card is correctly created and the card has the right rank.
     */

    @Test
    public void getRank() {

        int expectedRankPips = RankEnum.ONE.getPips();
        String expectedRankName = RankEnum.ONE.getName();

        Card actualCard = new CardClassAdapter(RankEnum.ONE, SuitEnum.HEARTS);

        assertEquals("The expected rank pips is same as the actual rank pips.", expectedRankPips, actualCard.getRank().getPips());
        assertEquals("The expected rank name is same as the actual rank name.", expectedRankName, actualCard.getRank().getName());

    }


    /**
     * Test to check a card is correctly created and the card has the right suit.
     */

    @Test
    public void getSuit() {

        String expectedSuitName = SuitEnum.HEARTS.getName();
        char expectedSuitSymbol = SuitEnum.HEARTS.getSymbol();

        Card actualCard = new CardClassAdapter(RankEnum.EIGHT, SuitEnum.HEARTS);

        assertEquals("The expected suit name is same as the actual suit name.", expectedSuitName, actualCard.getSuit().getName());
        assertEquals("The expected suit symbol is same as the actual suit symbol.", expectedSuitSymbol, actualCard.getSuit().getSymbol());
    }

}
