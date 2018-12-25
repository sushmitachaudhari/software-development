package problem2;

import java.util.List;

public class HandClassBuilder{
    private List<Card> cards;

    public HandClassBuilder setCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    HandClass createHandClass() {
        return new HandClass(cards);
    }
}