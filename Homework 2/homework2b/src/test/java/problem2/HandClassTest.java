package problem2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class HandClassTest {

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

        Hand newHand = new HandClass(listofCards);

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

        Hand hand = new HandClass(expectedCards);

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

        Hand newHand = new HandClass(listofCards);

        assertEquals("same card", newCard, newHand.pullCard());
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



        Hand oneHand = new HandClass(listofCards);

        int actualSize = ((HandClass) oneHand).getLenHand();

        Card card = oneHand.pullCard();
        //Pulled card does not exist anymore in the deck.
        assertFalse("The card is not in deck anymore.", oneHand.hasCard(card));

        int newDeckSize = ((HandClass) oneHand).getLenHand();

        assertNotEquals("These sizes are not equal.",actualSize, newDeckSize);
        assertEquals("One less than actual size.", actualSize - 1, newDeckSize);

    }

    /**
     * Test The hand tells accurately whether a particular card, rank, or suit is present.
     */
    @Test
    public void hasCard() {
        Rank rank = RankEnum.ONE;
        Suit suit = SuitEnum.CLUBS;
        Card newCard = new CardClass(rank, suit);
        Card card2 = new CardClass(RankEnum.NINE, suit);

        List<Card> listofCards = new ArrayList<>();
        listofCards.add(newCard);



        Hand oneHand = new HandClass(listofCards);

        assertTrue("",oneHand.hasCard(newCard));
        assertFalse("", oneHand.hasCard(card2));
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

        Hand hand = new HandClass(cards);
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

        Hand hand1 = new HandClass(cards);

        Card cardBeforeShuffle = ((HandClass) hand1).getCardFromDeck(1);
        hand1.shuffle();
        Card cardAfterShuffle = ((HandClass) hand1).getCardFromDeck(2);

        assertNotEquals("Different pips", cardBeforeShuffle.getRank(),
                cardAfterShuffle.getRank());
        }


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

        Hand hand = new HandClass(cards);

        Boolean actual = hand.hasSuit(SuitEnum.CLUBS);
        assertTrue("Has clubs",actual);

        Boolean actual1 = hand.hasSuit(SuitEnum.DIAMONDS);
        assertFalse("No Diamonds", actual1);

    }

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

        Hand hand = new HandClass(cards);

        Boolean actual = hand.hasRank(RankEnum.EIGHT);
        assertTrue("Has clubs",actual);

        Boolean actual1 = hand.hasRank(RankEnum.QUEEN);
        assertFalse("No Diamonds", actual1);
    }


}