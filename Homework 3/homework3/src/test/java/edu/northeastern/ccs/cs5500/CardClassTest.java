package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Sushmita Chaudhari
 */
public class CardClassTest {

    /**
     * A test to check a card is correctly created and the card has the right rank and suit.
     */
    @Test
    public void createCard() {

        for (Rank rank : RankEnum.values()) {
            for (Suit suit : SuitEnum.values()) {
                Card card = new CardClass(rank, suit);

                assertEquals("The cards of eacg kind of Rank is constructed.", card.getRank(), rank);
                assertEquals("The cards of eacg kind of Suit is constructed.", card.getSuit(), suit);
            }
        }
    }


    @Test
    public void getRank() {

        int expectedRankPips = RankEnum.EIGHT.getPips();
        String expectedRankName = RankEnum.EIGHT.getName();

        Card actualCard = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);

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

        Card actualCard = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);

        assertEquals("The expected suit name is same as the actual suit name.", expectedSuitName, actualCard.getSuit().getName());
        assertEquals("The expected suit symbol is same as the actual suit symbol.", expectedSuitSymbol, actualCard.getSuit().getSymbol());


    }

}