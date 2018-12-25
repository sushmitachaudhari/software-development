package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State16151413;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State16151413Test {
    /**
     * Test for State 16,15,14,13 - soft totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.HIT;
        PlayerActionEnum actionEnum2 = PlayerActionEnum.STAND;


        State16151413 instance = State16151413.getInstance();
        assertEquals("HIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum2, instance.getAction(dealerCard1));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard2));
    }
}