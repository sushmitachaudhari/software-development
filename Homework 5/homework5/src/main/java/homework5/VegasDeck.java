package homework5;

import java.util.ArrayList;
import java.util.List;

/**
 * An Vegas Deck class which implements Deck interface
 *
 * @author Sushmita Chaudhari
 */
class VegasDeck extends DefaultDeck {

    //create the deck for Vegas decktype
    private static VegasDeck vegasDeckInstance;

    /**
     * Vegas Deck constructor
     */
    private VegasDeck(int numberOfDecks)
    {
        specialDeck = new ArrayList<>();
        List<Card> vegasDeck1 = new ArrayList<>();

        for(SuitEnum suit : SuitEnum.values())
        {
            for(RankEnum rank : RankEnum.values())
            {
                vegasDeck1.add(new CardClass(rank, suit));
            }
        }

        for(int i = 0; i < numberOfDecks; i++)
        {
            specialDeck.addAll(new ArrayList<>(vegasDeck1));
        }
        setNumberOfCardsDealt(0);
        setOfficialSize(specialDeck.size());
    }

    /* singleton implementation and lazy initialization*/
    /* get VegasDeck instance */

    /**
     *
     * @return instance of Vegas deck instance
     */
    static VegasDeck getVegasDeckInstance(int numberOfDecks)
    {
        if(vegasDeckInstance == null)
        {
            vegasDeckInstance = new VegasDeck(numberOfDecks);
        }

        return vegasDeckInstance;
    }

    /**
     * clear the instance
     */
    static void clear() {
        vegasDeckInstance = null;
    }


}
