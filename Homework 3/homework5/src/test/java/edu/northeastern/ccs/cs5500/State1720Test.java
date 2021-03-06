package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State1720;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State1720Test {
    /**
     * Test for State 17-20 - hard totals
     */
    @Test
    public void getAction() {

        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;

        State1720 instance = State1720.getInstance();
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard1));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard2));

    }
}