package problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class implemets Hand interface
 *
 * Represents a player with cards dealt to them
 *
 * @author Sushmita Chaudhari
 */
public class HandClass implements Hand{

    private List<Card> hand;
    private int numberOfCardsPlayed;

    /**
     * Hand class constructor
     * @param cards a list of cards to create a Hand
     */
    HandClass(List<Card> cards)
    {
        this.hand = new ArrayList<>();
        this.hand.addAll(cards);
        numberOfCardsPlayed = 0;
    }

    /**
     * Shows the cards of a Hand
     * @return A list of cards in Hand
     */
    @Override
    public List<Card> showCards(){
        return hand;

    }

    /**
     * Hand accepts a card
     * @param listOfCards a list of cards given to a Hand
     */

    public void accept(List<Card> listOfCards){

        hand.addAll(listOfCards);
    }

    /**
     * Hand accepts a card
     * @param card a card given to a Hand
     */
    @Override
    public void accept(Card card){
        hand.add(card);
    }

    /**
     * A method to pull card
     * @return A card that was pulled
     */
    @Override
    public Card pullCard(){
        if(numberOfCardsPlayed == hand.size())
        {
            throw new IllegalStateException("No cards left");
        }
        numberOfCardsPlayed++;
        Card pulledcard = hand.get(numberOfCardsPlayed - 1);
        hand.remove(hand.get(numberOfCardsPlayed - 1));
        return pulledcard;
    }

    /**
     * Checks if the Hand has a card
     * @param card card to be checked for in Hand
     * @return true if card is in Hand else false
     */
    @Override
    public Boolean hasCard(Card card){
        return hand.contains(card);
    }

    /**
     * Sort the hand by suit, rank or both
     * @param bySuitRankBoth sorting condition - rank, suit or both
     */
    @Override
    public void sort(String bySuitRankBoth){
        if(bySuitRankBoth.equals("sortBySuit"))
        {
            hand.sort(CardClass.suitComparator);
        }
        else if(bySuitRankBoth.equals("sortByRank"))
        {
            hand.sort(CardClass.rankComparator);
        }
        else
        {
            hand.sort(CardClass.bothComparator);
        }
    }

    /**
     * shuffle the Hand
     */
    @Override
    public void shuffle()
    {
        Collections.shuffle(hand);
    }


    /**
     * Check if the Hand has a suit
     *
     * @param suit the type of suit
     * @return true if suit exists in hand
     */
    @Override
    public Boolean hasSuit(Suit suit)
    {
        String suitName = suit.getName();
        Boolean hasSuit = false;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getSuit().getName().equals(suitName))
            {
              hasSuit = true;
              break;
            }
            else
            {
                hasSuit = false;
            }

        }
        return hasSuit;

    }

    /**
     * Check if Hand has a Rank
     *
     * @param rank rank of a Card
     * @return true if a card in hand has that rank
     */
    @Override
    public Boolean hasRank(Rank rank)
    {

        String rankName = rank.getName();
        Boolean hasRank = false;
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).getRank().getName().equals(rankName))
            {
                hasRank = true;
                break;
            }
            else
            {
                hasRank = false;

            }

        }
        return hasRank;
    }

    /**
     *
     * @return Size of the hand
     */
     int getLenHand()
    {
        return hand.size();
    }

    /**
     *
     * @param pos position of the card in deck
     * @return card at the given position
     */
    Card getCardFromDeck(int pos)
    {
        return hand.get(pos - 1);
    }
}
