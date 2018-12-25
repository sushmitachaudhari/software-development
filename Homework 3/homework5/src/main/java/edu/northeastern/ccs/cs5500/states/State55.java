package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *A class representing State55 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State55 implements State{
    private static State55 instance;

    public static State55 getInstance()
    {
        if(instance == null)
        {
            instance = new State55();
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