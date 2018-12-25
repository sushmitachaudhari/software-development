package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *  A class representing state A7 in soft totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class StateA7 implements State{
    private static StateA7 instance;

    public static StateA7 getInstance()
    {
        if(instance == null)
        {
            instance = new StateA7();
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
        if(dealerCard.getRank().getPips() == 7 || dealerCard.getRank().getPips() == 8)
            return PlayerActionEnum.STAND;
        else
            return PlayerActionEnum.HIT;

    }
}
