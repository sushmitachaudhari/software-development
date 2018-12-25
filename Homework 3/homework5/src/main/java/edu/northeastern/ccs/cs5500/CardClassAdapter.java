package edu.northeastern.ccs.cs5500;

import cs5500.src.main.java.diErBao.KaComparator;
import cs5500.src.main.java.diErBao.kaShiXia;

import java.util.Comparator;

/**
 * @author Sushmita Chaudhari
 */
public class CardClassAdapter implements Card {


    private kaShiXia adaptee;
    private static KaComparator comparatorAdaptee;

    /**
     *
     * @param rank Rank of a Card
     * @param suit Suit of a Card
     */
    public CardClassAdapter(Rank rank, Suit suit)
    {
        if(rank != null && suit != null)
        {
            String rankName = rank.getName();
            kaShiXia.KaDengJíEnum rankEn = kaShiXia.KaDengJíEnum.valueOf(rankName);
            adaptee = new kaShiXia(rankEn, valueOfSuit(suit));
        }

        comparatorAdaptee = new KaComparator();
    }

    /**
     *
     * @return value of card's suit
     */
    private int valueOfSuit(Suit suit)
    {
        switch (suit.getName()) {
            case "HEARTS":
                return 0;
            case "SPADES":
                return 1;
            case "DIAMONDS":
                return 2;
            default:
                return 3;
        }
    }

    /**
     *
     * @return rank of a card
     */
    @Override
    public Rank getRank()
    {
        int rankVal = adaptee.getRank();
        kaShiXia.KaDengJíEnum rank = kaShiXia.KaDengJíEnum.lookupEnumName(rankVal);
        return RankEnum.values()[rank.ordinal()];
    }

    /**
     *
     * @return suit of a card
     */
    @Override
    public Suit getSuit()
    {
        int val =  adaptee.getSuit();
        kaShiXia.KaPianTaoZhuangEnum suit = kaShiXia.KaPianTaoZhuangEnum.getKaPianTaoZhuang(val);
        return  SuitEnum.values()[suit.ordinal()];
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
    static final Comparator<Card> rankComparator = (card1, card2)  ->
            comparatorAdaptee.compare( ((CardClassAdapter) card1).getAdaptee(),
                    ((CardClassAdapter) card2).getAdaptee());


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

    /**
     *
     * @return Kashixia - Card of Ka type
     */
    kaShiXia getAdaptee() {
        return adaptee;
    }

    @Override
    public String toString()
    {
        return String.format("Rank: %8s Suit: %8s", adaptee.getRank(), adaptee.getRank());
    }

    @Override
    public boolean equals(Object obj) {

        Card c = (Card) obj;
        return this.getSuit() == c.getSuit() && this.getRank() == c.getRank();
    }

}
