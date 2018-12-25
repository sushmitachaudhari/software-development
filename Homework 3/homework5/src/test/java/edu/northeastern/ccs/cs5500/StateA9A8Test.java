package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.StateA9A8;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class StateA9A8Test {
    /**
     * Test for State A9A8 - soft totals
     */

    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum2 = PlayerActionEnum.STAND;


        StateA9A8 instance = StateA9A8.getInstance();
        assertEquals("STAND", actionEnum2, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum2, instance.getAction(dealerCard1));
        assertEquals("STAND", actionEnum2, instance.getAction(dealerCard2));

    }
}