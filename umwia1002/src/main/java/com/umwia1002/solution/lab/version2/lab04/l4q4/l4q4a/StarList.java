package com.umwia1002.solution.lab.version2.lab04.l4q4.l4q4a;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StarList {

    private static final char STAR = '*';
    private static final Random RANDOM = new Random();
    private static final int WINNING_SIZE = 20;

    public static void main(String[] args) {
        // 1. Initialize player lists
        List<Character> player1 = new LinkedList<>();
        List<Character> player2 = new LinkedList<>();
        boolean isPlayer1Turn = RANDOM.nextBoolean();

        System.out.printf("Player %d starts first.%n", isPlayer1Turn ? 1 : 2);

        // 2. Game loop
        while (Math.max(player1.size(), player2.size()) < WINNING_SIZE) {
            List<Character> currentPlayer = isPlayer1Turn ? player1 : player2;

            playTurn(currentPlayer, isPlayer1Turn ? 1 : 2);

            isPlayer1Turn = !isPlayer1Turn;
        }

        // 3. Declare the winner
        int winner = player1.size() >= WINNING_SIZE ? 1 : 2;
        System.out.printf("Player %d wins the game!%n", winner);
    }

    /**
     * Simulates a player's turn by rolling the dice and updating their list.
     *
     * @param player The current player's list.
     * @param playerNumber The current player's number.
     */
    private static void playTurn(List<Character> player, int playerNumber) {
        int diceRoll = rollDice();
        System.out.printf("Player %d rolls %d.%n", playerNumber, diceRoll);

        addStars(player, diceRoll);
        System.out.printf("Player %d: %s%n", playerNumber, formatList(player));
    }

    /**
     * Rolls a dice to generate a random number between 1 and 6.
     *
     * @return The result of the dice roll.
     */
    private static int rollDice() {
        return RANDOM.nextInt(6) + 1;
    }

    /**
     * Adds stars to a player's list based on the dice roll.
     *
     * @param player The current player's list.
     * @param count The number of stars to add.
     */
    private static void addStars(List<Character> player, int count) {
        player.addAll(new LinkedList<>(Stream.of(new Character[count]).map(_ -> STAR).toList()));
    }

    /**
     * Formats the list into a string representation for printing.
     *
     * @param list The list to format.
     * @return A string representation of the list.
     */
    private static String formatList(List<Character> list) {
        return String.join(" --> ", list.stream().map(String::valueOf).toList()) + " --> ";
    }
}
