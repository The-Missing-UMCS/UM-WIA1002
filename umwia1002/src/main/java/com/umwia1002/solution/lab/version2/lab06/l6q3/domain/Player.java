package com.umwia1002.solution.lab.version2.lab06.l6q3.domain;

import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

public class Player {

    @Getter
    private final String name;
    private final Queue<ColourCard> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList<>();
    }

    public void getCardFromDeck(Deck deck) {
        cards.add(deck.pollCard());
    }

    public void showCards() {
        for (ColourCard card : cards) {
            System.out.print(card.toString() + " --> ");
        }
        System.out.println();
    }

    public ColourCard card() {
        return cards.poll();
    }
}
