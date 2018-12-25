package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing state 22-33 in pair totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State2233 implements State {

    private static State2233 instance;

    public static State2233 getInstance()
    {
        if(instance == null)
        {
            instance = new State2233();
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

        return PlayerActionEnum.STAND;

    }
}
