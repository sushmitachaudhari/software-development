package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class NewHandClassTest {


    /**
     * Test A hand is properly constructed.
     */
    @Test
    public void constructAHand()
    {
        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;
        Card newCard = new CardClass(rank, suit);

        List<Card> listofCards = new ArrayList<>();
        listofCards.add(newCard);

        NewHand newHand = new NewHandClass(listofCards);

        assertEquals("hand is created", newHand.showCards(), listofCards);

    }

    /**
     * Test if hand can show the cards it has
     */
    @Test
    public void showCards() {

        Rank rank = RankEnum.ONE;
        Rank rank1 = RankEnum.QUEEN;
        Suit suit = SuitEnum.CLUBS;

        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new CardClass(rank, suit));
        expectedCards.add(new CardClass(rank1, suit));

        NewHand hand = new NewHandClass(expectedCards);

        assertEquals("shows cards", hand.showCards(), expectedCards);


    }

    /**
     * Test A hand properly accepts a card.
     */
    @Test
    public void accept() {
        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;
        Card newCard = new CardClass(rank, suit);

        List<Card> listofCards = new ArrayList<>();
        listofCards.add(newCard);

        NewHand newHand = new NewHandClass(listofCards);
        newHand.accept(newCard);

        assertEquals("same card", newCard, ((NewHandClass) newHand).getCardFromDeck(1));
    }

    /**
     * Test When a card is pulled from the hand, the hand now has one less card and that card is no longer in
     * the deck.
     */
    @Test
    public void pullCard() {

        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;
        Card newCard = new CardClass(rank, suit);

        List<Card> listofCards = new ArrayList<>();
        listofCards.add(newCard);



        NewHand oneHand = new NewHandClass(listofCards);

        int actualSize = ((NewHandClass) oneHand).getLenHand();

        Card card = oneHand.pullCard();
        //Pulled card does not exist anymore in the deck.
        assertFalse("The card is not in deck anymore.", oneHand.hasCard(card));

        int newDeckSize = ((NewHandClass) oneHand).getLenHand();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }



    /**
     * The hand properly sorts the card by suit, rank, or both suit and rank.
     */
    @Test
    public void sort() {

        List<Card> cards = new ArrayList<>();
        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 =new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 =new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 =new CardClass(RankEnum.FOUR, SuitEnum.DIAMONDS);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);

        NewHand hand = new NewHandClass(cards);
        hand.sort("suit");
        assertEquals("spades", "SPADES",hand.pullCard().getSuit().getName());

        hand.sort("rank");
        assertEquals("spades", 6, hand.pullCard().getRank().getPips());

    }

    /**
     * The hand properly shues the cards in it.
     */
    @Test
    public void shuffle()
    {
        List<Card> cards = new ArrayList<>();

        Card c1 = new CardClass(RankEnum.JACK, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 = new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 = new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 = new CardClass(RankEnum.FOUR, SuitEnum.DIAMONDS);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);

        NewHand hand1 = new NewHandClass(cards);

        Card cardBeforeShuffle = ((NewHandClass) hand1).getCardFromDeck(1);
        hand1.shuffle();
        Card cardAfterShuffle = ((NewHandClass) hand1).getCardFromDeck(2);

        assertNotEquals("Different pips", cardBeforeShuffle.getRank(),
                cardAfterShuffle.getRank());
        }

    /**
     * Test to check if a hand has a suit
     */
   @Test
    public void hasSuit()
    {
        List<Card> cards = new ArrayList<>();

        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 =new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 =new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 =new CardClass(RankEnum.FOUR, SuitEnum.SPADES);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);

        NewHand hand = new NewHandClass(cards);

        Boolean actual = hand.hasSuit(SuitEnum.CLUBS);
        assertTrue("Has clubs",actual);

        Boolean actual1 = hand.hasSuit(SuitEnum.DIAMONDS);
        assertFalse("No Diamonds", actual1);

    }

    /**
     * Test to check if a hand has a rank
     */
    @Test
    public void hasRank()
    {
        List<Card> cards = new ArrayList<>();

        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 =new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 =new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 =new CardClass(RankEnum.FOUR, SuitEnum.SPADES);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);

        NewHand hand = new NewHandClass(cards);

        Boolean actual = hand.hasRank(RankEnum.EIGHT);
        assertTrue("Has clubs",actual);

        Boolean actual1 = hand.hasRank(RankEnum.QUEEN);
        assertFalse("No Diamonds", actual1);
    }

    /* Tests for Iterator */


    /**
     * Test The hand tells accurately whether a particular card, rank, or suit is present.
     */
    @Test
    public void hasCard() {

        List<Card> listOfCard = new ArrayList<>();

        /**
         * Testing on empty hand
         */
        NewHand newHand = new NewHandClass(listOfCard);

        for(Rank rank : RankEnum.values())
        {
            for(Suit suit : SuitEnum.values())
            {
                assertFalse("An empty hand must never have any card.",
                        newHand.hasCard(new CardClass(rank, suit)));

            }
        }

        /**
         * Test on one card in a hand
         */
        Card card = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card notInHand = new CardClass(RankEnum.FIVE, SuitEnum.CLUBS);

        List<Card> list = new ArrayList<>();
        list.add(card);

        NewHand newHand1 = new NewHandClass(list);

        assertTrue("",newHand1.hasCard(card));
        assertFalse("", newHand1.hasCard(notInHand));

        //vary the number of cards in hand -1-5,27,52


        /**
         * test for 5 cards in hand
         */
        List<Card> cards = new ArrayList<>();
        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 =new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 =new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 =new CardClass(RankEnum.FOUR, SuitEnum.DIAMONDS);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);

        NewHand xhand = new NewHandClass(cards);
        assertTrue(xhand.hasCard(c1));
        assertTrue(xhand.hasCard(c2));
        assertTrue(xhand.hasCard(c3));
        assertTrue(xhand.hasCard(c4));
        assertTrue(xhand.hasCard(c5));


        /**
         * Test for all 52 cards in hand
         */
        List<Card> fullDeckCards = new ArrayList<>();
        for(Rank rank : RankEnum.values())
        {
            for(Suit suit : SuitEnum.values())
            {
                fullDeckCards.add(new CardClass(rank, suit));
            }
        }

        NewHand fullDeckHand = new NewHandClass(fullDeckCards);

        for(Rank rank : RankEnum.values()) {
            for (Suit suit : SuitEnum.values()) {

                assertTrue(fullDeckHand.hasCard(new CardClass(rank, suit)));

            }
        }

    }

    /**
     * Test to check the number of occurences in a hand for the rank or suit
     */
    @Test
    public void occurrencesInHand()
    {
        //empty hand
        List<Card> listOfCard = new ArrayList<>();

        /**
         * Testing on empty hand
         */
        NewHand handX = new NewHandClass(listOfCard);

        for(Rank rank : RankEnum.values()) {
            for (Suit suit : SuitEnum.values()) {
                assertEquals("An empty hand must never have any card.",
                        handX.occurrencesInHand(new CardClass(rank, suit)), 0);
                assertEquals("An empty hand has no ranks.", handX.occurrencesInHand(RankEnum.QUEEN), 0);
            }
        }

        /**
         * One card hand
         */
        List<Card> yCards = new ArrayList<>();

        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        yCards.add(c1);
        yCards.add(c1);
        yCards.add(c1);
        yCards.add(c1);
        yCards.add(c1);

        Hand newHand = new NewHandClass(yCards);

        int numberOfOccurences = ((NewHandClass) newHand).occurrencesInHand(c1);
        assertEquals("4", numberOfOccurences, 5);
        assertEquals("", ((NewHandClass) newHand).occurrencesInHand(RankEnum.EIGHT), 5);



        /**
         * Full deck hand
         */

        List<Card> fullDeckCards = new ArrayList<>();
        for(Rank rank : RankEnum.values())
        {
            for(Suit suit : SuitEnum.values())
            {
                fullDeckCards.add(new CardClass(rank, suit));
            }
        }

        NewHand fullDeckHand = new NewHandClass(fullDeckCards);

        for(Rank rank : RankEnum.values())
        {
            for(Suit suit : SuitEnum.values()) {
               assertEquals("has card in the entire deck hand.",
                       fullDeckHand.occurrencesInHand(new CardClass(rank, suit)), 1);
               assertEquals("Ranks of 4 in a full deck hand.", fullDeckHand.occurrencesInHand(rank), 4);
            }
        }
    }

    /*Extra tests directly on HandIterator*/
    @Test
    public void HandIterator()
    {
        List<Card> cards = new ArrayList<>();

        Card card1 = new CardClass(RankEnum.FIVE, SuitEnum.CLUBS);
        Card card2 = new CardClass(RankEnum.SEVEN, SuitEnum.SPADES);
        Card card3 = new CardClass(RankEnum.NINE, SuitEnum.HEARTS);
        Card card4 = new CardClass(RankEnum.ONE, SuitEnum.DIAMONDS);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        NewHandClass newHandClass = new NewHandClass(cards);

        NewHandClass.HandIterator itr = newHandClass.getIterator();

        while(itr.hasNext())
        {
            assertTrue("This test iterates through the iterator and checks if the hand has all the cards added to it." +
                    "", newHandClass.hasCard(itr.next()));
        }
    }
}