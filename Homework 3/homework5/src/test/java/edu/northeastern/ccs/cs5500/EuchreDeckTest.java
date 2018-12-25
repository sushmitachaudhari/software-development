package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class EuchreDeckTest {

    /**
     * Test A deck has the right cards in it and the right number of cards.
     */
    @Test
    public void testADeck()
    {
        /* actual card from an actual deck */

        Deck actualDeck = EuchreDeck.getEuchreDeckInstance();
        int actualDeckSize = ((EuchreDeck) actualDeck).getSize();
        Card actualCard = actualDeck.pullCard();
        System.out.println("rank pips: "+actualCard.getRank().getPips()+" suit name: "+actualCard.getSuit().getName());


        Rank rank = RankEnum.TWO;
        Suit suit = SuitEnum.HEARTS;
        Card expectedCard = new CardClassAdapter(rank, suit);
        int expectedDeckSize = 24;

        assertEquals("The cards' rank must be same.", expectedCard.getRank(), actualCard.getRank());
        assertEquals("The cards' suit must be same.", expectedCard.getSuit(), actualCard.getSuit());

        assertEquals("The size of deck should be 24.", expectedDeckSize,actualDeckSize);
    }

    /**
     * Test A deck after being shuffled has a different order than before.
     */
    @Test
    public void shuffle() {

        Deck unshuffledDeck = EuchreDeck.getEuchreDeckInstance();
        Deck shuffledDeck = EuchreDeck.getEuchreDeckInstance();
        shuffledDeck.shuffle();

        Card cardFromUnshuffledDeck = unshuffledDeck.pullCard();
        Card cardFromShuffedDeck = shuffledDeck.pullCard();

        /*The two decks are  equal.*/
        assertEquals("These decks must be same.", unshuffledDeck, shuffledDeck);

        assertNotEquals("These cards must not be same", cardFromShuffedDeck, cardFromUnshuffledDeck);
    }

    /**
     * Test A deck after being sorted by rank, suit, or both rank and suit, is in the expected order
     */
    @Test
    public void sort() {

        Deck unsortedDeck = EuchreDeck.getEuchreDeckInstance();
        Deck sortedDeck = EuchreDeck.getEuchreDeckInstance();


        sortedDeck.sort("suit");

        //test for singleton - there is only one instance od Euchre deck.
        assertEquals("The sorted and unsorted decks are not equal.", unsortedDeck, sortedDeck);

        assertEquals("The first and second card of the sorted deck have same suit.",
                sortedDeck.pullCard().getSuit().getSymbol(), sortedDeck.pullCard().getSuit().getSymbol());

        sortedDeck.sort("rank");
        assertNotEquals("First card's pips is 1 less then second card's pips.",
                ((EuchreDeck) sortedDeck).getCardFromDeck(1).getRank().getPips(),
                ((EuchreDeck) sortedDeck).getCardFromDeck(2).getRank().getPips() - 1);


        sortedDeck.sort("both");
        assertEquals("The sorted and unsorted decks are not equal.",
                ((EuchreDeck) sortedDeck).getCardFromDeck(1).getRank().getPips(),
                ((EuchreDeck) sortedDeck).getCardFromDeck(2).getRank().getPips());

    }

    /**
     * A deck after being cut is in the right order
     */
    @Test
    public void cut() {

        Deck deckToBeCut = EuchreDeck.getEuchreDeckInstance();

        /**test the cutpoint card and first card*/


        //pull out the card at cutpoint before cutting the card
        Card selectedCard = ((EuchreDeck) deckToBeCut).getCardFromDeck(5);

        //cut the card
        deckToBeCut.cut(5);

        //pull the first card after cutting it
        Card expectedSelectedCard = ((EuchreDeck) deckToBeCut).getCardFromDeck(1);


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
        Deck deck = EuchreDeck.getEuchreDeckInstance();
        int actualSize = ((EuchreDeck) deck).getSize();

        Card card = deck.pullCard();
        //Pulled card will not exist anymore in the deck.
        assertFalse("The card is not in deck anymore.", ((EuchreDeck) deck).hasCard(card));

        int newDeckSize = ((EuchreDeck) deck).getSize();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }

    /**
     * An empty deck is indeed empty. A deck with cards in it is indeed not empty.
     */
    @Test
    public void emptyDeck() {

        Deck fullDeck = EuchreDeck.getEuchreDeckInstance();
        assertEquals("The deck is not empty.", fullDeck.emptyDeck(), false);

    }

}