package edu.northeastern.ccs.cs5500;

import edu.northeastern.ccs.cs5500.states.StateA6A5A4A3A2;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sushmita Chaudhari
 */
public class StateA6A5A4A3A2Test {

    @Test
    public void getAction() {

        Card dealerCard = new CardClassAdapter(RankEnum.NINE, SuitEnum.DIAMONDS);
        Card dealerCard1 = new CardClassAdapter(RankEnum.FIVE, SuitEnum.DIAMONDS);

        PlayerActionEnum actionEnum1 = PlayerActionEnum.STAND;
        StateA6A5A4A3A2 instance = StateA6A5A4A3A2.getInstance();
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard));
        assertEquals("STAND", actionEnum1, instance.getAction(dealerCard1));

    }
}