package edu.northeastern.ccs.cs5500;

import java.util.ArrayList;
import java.util.List;

/**
 * An Vegas Deck class which implements Deck interface
 *
 * @author Sushmita Chaudhari
 */
class VegasDeck extends DefaultDeck {

    /**
     * Vegas Deck constructor
     */
    VegasDeck(int numberOfDecks)
    {
        specialDeck = new ArrayList<>();
        List<Card> vegasDeck1 = new ArrayList<>();

        for(SuitEnum suit : SuitEnum.values())
        {
            for(RankEnum rank : RankEnum.values())
            {
                vegasDeck1.add(new CardClassAdapter(rank, suit));
            }
        }

        for(int i = 0; i < numberOfDecks; i++)
        {
            specialDeck.addAll(new ArrayList<>(vegasDeck1));
        }
        setNumberOfCardsDealt(0);
        setOfficialSize(specialDeck.size());
    }


}
