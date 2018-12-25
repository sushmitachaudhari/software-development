package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State44;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State44Test {
    /**
     * Test for State 44 - pair totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;
        State44 instance = State44.getInstance();
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard));

    }
}