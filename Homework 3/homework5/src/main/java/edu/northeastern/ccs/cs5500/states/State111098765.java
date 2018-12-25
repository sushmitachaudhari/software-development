package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing state 11 - 5 in hard totals in the strategy table
 * @author Sushmita Chaudhari
 */
public class State111098765 implements State{
    private static State111098765 instance;

    public static State111098765 getInstance()
    {
        if(instance == null)
        {
            instance = new State111098765();
        }

        return instance;
    }

    /**
     * Takes action depending on dealer's card
     *
     * @param dealerCard Dealer's face up card
     * @return action of PlayerActionEnum type
     */
    @Override
    public PlayerActionEnum getAction(Card dealerCard){

        // Take decision based on Dealer Card
        return PlayerActionEnum.HIT;

    }
}
