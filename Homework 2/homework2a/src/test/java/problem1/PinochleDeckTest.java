package problem1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PinochleDeckTest {

    /**
     * Test A deck has the right cards in it and the right number of cards.
     */
    @Test
    public void testADeck()
    {
        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;

        /* create an actual Euchre deck */
        Deck actualDeck = new PinochleDeck();

        /* Get the size of the Pinochle deck and an actual card from the deck*/
        int actualDeckSize = ((PinochleDeck) actualDeck).getSize();

        Card cardFromDeck = ((PinochleDeck) actualDeck).getCardFromDeck(1);

        /* Expected card */
        Card expectedCard = new CardClass(rank, suit);
        int expectedDeckSize = 48;

        assertEquals("These cards should have same rank.",rank, cardFromDeck.getRank());
        assertEquals("These cards should have same suit.", suit, cardFromDeck.getSuit());

        assertEquals("The cards' rank must be same.", expectedCard.getRank(), cardFromDeck.getRank());
        assertEquals("The cards' suit must be same.", expectedCard.getSuit(), cardFromDeck.getSuit());

        assertEquals("The size of deck should be 48.", expectedDeckSize,actualDeckSize);
    }

    /**
     * Test A deck after being shuffled has a different order than before.
     */
    @Test
    public void shuffle() {

        Deck unshuffledDeck = new PinochleDeck();
        Deck shuffledDeck = new PinochleDeck();
        shuffledDeck.shuffle();

        Card cardFromUnshuffledDeck = unshuffledDeck.pullCard();
        Card cardFromShuffedDeck = shuffledDeck.pullCard();

        /*The two decks must have different hascodes hence, won't be equal.*/
        assertNotEquals("These decks must not be same.", unshuffledDeck, shuffledDeck);

        assertNotEquals("These cards must not be same", cardFromShuffedDeck, cardFromUnshuffledDeck);
    }

    /**
     * Test A deck after being sorted by rank, suit, or both rank and suit, is in the expected order
     */
    @Test
    public void sort() {

        Deck unsortedDeck = new PinochleDeck();
        Deck sortedDeck = new PinochleDeck();


        sortedDeck.sort("suit");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);
        assertEquals("The first and second card of the sorted deck have same suit.",
                                ((PinochleDeck) sortedDeck).getCardFromDeck(1).getSuit().getSymbol(), ((PinochleDeck) sortedDeck).getCardFromDeck(2).getSuit().getSymbol());

        sortedDeck.sort("rank");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);
        assertEquals("The first and second card of the sorted deck have same suit.",
                sortedDeck.pullCard().getRank().getPips(), sortedDeck.pullCard().getRank().getPips());


        sortedDeck.sort("both");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);

    }

    /**
     * A deck after being cut is in the right order
     */
    @Test
    public void cut() {

        Deck deckToBeCut = new PinochleDeck();

        /**test the cutpoint card and first card*/


        //pull out the card at cutpoint before cutting the card
        Card selectedCard = ((PinochleDeck) deckToBeCut).getCardFromDeck(5);

        //cut the card
        deckToBeCut.cut(5);

        //pull the first card after cutting it
        Card expectedSelectedCard = deckToBeCut.pullCard();


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
        Deck deck = new PinochleDeck();
        int actualSize = ((PinochleDeck) deck).getSize();

        deck.pullCard();

        int newDeckSize = ((PinochleDeck) deck).getSize();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }

    /**
     * An empty deck is indeed empty. A deck with cards in it is indeed not empty.
     */
    @Test
    public void emptyDeck() {

        Deck fullDeck = new PinochleDeck();
        assertEquals("The deck is not empty.", fullDeck.emptyDeck(), false);

    }
}