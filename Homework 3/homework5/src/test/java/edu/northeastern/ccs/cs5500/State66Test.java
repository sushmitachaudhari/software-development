package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State66;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State66Test {
    /**
     * Test for State 66 - pair totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.HIT;
        PlayerActionEnum actionEnum2 = PlayerActionEnum.SPLIT;

        State66 instance = State66.getInstance();
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum2, instance.getAction(dealerCard1));


    }
}