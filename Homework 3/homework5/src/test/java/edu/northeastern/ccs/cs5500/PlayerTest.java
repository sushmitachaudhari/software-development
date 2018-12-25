package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State;
import edu.northeastern.ccs.cs5500.states.State1720;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class PlayerTest {

    private List<NewHand> listOfHand = new ArrayList<>();
    private List<Card> listOfCards = new ArrayList<>();
    private Card dealerCard;

    /**
     * Set up the hands
     */
    void setUp()
    {
       Card c = new CardClassAdapter(RankEnum.KING, SuitEnum.HEARTS);
       listOfCards.add(c);
       NewHand newHand = new NewHandClass(listOfCards);
       dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);

       listOfHand.add(newHand);
    }

    /**
     * Test to get the name of the player.
     */
    @Test
    public void getName() {

        String expectedName = "Me";
        Player newPlayer = new Player("Me", listOfHand, dealerCard);
        String actualName = newPlayer.getName();
        assertEquals("The name of the player must be Me.",expectedName, actualName);
    }

    /**
     * Test to see if a new hand can be added to the list of hand
     */
    @Test
    public void addHand() {
        List<Card> newCards = new ArrayList<>();
        Card c = new CardClassAdapter(RankEnum.THREE, SuitEnum.SPADES);
        newCards.add(c);

        NewHand hand = new NewHandClass(newCards);
        int sizeOfOriginalHands = listOfHand.size();
        listOfHand.add(hand);
        int newSizeofHand = listOfHand.size();

        assertEquals("The size must be greater by one.", sizeOfOriginalHands + 1, newSizeofHand);
    }

    @Test
    public void decision() {

        /**
         * Tests for hard totals
         */
        PlayerActionEnum expectedActionEnum = PlayerActionEnum.HIT;
        PlayerActionEnum expectedActionEnum1 = PlayerActionEnum.STAND;
        PlayerActionEnum expectedActionEnum2 = PlayerActionEnum.HIT;

        /* Test for HIT */
        List<Card> newCards = new ArrayList<>();
        Card c = new CardClassAdapter(RankEnum.SIX, SuitEnum.CLUBS);
        Card c2 = new CardClassAdapter(RankEnum.THREE, SuitEnum.DIAMONDS);
        Card dealerCard = new CardClassAdapter(RankEnum.SIX, SuitEnum.SPADES);
        newCards.add(c);
        newCards.add(c2);
        NewHand hand = new NewHandClass(newCards);
        listOfHand.add(hand);

        Player player = new Player("Player1", listOfHand, dealerCard);

        int pip = c.getRank().getPips();
        int pip2 = c2.getRank().getPips();

        assertEquals(expectedActionEnum, player.decision(hand, pip+pip2));

        /**
         * Tests for soft totals
         */
        /* Test for another HIT */
        List<Card> newCards2 = new ArrayList<>();
        Card card3 = new CardClassAdapter(RankEnum.NINE, SuitEnum.SPADES);
        Card card4 = new CardClassAdapter(RankEnum.THREE, SuitEnum.HEARTS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.THREE, SuitEnum.SPADES);
        newCards2.add(card3);
        newCards2.add(card4);
        NewHand hand2 = new NewHandClass(newCards2);
        List<NewHand> listOfHand2 = new ArrayList<>();
        listOfHand2.add(hand2);

        Player player2 = new Player("Player1", listOfHand2, dealerCard2);

        assertEquals(expectedActionEnum2, player2.decision(hand2, card3.getRank().getPips() + card4.getRank().getPips()));

        /**
         * Tests for pair totals
         */
        /* Test for STAND */
        List<Card> newCards1 = new ArrayList<>();
        Card card1 = new CardClassAdapter(RankEnum.NINE, SuitEnum.CLUBS);
        Card card2 = new CardClassAdapter(RankEnum.EIGHT, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.SPADES);
        newCards1.add(card1);
        newCards1.add(card2);
        NewHand hand1 = new NewHandClass(newCards1);
        List<NewHand> listOfHand1 = new ArrayList<>();
        listOfHand1.add(hand1);

        Player player1 = new Player("Player1", listOfHand1, dealerCard1);

        assertEquals(expectedActionEnum1, player1.decision(hand1, card1.getRank().getPips() + card2.getRank().getPips()));

    }

    /**
     * Testing the player hands
     */
    @Test
    public void getPlayerNewHands() {

        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.SPADES);
        Card card1 = new CardClassAdapter(RankEnum.THREE, SuitEnum.HEARTS);
        List<Card> newCards = new ArrayList<>();
        newCards.add(card);
        newCards.add(card1);

        NewHand newHand = new NewHandClass(newCards);

        List<NewHand> newHands = new ArrayList<>();
        newHands.add(newHand);

        Card dealerCardX = new CardClassAdapter(RankEnum.ONE, SuitEnum.SPADES);
        Player playerX = new Player("Player1", newHands, dealerCardX);

        assertEquals("The size of the list of hands are same.", playerX.getPlayerNewHands().size(), newHands.size());
    }

    /**
     * Test the credits a Player has
     */
    @Test
    public void getCredits() {
        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.SPADES);
        Card card1 = new CardClassAdapter(RankEnum.THREE, SuitEnum.HEARTS);
        List<Card> newCards = new ArrayList<>();
        newCards.add(card);
        newCards.add(card1);

        NewHand newHand = new NewHandClass(newCards);

        List<NewHand> newHands = new ArrayList<>();
        newHands.add(newHand);

        Card dealerCardX = new CardClassAdapter(RankEnum.ONE, SuitEnum.SPADES);
        Player playerX = new Player("Player1", newHands, dealerCardX);

        int credits = playerX.getCredits();
        int expectedCredits = 5;

        assertEquals("The credits are 5.", expectedCredits, credits);
    }

    /**
     * Test the setCredits method for setting credits for a player
     */
    @Test
    public void setCredits() {
        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.SPADES);
        Card card1 = new CardClassAdapter(RankEnum.THREE, SuitEnum.HEARTS);
        List<Card> newCards = new ArrayList<>();
        newCards.add(card);
        newCards.add(card1);

        NewHand newHand = new NewHandClass(newCards);

        List<NewHand> newHands = new ArrayList<>();
        newHands.add(newHand);

        Card dealerCardX = new CardClassAdapter(RankEnum.ONE, SuitEnum.SPADES);
        Player playerX = new Player("Player1", newHands, dealerCardX);
        playerX.setCredits(6);

        assertEquals("The credits are 5.", playerX.getCredits(), 6);
    }

    /**
     * Test hard hand
     */
    @Test
    public void hardNewHand()
    {
        int total = 20;
        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.SPADES);
        Card card1 = new CardClassAdapter(RankEnum.THREE, SuitEnum.HEARTS);
        List<Card> newCards = new ArrayList<>();
        newCards.add(card);
        newCards.add(card1);

        NewHand newHand = new NewHandClass(newCards);

        List<NewHand> newHands = new ArrayList<>();
        newHands.add(newHand);

        Card dealerCardX = new CardClassAdapter(RankEnum.ONE, SuitEnum.SPADES);
        Player playerX = new Player("Player1", newHands, dealerCardX);

        State actualState = playerX.hardNewHand(total);
        State expectedState = State1720.getInstance();

        assertEquals(actualState, expectedState);

    }
}