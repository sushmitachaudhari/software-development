package homework5;

/**
 * @author Sushmita Chaudhari
 */
class GameFactory {
    /**
     * Game
     */
    Game game;

    /**
     *
     * @param cardsInHand cards in hand
     */
    void makeGame(int cardsInHand) {
        game = new GameClass(cardsInHand);
    }

    /**
     * factory method for making deck
     */
    void makeDeck() {
        game.createDeck("Standard");
    }

    /**
     *
     * @param numberOfHands number of hands
     */
    void setNumberOfHands(int numberOfHands) {
        game.setNumberOfhands(numberOfHands);
    }

    /**
     *
     * @param numberOfHands number of hands
     * @param cardsInHand cards in a hand
     * @return game
     */
    Game createGame(int numberOfHands, int cardsInHand) {
        makeGame(cardsInHand);
        makeDeck();
        setNumberOfHands(numberOfHands);
        game.deal();
        return game;
    }
}
