package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing state 17-20 in hard totals in the strategy table
 * @author Sushmita Chaudhari
 */
public class State1720 implements State {

    private static State1720 instance;

    public static State1720 getInstance()
    {
        if(instance == null)
        {
            instance = new State1720();
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
