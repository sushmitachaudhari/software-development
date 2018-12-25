package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.State12;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class State12Test {
    /**
     * Test for State 12 - hard totals
     */
    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.FIVE, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum = PlayerActionEnum.HIT;
        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;
        State12 instance = State12.getInstance();
        assertEquals("HIT", actionEnum, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard1));

    }
}