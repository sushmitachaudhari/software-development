package homework5;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class StandardDeckTest {

    @Before
    public void setUp() {
        StandardDeck.clear();
    }

    /**
     * Test A deck after being shuffled has a different order than before.
     */
    @Test
    public void shuffle() {

        Deck unshuffledDeck = StandardDeck.getStandardDeckInstance();
        StandardDeck.clear();
        Deck shuffledDeck = StandardDeck.getStandardDeckInstance();
        shuffledDeck.shuffle();

        List<Card> unhuffledCards = ((StandardDeck) unshuffledDeck).getSpecialDeck();

        //*The two decks must have different hashcode hence, won't be equal.*//
        assertNotEquals("These decks must not be same.", unshuffledDeck, shuffledDeck);

        for (Card card : ((StandardDeck) shuffledDeck).getSpecialDeck()) {
            assertTrue(unhuffledCards.contains(card));
        }
    }

    /**
     * Test A deck after being sorted by rank, suit, or both rank and suit, is in the expected order
     */
    @Test
    public void sort() {

        Deck unsortedDeck = StandardDeck.getStandardDeckInstance();
        StandardDeck.clear();
        Deck sortedDeck = StandardDeck.getStandardDeckInstance();


        sortedDeck.sort("suit");
        //Both deck should have different hashcode
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);
        assertEquals("The first and second card of the sorted deck have same suit symbol.",
                ((StandardDeck) sortedDeck).getCardFromDeck(1).getSuit().getSymbol(), ((StandardDeck) sortedDeck).getCardFromDeck(2).getSuit().getSymbol());

        Deck sortedDeck2 = StandardDeck.getStandardDeckInstance();

        sortedDeck2.sort("rank");
        assertEquals("The sorted and unsorted decks are not equal.",
                ((StandardDeck) sortedDeck2).getCardFromDeck(1).getRank().getPips(),
                ((StandardDeck) sortedDeck2).getCardFromDeck(1).getRank().getPips());

        Card card1 = ((StandardDeck) sortedDeck2).getCardFromDeck(1);
        Card card2 = ((StandardDeck) sortedDeck2).getCardFromDeck(2);
        assertEquals("The first two cards have same pip.",
                card1.getRank().getPips(), card2.getRank().getPips());


        sortedDeck.sort("both");
        assertNotEquals("Suits are different.",
                ((StandardDeck) sortedDeck).getCardFromDeck(1).getSuit().getName(),
                ((StandardDeck) sortedDeck).getCardFromDeck(2).getSuit().getName());
    }

    /**
     * A deck after being cut is in the right order
     */
    @Test
    public void cut() {

        Deck deckToBeCut = StandardDeck.getStandardDeckInstance();

        /**test the cutpoint card and first card*/


        //pull out the card at cutpoint before cutting the card
        Card selectedCard = ((StandardDeck) deckToBeCut).getCardFromDeck(5);

        //cut the card
        deckToBeCut.cut(5);

        //pull the first card after cutting it
        Card expectedSelectedCard = ((StandardDeck) deckToBeCut).getCardFromDeck(1);


        assertEquals("These cards should have same pips",
                selectedCard.getRank().getPips(), expectedSelectedCard.getRank().getPips());
        assertEquals("These cards should have same name",
                selectedCard.getRank().getName(), expectedSelectedCard.getRank().getName());

        assertEquals("The cards should have same symbol.",
                selectedCard.getSuit().getSymbol(),expectedSelectedCard.getSuit().getSymbol());
        assertEquals("The cards should hace same name same.",
                selectedCard.getSuit().getName(),expectedSelectedCard.getSuit().getName());


    }

    /**
     * A deck after a card is pulled has one less card than before that card was pulled (and that card is
     * no longer in the deck). Beware of the pinochle deck for this test case!
     */
    @Test
    public void pullCard() {
        Deck deck = StandardDeck.getStandardDeckInstance();
        int actualSize = ((StandardDeck) deck).getSize();

        Card card = deck.pullCard();
        //Pulled card does not exist anymore in the deck.
        assertFalse("The card is not in deck anymore.", ((StandardDeck) deck).hasCard(card));

        int newDeckSize = ((StandardDeck) deck).getSize();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }

    /**
     * An empty deck is indeed empty. A deck with cards in it is indeed not empty.
     */
    @Test
    public void emptyDeck() {

        Deck fullDeck = StandardDeck.getStandardDeckInstance();
        assertEquals("The deck is not empty.", false, fullDeck.emptyDeck() );

    }

}