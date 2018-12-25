package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * A Game class that implements Game interface
 *
 * @author Sushmita Chaudhari
 */
public class GameClass implements Game{


   private int numberOfHands;
   private int numberOfCardsInHand;
   private List<Hand> listOfHand;
   private Deck deck;
   private static final int VEGAS_NO_DECK = 1;


    /**
     * Game class constructor
     * @param numberOfCardsInHand number of cards each player should receive
     */
    //ASSUMPTION: Game is told  how many cards each player should have - same as in a real life.
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
    public void createDeck(String deckType) throws IllegalStateException
    {
        if(deckType.equalsIgnoreCase("Standard"))
        {
            StandardDeckBuilder standardDeckBuilder = new StandardDeckBuilder();
            deck = standardDeckBuilder.makeDeck();
        }
        else if(deckType.equalsIgnoreCase("Euchre"))
        {
            EuchreDeckBuilder euchreDeckBuilder = new EuchreDeckBuilder();
            deck = euchreDeckBuilder.makeDeck();
        }
        else if(deckType .equalsIgnoreCase("Pinochle"))
        {
            PinochleDeckBuilder pinochleDeckBuilder = new PinochleDeckBuilder();
            deck = pinochleDeckBuilder.makeDeck();
        }
        else if(deckType.equalsIgnoreCase("Vegas"))
        {
            VegasDeckBuilder vegasDeckBuilder = new VegasDeckBuilder();
            vegasDeckBuilder.setNumberOfDecks(VEGAS_NO_DECK);
            deck = vegasDeckBuilder.makeDeck();
        }
        else
            throw new IllegalStateException("Wrong input");
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
            VegasDeckBuilder vegasDeckBuilder = new VegasDeckBuilder();
            vegasDeckBuilder.setNumberOfDecks(numberOfDecks);
            deck = vegasDeckBuilder.makeDeck();
        }
        else
            throw new IllegalStateException("Wrong input");

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
        /* shuffle the deck */
        deck.shuffle();

        /* create a hand which has a list of cards */
        listOfHand = new ArrayList<>();

        for(int i = 0; i < numberOfHands; i++)
        {
            List<Card> eachHand = new ArrayList<>(numberOfCardsInHand);
            /* adding cards to a hand */
            for(int j = 0; j < numberOfCardsInHand; j++)
            {
              eachHand.add(deck.pullCard());
            }

            Hand hand = new HandClass(eachHand);

            listOfHand.add(hand);
        }
    }

    //For testing
    /**
     *
     * @return A list of Hand
     */
    List<Hand> getListoFHand()
    {
        return listOfHand;
    }

    //for testing
    /**
     *
     * @return Returns a list of card in hand
     */
    List<Card> getNumberOfCardsInHand() {
        return listOfHand.get(0).showCards();
    }

}
