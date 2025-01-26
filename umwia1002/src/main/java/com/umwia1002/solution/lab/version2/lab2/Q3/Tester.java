package com.umwia1002.solution.lab.version2.lab2.Q3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        UNOGame game = new UNOGame();
        int drawsPerPlayer = 7;

        System.out.printf("Each player draws %d cards from the deck.%n", drawsPerPlayer);

        // ArrayList Implementation
        System.out.println("ArrayList Implementation:");
        game.resetGame();
        playGame(game, drawsPerPlayer, true);

        System.out.println();

        // LinkedList Implementation
        System.out.println("LinkedList Implementation:");
        game.resetGame();
        playGame(game, drawsPerPlayer, false);
    }

    private static void playGame(UNOGame game, int drawsPerPlayer, boolean useArrayList) {
        for (int player = 1; player <= 2; player++) {
            System.out.printf("Player %d draws %d cards:%n", player, drawsPerPlayer);
            List<UNOCard> cards = useArrayList ? new ArrayList<>() : new LinkedList<>();
            game.drawCardsTo(drawsPerPlayer, cards);
			System.out.println(cards.stream().map(String::valueOf).collect(Collectors.joining(" :: ")));
            System.out.println();
        }
    }
}
