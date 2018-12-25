package edu.northeastern.ccs.cs5500;

/**
 * @author Sushmita Chaudhari
 */

/**
 * Represents actions a player takes while playing BlackJack
 *
 * HIT: A new card form deck is added to the hand
 * STAND: Let other players play, if others have played, dealer will play
 * SPLIT: split the hand to two
 */
public enum PlayerActionEnum {
    HIT,
    STAND,
    SPLIT
}
