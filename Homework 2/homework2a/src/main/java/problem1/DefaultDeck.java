package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sushmita Chaudhari
 */
public class DefaultDeck implements Deck{

    List<Card> specialDeck;

    private int numberOfCardsDealt;
    private int officialSize;


    /**
     * Setting the number of cards dealt till now
     * @param numberOfCardsDealt1 initial number of cards dealt is zero
     */
    void setNumberOfCardsDealt(int numberOfCardsDealt1)
    {
        this.numberOfCardsDealt = numberOfCardsDealt1;
    }

    /**
     * setting the official size of the deck
     * @param officialSize1 the official size of the deck
     */
    void setOfficialSize(int officialSize1)
    {
        this.officialSize = officialSize1;
    }

    /**
     * Method to shuffle the Euchre deck
     */
    @Override
    public void shuffle()
    {
        Collections.shuffle(specialDeck);
    }


    /**
     * Sorts the deck according to the user
     * @param guidance sorting condition - rank, suit or both
     */
    @Override
    public void sort(String guidance){

        if(guidance.equalsIgnoreCase("Suit"))
        {
            specialDeck.sort(CardClass.suitComparator);
            for(int i = 0; i< specialDeck.size(); i++)
            {
                System.out.println("standarddeck sort by suit "+specialDeck.get(i));
            }

        }
        else if(guidance.equalsIgnoreCase("Rank"))
        {
            specialDeck.sort(CardClass.rankComparator);

            for(int i = 0; i< specialDeck.size(); i++)
            {
                System.out.println("standarddeck sort by rank "+specialDeck.get(i));
            }

        }
        else
        {
            specialDeck.sort(CardClass.bothComparator);

            for(int i = 0; i< specialDeck.size(); i++)
            {
                System.out.println("standarddeck sort by both "+specialDeck.get(i));
            }
        }

    }

    /**
     * A method to cut the deck
     * @param cutpoint the point/index in the deck where the deck is cut
     */
    @Override
    public void cut(int cutpoint)
    {
        List<Card> cutCards = new ArrayList<>();

        for(int i = 0; i < cutpoint - 1; i++)
        {
            cutCards.add(specialDeck.get(i));
        }

        for(int i = 0; i < cutCards.size(); i++)
        {
            System.out.println("cut cards: "+ cutCards.get(i));
        }

        for(int i = 0; i < cutpoint - 1; i++)
        {
            specialDeck.remove(0);
        }

        //add the elements to the list:
        specialDeck.addAll(cutCards);
    }

    /**
     * A method to pull the card from the deck and return it.
     * The deck no longer has the pulled card.
     * @return pulled card from deck
     * @throws IllegalStateException if the deck is empty
     */
    @Override
    public Card pullCard()
    {
        if(numberOfCardsDealt == specialDeck.size() && specialDeck.isEmpty())
        {
            throw new IllegalStateException("No cards left");
        }
        numberOfCardsDealt++;
        Card pulledcard = specialDeck.get(numberOfCardsDealt - 1);
        System.out.println("pulled card: "+pulledcard.getSuit() +" "+pulledcard.getRank());
        System.out.println("first card after pulling card: "+specialDeck.get(0));
        specialDeck.remove( specialDeck.get(numberOfCardsDealt - 1));
        return pulledcard;
    }

    /**
     * Check if the deck is empty or not
     * @return boolean for if deck is empty or not
     */
    @Override
    public Boolean emptyDeck()
    {
        return (specialDeck.isEmpty());
    }

    /**
     * A method to check the size of the deck
     *
     * @return official size of the deck
     */
    @Override
    public int officialSize()
    {
        return officialSize;
    }

    /**
     * A method to check id deck contains a card
     * @param c a Card
     * @return true if the given card is present in the deck
     */
    boolean hasCard(Card c)
    {
        return specialDeck.contains(c);
    }

    /**
     *A method to return the size of the deck
     *
     * @return size of the deck
     */
    public int getSize()
    {
        return specialDeck.size();
    }

    /**
     *
     * @param pos position of the card
     * @return Card at the given position
     */
    Card getCardFromDeck(int pos)
    {
        return specialDeck.get(pos - 1);
    }

}
