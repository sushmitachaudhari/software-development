package homework5;

import java.util.List;

/**
 * Factory for Hand class
 */
class HandClassFactory{

    /**
     *
     * @param cards list of cards
     * @param numOfCardsInHand number of cards in hand
     * @return Hand
     */
    Hand createHandClass(List<Card> cards,  int numOfCardsInHand) {
        return new HandClass(cards, numOfCardsInHand);
    }
}