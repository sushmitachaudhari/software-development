package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.StateAA;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author Sushmita Chaudhari
 */
public class StateAATest {

    /**
     * Test for State AA - pair total
     */

    @Test
    public void getAction() {
        Card dealerCard = new CardClassAdapter(RankEnum.SEVEN, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.SIX, SuitEnum.DIAMONDS);
        Card dealerCard2 = new CardClassAdapter(RankEnum.ONE, SuitEnum.CLUBS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.SPLIT;

        StateAA instance = StateAA.getInstance();
        assertEquals("SPLIT", actionEnum1, instance.getAction(dealerCard));
        assertEquals("SPLIT", actionEnum1, instance.getAction(dealerCard1));
        assertEquals("SPLIT", actionEnum1, instance.getAction(dealerCard2));

    }
}