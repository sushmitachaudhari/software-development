package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class BlackJackTest {

    /**
     * Test for the deal method of the BlackJack game
     */
    @Test
    public void deal() {

        BlackJack blackJack = new BlackJack(3);
        blackJack.setNumberOfhands(1);
        blackJack.createDeck("Vegas", 1);
        blackJack.deal();
        List<Card> listOfCards = new ArrayList<>();

        Card card = new CardClassAdapter(RankEnum.EIGHT, SuitEnum.DIAMONDS);
        listOfCards.add(card);
        listOfCards.add(card);
        listOfCards.add(card);

        NewHand newHand = new NewHandClass(listOfCards);

        List<NewHand> listOfHands = new ArrayList<>();
        listOfHands.add(newHand);

        Card dealerCard = new CardClassAdapter(RankEnum.SIX, SuitEnum.CLUBS);

        Player player = new Player("Player", listOfHands, dealerCard);

        List<NewHand> hands = player.getPlayerNewHands();
        NewHand hand = hands.get(hands.size() - 1);

        List<Card> handCards = hand.showCards();

        assertEquals("The players are dealt two cards.", 3, handCards.size());
    }

    /**
     * Test to set the number of hands in a game.
     */
    @Test
    public void setNumberOfhands() {

        BlackJack blackJack = new BlackJack(3);
        blackJack.setNumberOfhands(2);
        blackJack.createDeck("Vegas", 1);
        blackJack.deal();
        List<Card> listOfCards = new ArrayList<>();

        Card card = new CardClassAdapter(RankEnum.EIGHT, SuitEnum.DIAMONDS);
        listOfCards.add(card);
        listOfCards.add(card);
        listOfCards.add(card);

        NewHand newHand = new NewHandClass(listOfCards);
        NewHand newHand1 = new NewHandClass(listOfCards);

        List<NewHand> listOfHands = new ArrayList<>();
        listOfHands.add(newHand);
        listOfHands.add(newHand1);

        Card dealerCard = new CardClassAdapter(RankEnum.SIX, SuitEnum.CLUBS);

        Player player = new Player("Player", listOfHands, dealerCard);
        List<NewHand> playerHands = player.getPlayerNewHands();
        int size = playerHands.size();
        assertEquals("There are two hands in the game.", size, 2);
    }

    /**
     * Test the method for play for players
     */
    @Test
    public void playForCurrentPlayer() {

        BlackJack blackJack = new BlackJack(3);
        blackJack.setNumberOfhands(2);
        blackJack.createDeck("Vegas", 1);
        blackJack.deal();
        List<Card> listOfCards = new ArrayList<>();

        Card card = new CardClassAdapter(RankEnum.EIGHT, SuitEnum.DIAMONDS);
        listOfCards.add(card);
        listOfCards.add(card);
        listOfCards.add(card);

        NewHand newHand = new NewHandClass(listOfCards);
        NewHand newHand1 = new NewHandClass(listOfCards);

        List<NewHand> listOfHands = new ArrayList<>();
        listOfHands.add(newHand);
        listOfHands.add(newHand1);

        Card dealerCard = new CardClassAdapter(RankEnum.SIX, SuitEnum.CLUBS);

        Player player = new Player("Player", listOfHands, dealerCard);
        int credits = player.getCredits();

        assertEquals("The players must have 5 credits.",5, credits);

    }

    /**
     * Tests the HIT action of the game based on the strategy table
     */
    @Test
    public void hitAction()
    {
        BlackJack blackJack = new BlackJack(2);
        blackJack.setNumberOfhands(2);
        blackJack.createDeck("Vegas", 2);
        blackJack.deal();
        List<Card> listOfCards = new ArrayList<>();

        Card card = new CardClassAdapter(RankEnum.THREE, SuitEnum.DIAMONDS);
        Card card1 = new CardClassAdapter(RankEnum.FIVE, SuitEnum.CLUBS);
        listOfCards.add(card);
        listOfCards.add(card1);

        NewHand newHand = new NewHandClass(listOfCards);

        List<NewHand> listOfHands = new ArrayList<>();
        listOfHands.add(newHand);

        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.CLUBS);
        Player player = new Player("Player", listOfHands, dealerCard);

        PlayerActionEnum actualAction = blackJack.hitAction(newHand, player);

        assertEquals(PlayerActionEnum.STAND, actualAction);
    }

    /**
     * Tests the SPLIT action of the strategy table
     */
    @Test
    public void splitAction()
    {
        BlackJack blackJack = new BlackJack(2);
        blackJack.setNumberOfhands(2);
        blackJack.createDeck("Vegas", 2);
        blackJack.deal();
        List<Card> listOfCards = new ArrayList<>();

        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        listOfCards.add(card);
        listOfCards.add(card);

        NewHand newHand = new NewHandClass(listOfCards);
        NewHand newHand1 = new NewHandClass(listOfCards);

        List<NewHand> listOfHands = new ArrayList<>();
        listOfHands.add(newHand);
        listOfHands.add(newHand1);

        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.CLUBS);
        Player player = new Player("Player", listOfHands, dealerCard);

        assertEquals(PlayerActionEnum.HIT, blackJack.splitAction( newHand, player));

    }

    /**
     * Tests the total value of a hand when a new card is added to it
     */
    @Test
    public void getTotalValue()
    {
        BlackJack blackJack = new BlackJack(2);
        blackJack.setNumberOfhands(2);
        blackJack.createDeck("Vegas", 2);
        blackJack.deal();

        Card card = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card cardAce = new CardClassAdapter(RankEnum.ONE, SuitEnum.DIAMONDS);

        assertEquals(9, blackJack.getTotalValue(0, card));
        assertEquals(11, blackJack.getTotalValue(0, cardAce));
    }


}