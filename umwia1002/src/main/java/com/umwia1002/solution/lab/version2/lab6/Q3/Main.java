package com.umwia1002.solution.lab.version2.lab6.Q3;

import com.umwia1002.solution.lab.version2.lab6.Q3.domain.Deck;
import com.umwia1002.solution.lab.version2.lab6.Q3.domain.Player;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize a game
        int numOfCards = 5;
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        initializeGame(p1, p2, numOfCards);

        // 2. Show the current cards on hand;
        showCards(p1, p2);

        // 3. Compare the cards and determine the winner
        compareCardsAndDetermineWinner(p1, p2, numOfCards);
    }

    private static void initializeGame(Player p1, Player p2, int numOfCards) {
        Deck deck = Deck.getInstance();
        for (int i = 0; i < numOfCards; i++) {
            p1.getCardFromDeck(deck);
            p2.getCardFromDeck(deck);
        }
    }

    private static void showCards(Player p1, Player p2) {
        String format = "%s's Card:%n";

        System.out.printf(format, p1.getName());
        p1.showCards();

        System.out.printf(format, p2.getName());
        p2.showCards();
    }

    private static void compareCardsAndDetermineWinner(Player p1, Player p2, int numOfCards) {
        // scores[0] = p1, scores[1] = p2
        int[] scores = {0, 0};
        for (int i = 0; i < numOfCards; i++) {
            scores[p1.card().compareTo(p2.card()) > 0 ? 0 : 1]++;
        }

        System.out.printf("Player %s Score: %d%n", p1.getName(), scores[0]);
        System.out.printf("Player %s Score: %d%n", p2.getName(), scores[1]);
        System.out.printf("Player %s WINS!", scores[0] > scores[1] ? p1.getName() : p2.getName());
    }
}
