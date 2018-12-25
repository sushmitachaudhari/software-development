package edu.northeastern.ccs.cs5500;

import cs5500.src.main.java.diErBao.Ka;
import cs5500.src.main.java.diErBao.ShouShiXia;
import cs5500.src.main.java.diErBao.kaShiXia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Sushmita Chaudhari
 */
public class NewHandClass extends ShouShiXia implements NewHand {

    private int numberOfCardsPlayed;

    /**
     * Hand class constructor
     *
     * @param cards a list of cards to create a Hand
     */
    NewHandClass(List<Card> cards) {
        super();

            for (Card c : cards) {
                accept(c);
            }
            numberOfCardsPlayed = 0;

    }

    /**
     * Shows the cards of a Hand
     *
     * @return A list of cards in Hand
     */
    @Override
    public List<Card> showCards() {
        List<Ka> kas = showHand();

        List<Card> cards = new ArrayList<>();
        for (Ka ka : kas) {
            cards.add(convertKaToCard(ka));
        }
        return cards;
    }

    /**
     * Hand accepts a card
     *
     * @param card a card given to a Hand
     */
    @Override
    public void accept(Card card) {
        CardClassAdapter c1 = (CardClassAdapter) card;
        accept(c1.getAdaptee());
    }

    /**
     * A method to pull card
     *
     * @return A card that was pulled
     */
    @Override
    public Card pullCard() {
        if(numberOfCardsPlayed == showCards().size())
        {
            throw new IllegalStateException("No cards left");
        }
        numberOfCardsPlayed++;

        return convertKaToCard(pullKa());
    }

    /**
     * Sort the hand by suit, rank or both
     *
     * @param bySuitRankBoth sorting condition - rank, suit or both
     */
    @Override
    public void sort(String bySuitRankBoth) {
        if (bySuitRankBoth.equalsIgnoreCase("Suit")) {
            showCards().sort(CardClassAdapter.suitComparator);

        } else if (bySuitRankBoth.equalsIgnoreCase("Rank")) {
            showCards().sort(CardClassAdapter.rankComparator);

        } else {
            showCards().sort(CardClassAdapter.bothComparator);
        }
    }

    /**
     * shuffle the Hand
     */
    @Override
    public void shuffle() {
        Collections.shuffle(showHand());
    }

    /**
     * Check if the Hand has a suit
     *
     * @param suit the type of suit
     *
     * @return true if suit exists in hand
     */
    @Override
    public Boolean hasSuit(Suit suit) {
        String suitName = suit.getName();
        Boolean hasSuit = false;
        List<Ka> hand = showHand();
        for (int i = 0; i < hand.size(); i++) {
            if (convertKaToCard(hand.get(i)).getSuit().getName().equals(suitName)) {
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
     *
     * @return true if a card in hand has that rank
     */
    @Override
    public Boolean hasRank(Rank rank) {

        String rankName = rank.getName();
        Boolean hasRank = false;
        List<Ka> hand = showHand();
        for (int i = 0; i < hand.size(); i++) {
            if (convertKaToCard(hand.get(i)).getRank().getName().equals(rankName)) {
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
     *
     * @param card card to be checked for in Hand
     *
     * @return true if card is in Hand else false
     */
    @Override
    public Boolean hasCard(Card card) {
        return hasKa(((CardClassAdapter) card).getAdaptee());
    }

    /**
     * @return Size of the hand
     */
    int getLenHand() {
        return showHand().size();
    }

    /**
     * @param pos position of the card in deck
     *
     * @return card at the given position
     */
    Card getCardFromDeck(int pos) {
        return convertKaToCard(showHand().get(pos - 1));
    }


    /**
     * @param ka Ka type of Card
     *
     * @return Card
     */
    private Card convertKaToCard(Ka ka) {
        kaShiXia.KaDengJíEnum kaRank = kaShiXia.KaDengJíEnum.lookupEnumName(ka.getRank());
        int kaSuit = ka.getSuit();
        return new CardClassAdapter(RankEnum.values()[kaRank.ordinal()], SuitEnum.values()[kaSuit]);
    }

    /**
     *
     * @param cardToFind a Card to find in Hand
     * @return number of occurrences of card in the Hand
     */
    @Override
    public int occurrencesInHand(Card cardToFind) {
        HandIterator iterator = getIterator();
        int noOfOccurrences = 0;
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getRank().equals(cardToFind.getRank()) && card.getSuit().equals(cardToFind.getSuit())) {
                noOfOccurrences += 1;
            }
        }
        return noOfOccurrences;
    }

    /**
     *
     * @param rankToFind Rank to occur in a hand
     * @return number of occurrences of Rank in hand
     */
    @Override
    public int occurrencesInHand(Rank rankToFind) {
        HandIterator iterator = getIterator();
        int noOfOccurrences = 0;
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (card.getRank().equals(rankToFind)) {
                noOfOccurrences += 1;
            }
        }
        return noOfOccurrences;
    }

    /**
     *
     * @return HandIterator
     */
    HandIterator getIterator() {
        return new HandIterator();
    }

    /**
     * A class for iterator for Hand
     * @param <E> Generic type
     */
    class HandIterator<E> {
        private int current;
        private final int end;

        //* constructor *//
        HandIterator() {
            this.current = 0;
            this.end = showCards().size() - 1;
        }

        /**
         *
         * @return boolean value if next card exists
         */
        boolean hasNext() {
            return this.current < end;
        }

        /**
         *
         * @return a card
         */
        Card next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Card nextCard = showCards().get(current);
            current++;
            return nextCard;
        }

        /**
         *
         * @param pos position of the card in deck
         * @return card at the given position
         */
        Card getCardFromDeck(int pos)
        {
            return showCards().get(pos - 1);
        }

    }
}


















