package problem1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class CardClassTest {

    /**
     * A test to check a card is correctly created and the card has the right rank.
     */
    @Test
    public void getRank() {

        int expectedRankPips = RankEnum.JACK.getPips();
        String expectedRankName = RankEnum.JACK.getName();

        Card actualCard = new CardClass(RankEnum.JACK, SuitEnum.SPADES);

        assertEquals("The expected rank pips is same as the actual rank pips.", expectedRankPips, actualCard.getRank().getPips());
        assertEquals("The expected rank name is same as the actual rank name.", expectedRankName, actualCard.getRank().getName());

    }

    /**
     * Test to check a card is correctly created and the card has the right suit.
     */
    @Test
    public void getSuit() {

        String expectedSuitName = SuitEnum.SPADES.getName();
        char expectedSuitSymbol = SuitEnum.SPADES.getSymbol();

        Card actualCard = new CardClass(RankEnum.EIGHT, SuitEnum.SPADES);

        assertEquals("The expected suit name is same as the actual suit name.", expectedSuitName, actualCard.getSuit().getName());
        assertEquals("The expected suit symbol is same as the actual suit symbol.", expectedSuitSymbol, actualCard.getSuit().getSymbol());


    }

}