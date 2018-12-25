package edu.northeastern.ccs.cs5500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Sushmita Chaudhari
 */
public class NewHandClass implements NewHand {


    private List<Card> hand;
    private int numberOfCardsPlayed;

    /**
     * Hand class constructor
     * @param cards a list of cards to create a Hand
     */
    NewHandClass(List<Card> cards)
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
     * Sort the hand by suit, rank or both
     * @param bySuitRankBoth sorting condition - rank, suit or both
     */
    @Override
    public void sort(String bySuitRankBoth){
        if(bySuitRankBoth.equalsIgnoreCase("Suit"))
        {
            hand.sort(CardClass.suitComparator);

        }
        else if(bySuitRankBoth.equalsIgnoreCase("Rank"))
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
     * Checks if the Hand has a card
     * @param card card to be checked for in Hand
     * @return true if card is in Hand else false
     */
    @Override
    public Boolean hasCard(Card card){

        HandIterator itr = getIterator();
        while(itr.hasNext())
        {
            Card card1 = itr.next();
            if(card1.equals(card))
            {
                return true;
            }
        }
        return false;
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


    /**
     *
     * @param cardToFind card
     * @return number of occurences of card
     */
    public int occurrencesInHand(Card cardToFind)
    {
        HandIterator iterator = getIterator();
        int noOfOccurrences = 0;
        while(iterator.hasNext())
        {
            Card card = iterator.next();
            if(card.equals(cardToFind))
            {
                noOfOccurrences += 1;
            }
        }
        return noOfOccurrences;
    }

    /**
     *
     * @param rankToFind rank of a card
     * @return number of occurences of card
     */
    public int occurencesInHand(Rank rankToFind)
    {
        HandIterator iterator = getIterator();
        int noOfOccurrences = 0;
        while(iterator.hasNext())
        {
            Card card = iterator.next();
            if(card.getRank().equals(rankToFind)){
                noOfOccurrences += 1;
            }
        }
        return noOfOccurrences;
    }

    /**
     *
     * @return a new iterator
     */
     HandIterator getIterator()
    {
        return new HandIterator();
    }


    /**
     * Iterator for Hand class
     */
     class HandIterator<E>
    {
       private int current;
       private final int end;

       /* constructor */
       HandIterator()
       {
           this.current = 0;
           this.end = hand.size() - 1;
       }

        /**
         *
         * @return true if current location is less than the size of the hand
         */
        boolean hasNext() {
            return this.current < end;
        }

        /**
         *
         * @return next Card in the hand
         */
        Card next()
        {
            if(!this.hasNext())
            {
                throw new NoSuchElementException();
            }

            Card nextCard = hand.get(current);
            current++;
            return nextCard;
        }

    }



}
