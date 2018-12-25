package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * A class representing State1010 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State1010 implements State {
    private static State1010 instance;

    public static State1010 getInstance()
    {
        if(instance == null)
        {
            instance = new State1010();
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
