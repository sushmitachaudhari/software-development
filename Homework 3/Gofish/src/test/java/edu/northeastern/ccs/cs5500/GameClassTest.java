package edu.northeastern.ccs.cs5500;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Sushmita Chaudhari
 */
public class GameClassTest {
    /**
     * Test if decks are properly created
     */
    @Test
    public void createDeck() {

        Game game1 = new GameClass(6);
        game1.createDeck("Vegas", 3);
        game1.setNumberOfhands(3);
        game1.deal();


        assertEquals("Cards in hand.",((GameClass) game1).getNumberOfCardsInHand().size(),6);

    }

    /**
     * Test Proper creation of a Vegas deck
     */
    @Test
    public void createDeck1() {

        Deck vegasDeck = new VegasDeck(2);
        Deck vegasDeck1 = new VegasDeck(4);

        assertNotEquals("These Vegas decks' sizes must not be equal.", ((VegasDeck) vegasDeck).getSize(),
                ((VegasDeck) vegasDeck1).getSize());

    }

    /**
     * Test cards are dealt properly
     */
    @Test
    public void deal() {

        Game standardGame = new GameClass(5);
        standardGame.createDeck("Standard");
        standardGame.setNumberOfhands(3);
        standardGame.deal();

        //test if expected numbers of cards are given to each hand
        int expectedCardsInHand = 5;
        assertEquals("expected number of cards",expectedCardsInHand,((GameClass) standardGame).getNumberOfCardsInHand().size());

        //test if expected numbers of hands are getting created
        int expectedNumberOfHands = 3;
        assertEquals("Number of hands",expectedNumberOfHands,((GameClass) standardGame).getListoFHand().size());
    }

}