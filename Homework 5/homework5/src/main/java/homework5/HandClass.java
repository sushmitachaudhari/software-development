package homework5;

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
public class HandClass implements Hand {

    private static final String SUIT = "Suit";
    private static final String RANK = "Rank";

    private List<Card> hand;
    private int numberOfCardsPlayed;
    private int numberOfCardsInHand;


    /**
     * Hand class constructor
     * @param cards a list of cards to create a Hand
     */
    HandClass(List<Card> cards, int numberOfCardsInHand)
    {
        this.hand = new ArrayList<>();
        this.hand.addAll(cards);
        this.numberOfCardsInHand = numberOfCardsInHand;
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
        if(hand.size() < numberOfCardsInHand)
            hand.add(card);
        else
            throw new IllegalStateException("can't accept more cards.");

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

        if(bySuitRankBoth.equalsIgnoreCase(SUIT))
        {
            hand.sort(CardClass.suitComparator);

        }
        else if(bySuitRankBoth.equalsIgnoreCase(RANK))
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
        for (Card aHand : hand) {
            if (aHand.getSuit().getName().equals(suitName)) {
                hasSuit = true;
                break;
            } else {
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
        for (Card aHand : hand) {
            if (aHand.getRank().getName().equals(rankName)) {
                hasRank = true;
                break;
            } else {
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
        return hand.contains(card);
    }




}
