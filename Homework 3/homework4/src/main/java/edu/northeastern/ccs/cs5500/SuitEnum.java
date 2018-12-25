package edu.northeastern.ccs.cs5500;

/**
 * Rank enum to represent all the ranks of a card
 *
 * @author Sushmita Chaudhari
 */
public enum SuitEnum implements Suit {

    HEARTS("HEARTS",'\u2665'),
    SPADES("SPADES",'\u2660'),
    DIAMONDS("DIAMONDS",'\u2666'),
    CLUBS("CLUBS",'\u2663');

    private String name;
    private char symbol;

    /**
     *
     * @param name Name of the suit of the card
     * @param symbol symbol of the suit
     */
    SuitEnum(String name, char symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     *
     * @return name of the suit of a card
     */
    @Override
    public String getName()
    {
       return name;
    }

    /**
     *
     * @return symbol of a suit of a card
     */
    @Override
    public char getSymbol()
    {
       return symbol;
    }

}
