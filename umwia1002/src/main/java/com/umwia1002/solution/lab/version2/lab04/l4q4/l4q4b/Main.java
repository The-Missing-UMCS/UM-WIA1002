package com.umwia1002.solution.lab.version2.lab04.l4q4.l4q4b;

import java.util.Random;

public class Main {

    private static final char STAR = '*';

    public static void main(String[] args) {
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        boolean isOneTurn = new Random().nextBoolean();

        System.out.printf("%s starts first%n", isOneTurn ? p1 : p2);

        while (Math.max(p1.starCount(), p2.starCount()) <= 20) {
            Player currentPlayer = isOneTurn ? p1 : p2;
            int diceValue = currentPlayer.rollDice();
            System.out.printf("%s's star(s) (+%d,=%2d): %s%n", currentPlayer, diceValue,
                currentPlayer.starCount(), currentPlayer.getStars());
            isOneTurn = !isOneTurn;
        }

        System.out.printf("%s wins the game!", p1.starCount() > 20 ? p1 : p2);
    }
}

