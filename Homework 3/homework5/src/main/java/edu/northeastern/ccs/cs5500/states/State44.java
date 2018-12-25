package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *A class representing State44 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State44 implements State{
    private static State44 instance;

    public static State44 getInstance()
    {
        if(instance == null)
        {
            instance = new State44();
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