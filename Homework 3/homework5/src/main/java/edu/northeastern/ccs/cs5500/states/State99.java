package edu.northeastern.ccs.cs5500.states;

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 *A class representing State66 - pairs totals in the strategy table
 *
 * @author Sushmita Chaudhari
 */
public class State99  implements State {
    private static State99 instance;

    public static State99 getInstance()
    {
        if(instance == null)
        {
            instance = new State99();
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
        if(dealerCard.getRank().getPips() == 7
                || dealerCard.getRank().getPips() == 10
                || dealerCard.getRank().getPips() == 1)
            return PlayerActionEnum.STAND;
        else
            return PlayerActionEnum.SPLIT;


    }

}
