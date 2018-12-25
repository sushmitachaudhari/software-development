package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *  A class representing state 13-16 in hard totals in the strategy table
 *  *
 * @author Sushmita Chaudhari
 */
public class State16151413 implements State{

    private static State16151413 instance;

    public static State16151413 getInstance()
    {
        if(instance == null)
        {
            instance = new State16151413();
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

        if((dealerCard.getRank().getPips() > 1 ) && (dealerCard.getRank().getPips() < 7))
        {
            return PlayerActionEnum.STAND;
        }
        else
            return PlayerActionEnum.HIT;

    }
}

