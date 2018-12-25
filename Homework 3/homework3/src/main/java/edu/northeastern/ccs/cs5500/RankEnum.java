package edu.northeastern.ccs.cs5500;

/**
 * Rank enum to represent all the ranks of a card
 *
 * @author Sushmita Chaudhari
 */
public enum RankEnum implements Rank{

    ONE("ACES", 1, 'A'), TWO("TWO", 2, '2'), THREE("THREE", 3, '3'),
    FOUR("FOUR", 4, '4'), FIVE("FIVE", 5, '5'), SIX("SIX", 6, '6'),
    SEVEN("SEVEN", 7, '7'), EIGHT("EIGHT", 8, '8'), NINE("NINE", 9, '9'),
    TEN("TEN", 10, 'T'), JACK("JACK", 0, 'J'), QUEEN("QUEEN", 0, 'Q'),
    KING("KING", 0, 'K');

    private String name;
    private int pips;
    private char shortName;

    /**
     * Constructing Rank of a class
     * @param name name of the rank of card
     * @param pips pips of the card
     */
    RankEnum(String name, int pips, char shortName)
    {
        this.name = name;
        this.pips = pips;
        this.shortName = shortName;
    }

    /**
     *
     * @return Name of the card
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return Pips of a card
     */
    @Override
    public int getPips()
    {
        return pips;
    }

}
