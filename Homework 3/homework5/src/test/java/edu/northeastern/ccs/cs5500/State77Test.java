package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State77;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State77Test {
    /**
     * Test for State 77 - pair totals
     */
    @Test
    public void getAction() {

        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.HIT;
        PlayerActionEnum actionEnum2 = PlayerActionEnum.SPLIT;

        State77 instance = State77.getInstance();
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("SPLIT", actionEnum2, instance.getAction(dealerCard1));


    }
}