package edu.northeastern.ccs.cs5500;

/**
 * @author Sushmita Chaudhari
 */

/**
 * A class representing a dealer in the BJ game
 */
public class Dealer {

    NewHand dealerHand;
    String name;

    /**
     * Money dealer has
     */
    private int credits;

    /**
     * Initial credits for each player
     */
    private static final int INITIAL_MONEY = 5;


    Dealer(String name, NewHand hand)
    {
         this.name = name;
         dealerHand = hand;
         setCreditsForDealer(INITIAL_MONEY);
    }

    /**
     *
     * @param credits money a dealer has
     */
    void setCreditsForDealer(int credits) {
        this.credits = credits;
    }

    /**
     *
     * @return credits of a dealer
     */
    int getCredits() {
        return credits;
    }


}
