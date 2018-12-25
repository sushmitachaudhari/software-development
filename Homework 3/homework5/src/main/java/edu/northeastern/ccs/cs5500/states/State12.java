package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * @author Sushmita Chaudhari
 *
 * A class representing State12 - hard totals in the strategy table
 */
public class State12 implements State {
    private static State12 instance;

    public static State12 getInstance()
    {
        if(instance == null)
        {
            instance = new State12();
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
        if(dealerCard.getRank().getPips() > 3 && dealerCard.getRank().getPips() < 7)
            return PlayerActionEnum.STAND;
        else
            return PlayerActionEnum.HIT;

    }
}
