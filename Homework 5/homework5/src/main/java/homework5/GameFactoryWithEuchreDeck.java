package homework5;

/**
 * @author Sushmita Chaudhari
 */
public class GameFactoryWithEuchreDeck extends GameFactory {

    /**
     * make deck for Euchre
     */
    @Override
    public void makeDeck() {
        game.createDeck("Euchre");
    }
}
