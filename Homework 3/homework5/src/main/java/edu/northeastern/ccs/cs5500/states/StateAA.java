package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing state A9 in soft totals in the strategy table
 * @author Sushmita Chaudhari
 */
public class StateAA implements State {
    private static StateAA instance;

    public static StateAA getInstance()
    {
        if(instance == null)
        {
            instance = new StateAA();
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
        return PlayerActionEnum.SPLIT;

    }
}
