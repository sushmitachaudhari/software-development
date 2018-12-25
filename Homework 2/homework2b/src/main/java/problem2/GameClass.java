package problem2;

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

        // singletons //
        /**
         * Creating a deck
         * @param deckType string to represent a deck type
         * @throws IllegalStateException if wrong deck type is given
         */
        @Override
        public void createDeck(String deckType) {
            if (deckType.equals("Standard")) {
                deck = StandardDeck.getStandardDeckInstance();
            } else if (deckType.equals("Euchre")) {
                deck = EuchreDeck.getEuchreDeckInstance();

            } else if (deckType.equals("Pinochle")) {
                deck = PinochleDeck.getPinochleDeckInstance();
            }
            else
                throw new IllegalStateException("Wrong input");
        }

    /**
     * creating a deck for Vegas
     * @param deckType deck type
     * @param numberOfDecks number of decks to create a whole Vegas deck
     */
        //Abstract Factory//
        @Override
        public void createDeck(String deckType, int numberOfDecks)
        {
            if(deckType.equals("Vegas"))
            {
                VegasDeckBuilder vegasDeckBuilder = new VegasDeckBuilder();
                vegasDeckBuilder.setNumberOfDecks(numberOfDecks);
                deck = vegasDeckBuilder.makeDeck();
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
            //* shuffle the deck *//*
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

                Hand hand = new HandClassBuilder().setCards(eachHand).createHandClass();

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
