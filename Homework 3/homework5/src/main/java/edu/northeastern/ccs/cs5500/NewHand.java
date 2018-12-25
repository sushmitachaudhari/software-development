package edu.northeastern.ccs.cs5500;

/**
 * @author Sushmita Chaudhari
 */
public interface NewHand extends Hand {

    /* homework 3 */

    Boolean hasCard(Card cardToFind);
    int occurrencesInHand(Card cardToFind); // New!
    int occurrencesInHand(Rank rankToFind); // New!
}
