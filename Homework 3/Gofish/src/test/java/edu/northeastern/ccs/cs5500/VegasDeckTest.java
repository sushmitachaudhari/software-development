package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class VegasDeckTest {

    private static int NO_DECKS = 4;
    private static int NO_CARDS = 52;

    /**
     * Test A deck has the right cards in it and the right number of cards.
     */
    @Test
    public void testADeck()
    {
        /* actual card from an actual deck */


        Deck actualDeck = new VegasDeck(NO_DECKS);
        int actualDeckSize = ((VegasDeck) actualDeck).getSize();
        Card actualCard = actualDeck.pullCard();


        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;
        Card expectedCard = new CardClass(rank, suit);
        int expectedDeckSize = NO_DECKS*NO_CARDS;

        assertEquals("The cards' rank must be same.", expectedCard.getRank(), actualCard.getRank());
        assertEquals("The cards' suit must be same.", expectedCard.getSuit(), actualCard.getSuit());

        assertEquals("The size of deck should be 48.", expectedDeckSize,actualDeckSize);
    }

    /**
     * Test A deck after being shuffled has a different order than before.
     */
    @Test
    public void shuffle() {

        Deck unshuffledDeck = new VegasDeck(NO_DECKS);
        Deck shuffledDeck = new VegasDeck(NO_DECKS);
        shuffledDeck.shuffle();

        Card cardFromUnshuffledDeck = unshuffledDeck.pullCard();
        Card cardFromShuffedDeck = shuffledDeck.pullCard();

        //*The two decks must have different hascodes hence, won't be equal.*//
        assertNotEquals("These decks must not be same.", unshuffledDeck, shuffledDeck);

        assertNotEquals("These cards must not be same", cardFromShuffedDeck, cardFromUnshuffledDeck);
    }

    /**
     * Test A deck after being sorted by rank, suit, or both rank and suit, is in the expected order
     */
    @Test
    public void sort() {

        Deck unsortedDeck = new VegasDeck(NO_DECKS);
        Deck sortedDeck = new VegasDeck(NO_DECKS);


        sortedDeck.sort("Suit");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);
        assertEquals("The first and second card of the sorted deck have same suit.",
                sortedDeck.pullCard().getSuit().getSymbol(), sortedDeck.pullCard().getSuit().getSymbol());

        sortedDeck.sort("Rank");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);
        assertEquals("The first and second card of the sorted deck have same suit.",
                sortedDeck.pullCard().getRank().getPips(), sortedDeck.pullCard().getRank().getPips());


        sortedDeck.sort("Both");
        assertNotEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);

    }

    /**
     * A deck after being cut is in the right order
     */
    @Test
    public void cut() {

        Deck deckToBeCut = new VegasDeck(NO_DECKS);

        //**test the cutpoint card and first card*//*


        //pull out the card at cutpoint before cutting the card
        Card selectedCard = ((VegasDeck) deckToBeCut).getCardFromDeck(5);

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
        Deck deck = new VegasDeck(NO_DECKS);
        int actualSize = ((VegasDeck) deck).getSize();

        Card card = deck.pullCard();
        //Pulled card does not exist anymore in the deck.
        assertTrue("The card is not in deck anymore.", ((VegasDeck) deck).hasCard(card));

        int newDeckSize = ((VegasDeck) deck).getSize();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }

    /**
     * An empty deck is indeed empty. A deck with cards in it is indeed not empty.
     */
    @Test
    public void emptyDeck() {

        Deck fullDeck = new VegasDeck(NO_DECKS);
        assertEquals("The deck is not empty.", fullDeck.emptyDeck(), false);

    }

}