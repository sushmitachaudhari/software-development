package homework5;

/**
 * @author Sushmita Chaudhari
 */
public class GameFactoryWithStandardDeck extends GameFactory{
    /**
     * make Standard deck
     */
    @Override
    public void makeDeck() {
        game.createDeck("Standard");
    }
}
