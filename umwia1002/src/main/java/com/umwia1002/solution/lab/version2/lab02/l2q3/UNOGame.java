package com.umwia1002.solution.lab.version2.lab02.l2q3;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class UNOGame {

    private static final int TOTAL_CARDS = 48;
    private final Set<Integer> drawnCards;

    public UNOGame() {
        this.drawnCards = new HashSet<>();
    }

    public void resetGame() {
        drawnCards.clear();
    }

    public void drawCardsTo(int num, List<UNOCard> cards) {
        if (num > TOTAL_CARDS - drawnCards.size()) {
            throw new IllegalArgumentException("Not enough cards left in the deck.");
        }

        Random random = new Random();
        while (cards.size() < num) {
            int cardIndex = random.nextInt(TOTAL_CARDS);
            if (drawnCards.add(cardIndex)) {
                String color = UNOCard.getColor(cardIndex / 12);
                String type = UNOCard.getType(cardIndex % 12);
                cards.add(new UNOCard(color, type));
            }
        }
    }
}
