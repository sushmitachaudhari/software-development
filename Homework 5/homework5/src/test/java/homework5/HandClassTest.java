package homework5;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class HandClassTest {
    private List<Card> listOfCard = new ArrayList<>();

    @Before
    public void setUp() {
        StandardDeck.clear();
        EuchreDeck.clear();
        PinochleDeck.clear();

        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;

        Rank rank1 = RankEnum.EIGHT;
        Suit suit1 = SuitEnum.HEARTS;

        Card card = new CardClass(rank, suit);
        Card card1 = new CardClass(rank1, suit1);

        listOfCard.add(card);
        listOfCard.add(card1);
    }

    /**
     * Test A hand is properly constructed.
     */
    @Test
    public void constructAHand()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand newHand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertEquals("hand is created", newHand.showCards(), listOfCard);
    }

    /**
     * Boundary test for creating a hand
     */
    @Test
    public void constructAHandWithMaxCards()
    {
        List<Card> cards = new ArrayList<>();
        for(Rank rank : RankEnum.values())
        {
            for(Suit suit : SuitEnum.values())
            {
                cards.add(new CardClass(rank, suit));
            }
        }

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(cards, cards.size());
        assertEquals(hand.showCards().size(), cards.size());
    }

    /**
     * Test if hand can show the cards it has and it has the same size
     */
    @Test
    public void showCardsSize() {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertEquals("shows cards size", hand.showCards().size(), listOfCard.size());
    }

    /**
     * Test if hand can show the cards it has and it has the same size
     */
    @Test
    public void showCards() {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        List<Card> testCards = new ArrayList<>(listOfCard);
        assertEquals("shows cards", hand.showCards(), testCards);
    }

    /**
     * Test A hand properly accepts a card.
     */
    @Test
    public void acceptHandSize() {
        int numOfCardsInHand = 5;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, numOfCardsInHand);
        int handSize = hand.showCards().size();
        Card newCard = new CardClass(RankEnum.SEVEN, SuitEnum.SPADES);
        hand.accept(newCard);
        assertEquals(handSize + 1, hand.showCards().size());
    }

    /**
     * Test A hand properly accepts a card .
     */
    @Test
    public void acceptACardHand() {
        int numOfCardsInHand = 5;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, numOfCardsInHand);
        Card newCard = new CardClass(RankEnum.SEVEN, SuitEnum.SPADES);
        hand.accept(newCard);
        assertTrue(hand.hasCard(newCard));
    }

    /**
     * Test A hand does not accept a card when maz size is reached.
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotAcceptCard() {
        int numOfCardsInHand = 5;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, numOfCardsInHand);
        Card newCard = new CardClass(RankEnum.SEVEN, SuitEnum.SPADES);
        //3rd card
        hand.accept(newCard);
        //4th
        hand.accept(newCard);
        //5th
        hand.accept(newCard);
        //should throw an unchecked exception
        hand.accept(newCard);
    }

    /**
     * Test When a card is pulled from the hand, that card is no longer in
     * the hand.
     */
    @Test
    public void pulledCardIsNotInHand() {
        int maxHandSize = 6;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, maxHandSize);
        Card card = hand.pullCard();
        //Pulled card does not exist anymore in the hand.
        assertFalse("The card is not in deck anymore.", hand.hasCard(card));
    }


    @Test
    public void pulledCardHandSizeDecreased() {
        int maxHandSize = 6;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, maxHandSize);
        int handSize = hand.showCards().size();
        hand.pullCard();
        assertEquals(handSize - 1, hand.showCards().size());
    }


    @Test(expected = IllegalStateException.class)
    public void pullCardWhenNoCardsInHand() {
        int maxHandSize = 6;
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, maxHandSize);
        hand.pullCard();
        hand.pullCard();
        hand.pullCard();
    }

    /**
     * Test The hand tells accurately whether a particular card, rank, or suit is present.
     */
    @Test
    public void hasCardPositive() {

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, 6);
        Card card = new CardClass(RankEnum.FIVE, SuitEnum.HEARTS);
        hand.accept(card);

        assertTrue(hand.hasCard(new CardClass(RankEnum.FIVE, SuitEnum.HEARTS)));
    }

    /**
     * Should return false
     */
    @Test
    public void hasCardNegative() {

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, 6);
        Card card = new CardClass(RankEnum.FIVE, SuitEnum.HEARTS);
        hand.accept(card);

        assertFalse(hand.hasCard(new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS)));
    }

    /**
     * The hand properly sorts the card by suit, rank, or both suit and rank.
     */
    @Test
    public void sortBySuit() {

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

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(cards, cards.size());
        hand.sort("suit");
        List<Card> sortedCards = hand.showCards();

        assertEquals(SuitEnum.SPADES, sortedCards.get(0).getSuit());
        assertEquals(SuitEnum.HEARTS, sortedCards.get(1).getSuit());
        assertEquals(SuitEnum.HEARTS, sortedCards.get(2).getSuit());
        assertEquals(SuitEnum.DIAMONDS,sortedCards.get(3).getSuit());
        assertEquals(SuitEnum.CLUBS, sortedCards.get(4).getSuit());

    }

    /**
     * The hand properly sorts the card by suit, rank, or both suit and rank.
     */
    @Test
    public void sortByRank() {

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

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(cards, cards.size());
        hand.sort("rank");
        List<Card> sortedCards = hand.showCards();

        assertEquals(RankEnum.FOUR, sortedCards.get(0).getRank());
        assertEquals(RankEnum.FIVE, sortedCards.get(1).getRank());
        assertEquals(RankEnum.SIX, sortedCards.get(2).getRank());
        assertEquals(RankEnum.SEVEN,sortedCards.get(3).getRank());
        assertEquals(RankEnum.EIGHT, sortedCards.get(4).getRank());

    }

    /**
     * The hand properly sorts the card by suit, rank, or both suit and rank.
     */
    @Test
    public void sortByBoth() {

        List<Card> cards = new ArrayList<>();
        Card c1 = new CardClass(RankEnum.EIGHT, SuitEnum.HEARTS);
        Card c2 = new CardClass(RankEnum.SEVEN, SuitEnum.HEARTS);
        Card c3 =new CardClass(RankEnum.SIX, SuitEnum.CLUBS);
        Card c4 =new CardClass(RankEnum.FIVE, SuitEnum.SPADES);
        Card c5 =new CardClass(RankEnum.FOUR, SuitEnum.DIAMONDS);
        Card c6 =new CardClass(RankEnum.FOUR, SuitEnum.CLUBS);
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(cards, cards.size());
        hand.sort("both");
        List<Card> sortedCards = hand.showCards();

        assertEquals(SuitEnum.DIAMONDS,sortedCards.get(0).getSuit());
        assertEquals(SuitEnum.CLUBS, sortedCards.get(1).getSuit());

        assertEquals(RankEnum.FOUR, sortedCards.get(0).getRank());
        assertEquals(RankEnum.FOUR, sortedCards.get(1).getRank());
        assertEquals(RankEnum.FIVE, sortedCards.get(2).getRank());
        assertEquals(RankEnum.SIX, sortedCards.get(3).getRank());
        assertEquals(RankEnum.SEVEN,sortedCards.get(4).getRank());
        assertEquals(RankEnum.EIGHT, sortedCards.get(5).getRank());

    }

    @Test
    public void shuffledHandHasSameSize()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        int handSizeBeforeShuffle = hand.showCards().size();
        hand.shuffle();
        int handSizeAfterShuffle = hand.showCards().size();
        assertEquals(handSizeBeforeShuffle, handSizeAfterShuffle);
    }


    @Test
    public void shuffledHandHasSameCards()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        List<Card> cardsBefore = hand.showCards();
        hand.shuffle();
        List<Card> cardsAfter = hand.showCards();

        for (Card card : cardsAfter) {
            assertTrue(cardsBefore.contains(card));
        }
    }

    @Test
    public void shuffledHandHasSameCardsInDiffOrder()
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
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(cards, cards.size());
        List<Card> unshuffledCards = new ArrayList<>(hand.showCards());
        hand.shuffle();
        List<Card> shuffledCards = hand.showCards();

        boolean atleastOneInDifferentPos = false;
        for (int i = 0; i <unshuffledCards.size(); i++) {
            assertTrue(shuffledCards.contains(unshuffledCards.get(i)));
            atleastOneInDifferentPos = atleastOneInDifferentPos | (i != shuffledCards.indexOf(unshuffledCards.get(i)));
        }
    }

   @Test
    public void hasSuitPositive()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertTrue(hand.hasSuit(SuitEnum.CLUBS));
    }

    @Test
    public void hasSuitNegative()
    {

        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertFalse(hand.hasSuit(SuitEnum.DIAMONDS));
    }

    @Test
    public void hasRank()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertTrue(hand.hasRank(RankEnum.EIGHT));
    }

    @Test
    public void hasRankNegative()
    {
        HandClassFactory handClassFactory = new HandClassFactory();
        Hand hand = handClassFactory.createHandClass(listOfCard, listOfCard.size());
        assertFalse("No Diamonds", hand.hasRank(RankEnum.QUEEN));
    }

}