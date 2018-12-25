package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *  A class representing state A6 - A2 in soft totals in the strategy table
 *
 *  @author Sushmita Chaudhari
 */
public class StateA6A5A4A3A2 implements State {
    private static StateA6A5A4A3A2 instance;

    public static StateA6A5A4A3A2 getInstance()
    {
        if(instance == null)
        {
            instance = new StateA6A5A4A3A2();
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