package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing state A9-A8 in soft totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class StateA9A8 implements State{

    private static StateA9A8 instance;

    public static StateA9A8 getInstance()
    {
        if(instance == null)
        {
            instance = new StateA9A8();
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
        return PlayerActionEnum.STAND;

    }
}


