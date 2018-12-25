package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *A class representing State66 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State66 implements State {
    private static State66 instance;

    public static State66 getInstance()
    {
        if(instance == null)
        {
            instance = new State66();
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

        if(dealerCard.getRank().getPips() < 7 && dealerCard.getRank().getPips() > 1)
            return PlayerActionEnum.SPLIT;
        else
            return PlayerActionEnum.HIT;

    }
}