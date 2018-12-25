package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State55;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State55Test {
    /**
     * Test for State 55 - pair totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;
        State55 instance = State55.getInstance();
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard));

    }
}