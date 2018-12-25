package homework5;

/**
 * @author Sushmita Chaudhari
 */
class GameFactoryWithVegasDeck extends GameFactory{

    /**
     * number of decks
     */
    private int numberOfDecks;

    /**
     * constructor of GameFactory
     */
    GameFactoryWithVegasDeck() {
         this.numberOfDecks = 1;

    }

    /**
     * constructor for GameFactory
     * @param numberOfDecks number of decks
     */
     GameFactoryWithVegasDeck(int numberOfDecks) {

        this.numberOfDecks = numberOfDecks;
    }

    /**
     *
     * @param numberOfDecks number of decks
     */
    private void makeDeck(int numberOfDecks) {

        game.createDeck("Vegas", numberOfDecks);
    }

    /**
     *
     * @param numberOfHands number of hands
     * @param cardsInHand cards in a hand
     * @return game
     */
    @Override
    Game createGame(int numberOfHands, int cardsInHand) {
        makeGame(cardsInHand);
        makeDeck(numberOfDecks);
        setNumberOfHands(numberOfHands);
        game.deal();
        return game;
    }
}
