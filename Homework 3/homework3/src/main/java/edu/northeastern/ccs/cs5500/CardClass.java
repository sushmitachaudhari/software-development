package edu.northeastern.ccs.cs5500;

import java.util.Comparator;

/**
 * A class to implement Card interface
 *
 * @author Sushmita Chaudhari
 */
public class CardClass implements Card {

   private Rank rank;
   private Suit suit;

    /**
     *
     * @param rank Rank of a Card
     * @param suit Suit of a Card
     */
   CardClass(Rank rank, Suit suit)
   {
       setRank(rank);
       setSuit(suit);
   }

    /**
     *
     * @param rank Rank of a card
     */
   private void setRank(Rank rank)
   {
       this.rank = rank;
   }

    /**
     *
     * @param suit Suit of a card
     */
   private void setSuit(Suit suit)
   {
       this.suit = suit;
   }

    /**
     *
     * @return rank of a card
     */
   @Override
   public Rank getRank()
   {
       return rank;
   }

    /**
     *
     * @return suit of a card
     */
   @Override
   public Suit getSuit()
   {
       return suit;
   }

    /**
     * Comparator for suits of two cards
     */
    //suit comparator
    static final Comparator<Card> suitComparator = (card1, card2) ->
           card2.getSuit().getName().compareToIgnoreCase(card1.getSuit().getName());


    /**
     * Comparator for ranks of two cards
     */
    //rank comparator
    static final Comparator<Card> rankComparator = (card1, card2)  ->{

            //face cards
           if((card1.getRank().getPips() == 0 && (card2.getRank().getPips() == 0)))
           {
               //call face comparator
               return faceComparator(card1, card2);
           }
                //non face cards
           else if(card1.getRank().getPips() > 0 && card2.getRank().getPips() > 0)
           {
               //call non face comaprators
               return nonFaceComparator(card1, card2);

           }
           else if((card1.getRank().getPips() == 0) && (card2.getRank().getPips() > 0))
           {
                return Integer.compare(CardClass.priorityOfCard
                        (card1.getRank().getName()),card2.getRank().getPips());
           }
           else
           {
               return -1;
           }

   };

    //helper functions for Rank comaprator

    /**
     *
     * @param card1 card one
     * @param card2 card two
     * @return return the compared integer
     */
    private static int faceComparator(Card card1, Card card2)
    {
        return Integer.compare(CardClass.priorityOfCard(card1.getRank().getName()),
                CardClass.priorityOfCard(card2.getRank().getName()));

    }

    /**
     *
     * @param card1 card 1
     * @param card2 card 2
     * @return the compared integer value
     */
    private static int nonFaceComparator(Card card1, Card card2)
    {
        return Integer.compare(card1.getRank().getPips(), card2.getRank().getPips());
    }

    /**
     *
     * @param c rank name of a card
     * @return priority for a face card
     */
    private static int priorityOfCard(String c)
    {
        if(c.equals("JACK"))
        {
            return 11;
        }
        else if(c.equals("QUEEN"))
        {
            return 12;
        }
        else
        {
            return 13;
        }
    }

    //both comparator

    /**
     * Comparator for both rank and suit of two cards
     *
     * Each card is compared for suit and rank
     */
    static final Comparator<Card> bothComparator = (card1, card2) ->{

            if(card1.getRank().equals(card2.getRank()))
            {
                return suitComparator.compare(card1, card2);
            }
            else
            {
                //call rank compararor
                return rankComparator.compare(card1, card2);
            }
        };



    @Override
    public String toString()
    {
        return String.format("Rank: %8s Suit: %8s", rank.getName(), suit.getSymbol());
    }

}
