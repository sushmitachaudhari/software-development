package homework5;

/**
 * @author Sushmita Chaudhari
 */
public class GameFactoryWithPinochleDeck extends GameFactory{

    /**
     * make Pinochle deck
     */
    @Override
    public void makeDeck() {
        game.createDeck("Pinochle");
    }
}
