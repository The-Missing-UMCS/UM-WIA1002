package com.umwia1002.solution.lab.version2.lab02.l2q3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class UNOCard {

    private static final String[] COLORS = {"Red", "Yellow", "Green", "Blue"};
    private static final String[] TYPES = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Skip", "Reverse", "Draw Two"};

    private final String color;
    private final String type;

    public static String getColor(int index) {
        return COLORS[index];
    }

    public static String getType(int index) {
        return TYPES[index];
    }

    @Override
    public String toString() {
        return String.format("%s %s", color, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UNOCard unoCard = (UNOCard) o;
        return Objects.equals(color, unoCard.color) && Objects.equals(type, unoCard.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
