package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State111098765;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State111098765Test {
    /**
     * Test for State 11,10,9,8,7,6,5 - hard totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.HIT;


        State111098765 instance = State111098765.getInstance().getInstance();
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard1));
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard2));

    }
}