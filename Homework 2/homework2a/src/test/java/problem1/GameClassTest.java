package problem1;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameClassTest {

    /**
     * Testing creation of a game
     */
    @Test
    public void createGame()
    {
        Game game = new GameClass(6);
        game.createDeck("Vegas", 2);
        game.setNumberOfhands(3);
        game.deal();


        assertEquals("Cards in hand.",((GameClass) game).getNumberOfCardsInHand().size(),6);
    }

    /**
     * Test if decks are properly created
     */
    @Test
    public void createDeck() {

        Game gameStandard = new GameClass(6);
        gameStandard.createDeck("Standard");
        gameStandard.setNumberOfhands(3);
        gameStandard.deal();
        int size = ((GameClass) gameStandard).getNumberOfCardsInHand().size() * ((GameClass) gameStandard).getListoFHand().size();

        assertEquals("These two decks must have the same size.", size, 18);

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

        Game standardGame = new GameClass( 5);
        standardGame.createDeck("Standard");
        standardGame.setNumberOfhands(3);
        standardGame.deal();

        int expectedCardsInHand = 5;
        int actualCardsInHand = ((GameClass) standardGame).getNumberOfCardsInHand().size();
        assertEquals("same no. of cards in each hand", expectedCardsInHand,actualCardsInHand);


        Game standardGame1= new GameClass( 6);
        standardGame1.createDeck("Standard");
        standardGame1.setNumberOfhands(3);
        standardGame1.deal();

        int numberOfHands = 3;
        int actualNoOfHands = ((GameClass) standardGame1).getListoFHand().size();

        assertEquals("same number of hands", numberOfHands, actualNoOfHands);

    }
}