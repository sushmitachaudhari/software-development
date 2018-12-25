package edu.northeastern.ccs.cs5500.states;

/**
 * @author Sushmita Chaudhari
 */

import edu.northeastern.ccs.cs5500.Card;
import edu.northeastern.ccs.cs5500.PlayerActionEnum;

/**
 * Represents a state of a hand in BJ game
 */
public interface State {

    PlayerActionEnum getAction(Card dealerCard);
}
