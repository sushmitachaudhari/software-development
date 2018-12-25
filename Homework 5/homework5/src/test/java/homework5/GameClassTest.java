package homework5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Sushmita Chaudhari
 */
public class GameClassTest {

    /* Clear the singleton instances*/
    @Before
    public void setUp() {
        StandardDeck.clear();
        EuchreDeck.clear();
        PinochleDeck.clear();
        VegasDeck.clear();
    }

    /* Tests for creating game with each kind of deck*/
    @Test
    public void createStandardGame()
    {
        int numberOfCardsInHand = 5;
        GameFactory standardDeckGameFactory = new GameFactory();
        Game game = standardDeckGameFactory.createGame(5, numberOfCardsInHand);
        assertEquals(27, (((StandardDeck)((GameClass)game).getDeck()).getSize()));
    }

    @Test
    public void createEuchreGame()
    {
        GameFactory gameFactory = new GameFactoryWithEuchreDeck();
        Game game = gameFactory.createGame(4, 2);
        assertEquals(16,((EuchreDeck)((GameClass)game).getDeck()).getSize());
    }

    @Test
    public void createPinochleGame()
    {
        GameFactory gameFactory = new GameFactoryWithPinochleDeck();
        Game game = gameFactory.createGame(6, 8);
        assertEquals(0,((PinochleDeck)((GameClass)game).getDeck()).getSize());
    }

    @Test
    public void createVegasGame() {
        GameFactory gameFactory = new GameFactoryWithVegasDeck(3);
        Game game = gameFactory.createGame(6, 13);
        assertEquals(78,((VegasDeck)((GameClass)game).getDeck()).getSize());
    }

    @Test
    public void createDefaultVegasGame() {
        GameFactory gameFactory = new GameFactoryWithVegasDeck();
        Game game = gameFactory.createGame(3, 13);
        assertEquals(13,((VegasDeck)((GameClass)game).getDeck()).getSize());
    }


    /**
     * Boundary cases for each deck
     */
    @Test
    public void createStandardGameBoundary()
    {
        int numberOfCardsInHand = 13;
        GameFactory standardDeckGameFactory = new GameFactoryWithStandardDeck();
        Game game = standardDeckGameFactory.createGame(4, numberOfCardsInHand);
        assertEquals(0, (((StandardDeck)((GameClass)game).getDeck()).getSize()));
    }

    @Test
    public void createStandardGameBoundary1()
    {
        int numberOfCardsInHand = 0;
        GameFactory standardDeckGameFactory = new GameFactoryWithStandardDeck();
        Game game = standardDeckGameFactory.createGame(4, numberOfCardsInHand);
        assertEquals(52, (((StandardDeck)((GameClass)game).getDeck()).getSize()));
    }

    @Test
    public void createEuchreGameBoundary()
    {
        GameFactory gameFactory = new GameFactoryWithEuchreDeck();
        Game game = gameFactory.createGame(4, 6);
        assertEquals(0,((EuchreDeck)((GameClass)game).getDeck()).getSize());
    }

    @Test
    public void createPinochleGameBoundary()
    {
        GameFactory gameFactory = new GameFactoryWithPinochleDeck();
        Game game = gameFactory.createGame(6, 8);
        assertEquals(0,((PinochleDeck)((GameClass)game).getDeck()).getSize());
    }

    @Test
    public void createVegasGameBoundary() {
        GameFactory gameFactory = new GameFactoryWithVegasDeck(2);
        Game game = gameFactory.createGame(8, 13);
        assertEquals(0,((VegasDeck)((GameClass)game).getDeck()).getSize());
    }


    /**
     * Test cards are dealt properly or not in a game with each kind of deck
     */
    @Test
    public void dealWithStandardDeck() {

        GameFactory standardDeckGameFactory = new GameFactoryWithStandardDeck();
        Game game = standardDeckGameFactory.createGame(3, 5);

        int expectedCardsInHand = 5;
        assertEquals("expected number of cards",expectedCardsInHand,((GameClass) game).getNumberOfCardsInHand().size());
    }

    @Test
    public void dealWithEuchreDeck() {

        GameFactory gameFactoryWithEuchreDeck = new GameFactoryWithEuchreDeck();
        Game game = gameFactoryWithEuchreDeck.createGame(3, 5);

        int expectedCardsInHand = 5;
        assertEquals("expected number of cards",expectedCardsInHand,((GameClass) game).getNumberOfCardsInHand().size());
    }

    @Test
    public void dealWithPinochleDeck() {

        GameFactory gameFactoryWithPinochleDeck = new GameFactoryWithPinochleDeck();
        Game game = gameFactoryWithPinochleDeck.createGame(3, 5);

        int expectedCardsInHand = 5;
        assertEquals("expected number of cards",expectedCardsInHand,((GameClass) game).getNumberOfCardsInHand().size());
    }

    @Test
    public void dealWithVegasDeck() {

        GameFactory gameFactoryWithVegasDeck = new GameFactoryWithVegasDeck();
        Game game = gameFactoryWithVegasDeck.createGame(3, 5);

        int expectedCardsInHand = 5;
        assertEquals("expected number of cards",expectedCardsInHand,((GameClass) game).getNumberOfCardsInHand().size());
    }

}