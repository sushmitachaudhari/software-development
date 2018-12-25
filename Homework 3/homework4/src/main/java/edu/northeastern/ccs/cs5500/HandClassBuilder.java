package edu.northeastern.ccs.cs5500;

import java.util.List;

/**
 * Hand class Builder
 *
 **/
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