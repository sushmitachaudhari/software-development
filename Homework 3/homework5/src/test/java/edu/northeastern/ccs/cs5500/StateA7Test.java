package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.StateA7;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class StateA7Test {
    /**
     * Test for State A7 - soft totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.HIT;
        PlayerActionEnum actionEnum2 = PlayerActionEnum.STAND;

        StateA7 instance = StateA7.getInstance();
        assertEquals("HIT", actionEnum2, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard1));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard2));

    }
}