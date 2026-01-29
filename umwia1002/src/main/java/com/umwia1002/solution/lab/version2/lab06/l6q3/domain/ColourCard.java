package com.umwia1002.solution.lab.version2.lab06.l6q3.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ColourCard implements Comparable<ColourCard> {

    private static final String[] COLOUR = {"Yellow", "Red", "Green", "Blue"};
    private static final String[] NUMBER = {"One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten"};

    private final int colour;
    private final int number;

    @Override
    public int compareTo(ColourCard card) {
        int val = Integer.compare(number, card.number);
        return val == 0 ? Integer.compare(colour, card.colour) : val;
    }

    @Override
    public String toString() {
        return String.format("%s %s", NUMBER[number], COLOUR[colour]);
    }
}
