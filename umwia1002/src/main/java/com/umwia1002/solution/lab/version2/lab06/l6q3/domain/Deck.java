package com.umwia1002.solution.lab.version2.lab06.l6q3.domain;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
public class Deck {

    private final Queue<Integer> deck;

    public static Deck getInstance() {
        // 1. Initialize the deck and shuffle it
        List<Integer> deck = new LinkedList<>();
        for (int i = 0; i < 40; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        return new Deck(new LinkedList<>(deck));
    }

    public ColourCard pollCard() {
        Integer value = deck.poll();
        if (value == null) {
            throw new IllegalStateException("Deck is empty");
        }
        return new ColourCard(value / 10, value % 10);
    }
}
