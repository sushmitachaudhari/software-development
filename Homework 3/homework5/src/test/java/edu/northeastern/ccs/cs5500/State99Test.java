package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State99;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State99Test {
    /**
     * Test for State 99 - pair totals
     */
    @Test
    public void getAction() {

        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;
        PlayerActionEnum actionEnum2 = PlayerActionEnum.SPLIT;

        State99 instance = State99.getInstance();
        assertEquals("SPLIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("SPLIT", actionEnum2, instance.getAction(dealerCard1));
        assertEquals("SPLIT", actionEnum1, instance.getAction(dealerCard2));

    }
}