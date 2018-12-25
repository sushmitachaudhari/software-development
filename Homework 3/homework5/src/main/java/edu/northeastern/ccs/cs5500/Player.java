package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.*;

import java.util.List;

/**
 * A class representing a player in BJ game.
 * A player has initial money of 5 to play the game.
 * A player has a name, list of hands in the game, and a face up card of the Dealer.
 *
 * @author Sushmita Chaudhari
 */
public class Player {

    /**
     * Initial credits for each player
     */
    private static final int INITIAL_MONEY = 5;

    /**
     * Name of the Player
     */
    private String name;

    /**
     * Player's NewHand
     */
    private List<NewHand> playerNewHands;

    /**
     * Dealer card
     */
    Card dealerCard;

    /**
     * Money each player has
     */
    private int credits;

    /**
     *
     * @param name name of the player
     * @param newHands list of hands in the game
     * @param dealerCard Face up dealer card
     */
    Player(String name, List<NewHand> newHands, Card dealerCard) {
        this.name = name;
        this.playerNewHands = newHands;
        this.dealerCard = dealerCard;
        setCredits(INITIAL_MONEY);
    }

    /**
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Add a new hand to the list of hands in the game
     * @param newHand a hand
     */
    void addHand(NewHand newHand) {

        playerNewHands.add(newHand);
    }

    /**
     * Depending upon the hand and its total, a player can take a decision go to a State
     * States: HardTotal, SoftTotal and Pairs
     *
     * @param newHand hand of the player
     * @param total total of the hand
     * @return action of PlayerActionEnum type
     */
    public PlayerActionEnum decision(NewHand newHand, int total)
    {
        State instance;
        List<Card> cards = newHand.showCards();
        Card c1 = cards.get(0);
        Card c2 = cards.get(1);
        String c1Name = c1.getRank().getName();
        String c2Name = c2.getRank().getName();

        if(c1Name.equals(c2Name))
        {
            instance = pairNewHand(total);

        }
        else if(c1.getRank().getName().equals("ACE") || c2.getRank().getName().equals("ACE"))
        {
           instance = softNewHand(total);
        }
        else
        {
            instance = hardNewHand(total);
        }

        return takeAction(instance);
    }

    /**
     * Depending upon the state and the dealer's face up card, player takes the action
     * @param instance State that player is in
     * @return action of type PlayerActionEnum
     */
    private PlayerActionEnum takeAction(State instance) {

        return instance.getAction(dealerCard);
    }

    /**
     * State represents a state that a player's hand is in. The states are represented in the strategy diagram.
     * A player can be in state of hard totals, soft totals, or pairs.
     *
     * This method represents the states when a hand has hardtotals
     *
     * @param total total of the hand
     * @return State
     */
    State hardNewHand(int total)
    {
        State instance = null;

        switch(total){
            case 20:
            case 19:
            case 18:
            case 17:
                instance = State1720.getInstance();
                break;

            case 16:
            case 15:
            case 14:
            case 13:
                instance = State16151413.getInstance();
                break;
            case 12:
                instance = State12.getInstance();
                break;
            case 11:
            case 10:
            case 9:
            case 8:
            case 7:
            case 6:
            case 5:
                instance = State111098765.getInstance();
                break;
            default:
                break;

        }
        return instance;
    }

    /**
     * State represents a state that a player's hand is in. The states are represented in the strategy diagram.
     * A player can be in state of hard totals, soft totals, or pairs.
     *
     * This method represents the states when a hand has pairs
     *
     * @param total total of the hand
     * @return State
     */
    private State pairNewHand(int total)
    {
        State instance = null;
        switch (total){
            case 2:
                instance = StateAA.getInstance();
                break;
            case 20:
                instance = State1010.getInstance();
                break;
            case 18:
                instance = State99.getInstance();
                break;
            case 16:
                instance = State88.getInstance();
                break;
            case 14:
                instance = State77.getInstance();
                break;
            case 12:
                instance = State66.getInstance();
                break;
            case 10:
                instance = State55.getInstance();
                break;
            case 8:
                instance = State44.getInstance();
                break;
            case 6:
            case 4:
                instance = State2233.getInstance();
                break;
            default:
                break;

        }
        return instance;
    }

    /**
     * State represents a state that a player's hand is in. The states are represented in the strategy diagram.
     * A player can be in state of hard totals, soft totals, or pairs.
     *
     * This method represents the states when a hand has pairs
     *
     * @param total total of the hand
     * @return State
     */
    private State softNewHand(int total){
        State instance = null;
        switch (total){
            case 20:
                instance = StateA9A8.getInstance();
                break;
            case 19:
                instance = StateA9A8.getInstance();
                break;
            case 18:
                instance = StateA7.getInstance();
                break;
            case 17:
            case 16:
            case 15:
            case 14:
            case 13:
                instance = StateA6A5A4A3A2.getInstance();
                break;
            default:
                    break;
        }
        return instance;
    }

    /**
     *
     * @return list of hands in the game
     */
    List<NewHand> getPlayerNewHands() {
        return playerNewHands;
    }

    /**
     *
     * @return credits of a player
     */
    int getCredits() {
        return credits;
    }

    /**
     *
     * @param credits money a player has
     */
    void setCredits(int credits) {
        this.credits = credits;
    }
}
