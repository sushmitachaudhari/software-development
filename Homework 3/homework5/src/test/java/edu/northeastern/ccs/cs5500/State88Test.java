package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State88;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State88Test {
    /**
     * Test for State 88 - pair totals
     */
    @Test
    public void getAction() {

        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum2 = PlayerActionEnum.SPLIT;

        State88 instance = State88.getInstance();
        assertEquals("SPLIT", actionEnum2, instance.getAction(dealerCard));
        assertEquals("SPLIT", actionEnum2, instance.getAction(dealerCard1));

    }
}