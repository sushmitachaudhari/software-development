package homework5;

import java.util.ArrayList;
import java.util.List;

/**
 * A Game class that implements Game interface
 *
 * @author Sushmita Chaudhari
 */
public class GameClass implements Game {

    private int numberOfHands;
    private int numberOfCardsInHand;
    private List<Hand> listOfHand;

    private Deck deck;

    /**
     * Game class constructor
     * @param numberOfCardsInHand number of cards each player should receive
     */
    //ASSUMPTION: Game is told what deck to use and how many cards each player should have - same as in a real life sit.
    GameClass(int numberOfCardsInHand)
    {
        this.numberOfCardsInHand = numberOfCardsInHand;
    }

    /**
     * Creating a deck
     * @param deckType string to represent a deck type
     * @throws IllegalStateException if wrong deck type is given
     */
    @Override
    public void createDeck(String deckType) {
        switch (deckType) {
            case "Standard":
                deck = StandardDeck.getStandardDeckInstance();
                break;
            case "Euchre":
                deck = EuchreDeck.getEuchreDeckInstance();

                break;
            case "Pinochle":
                deck = PinochleDeck.getPinochleDeckInstance();
                break;
            default:
                throw new IllegalStateException("Wrong input");
        }
    }

    /**
     * creating a deck for Vegas
     * @param deckType deck type
     * @param numberOfDecks number of decks to create a whole Vegas deck
     */
    @Override
    public void createDeck(String deckType, int numberOfDecks)
    {
        if(deckType.equals("Vegas"))
        {
            deck = VegasDeck.getVegasDeckInstance(numberOfDecks);
        }
    }

    /**
     * Setting number of players
     * @param numberOfhands number of players
     */
    @Override
    public void setNumberOfhands(int numberOfhands)
    {
        this.numberOfHands = numberOfhands;
    }

    /**
     * Dealing the cards to the players
     */
    @Override
    public void deal()
    {
        //* shuffle the deck *//
        deck.shuffle();

        //* create a hand which has a list of cards *//*
        listOfHand = new ArrayList<>(numberOfHands);

        for(int i = 0; i < numberOfHands; i++)
        {
            List<Card> eachHand = new ArrayList<>(numberOfCardsInHand);
            //* adding cards to a hand *//*
            for(int j = 0; j < numberOfCardsInHand; j++)
            {
                eachHand.add(deck.pullCard());
            }

            Hand hand = new HandClassFactory().createHandClass(eachHand, numberOfCardsInHand);
            listOfHand.add(hand);
        }
    }

    /**
     *
     * @return Returns a list of card in hand
     */
    List<Card> getNumberOfCardsInHand() {
        return listOfHand.get(0).showCards();
    }

    public Deck getDeck() {
        return deck;
    }
}
