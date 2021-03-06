package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *A class representing State77 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State77 implements State{
    private static State77 instance;

    public static State77 getInstance()
    {
        if(instance == null)
        {
            instance = new State77();
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
        if(dealerCard.getRank().getPips() > 1 && dealerCard.getRank().getPips() < 7)
            return PlayerActionEnum.SPLIT;
        else
            return PlayerActionEnum.HIT;
    }

}
