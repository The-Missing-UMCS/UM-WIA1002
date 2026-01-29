package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4b;

import com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4b.characters.*;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Banner {

    private static final List<ConsoleCharacter> COLLECTIONS = List.of(
        new A(), new B(), new C(), new D(), new E(), new F(), new G(), new H(),
        new I(), new J(), new K(), new L(), new M(), new N(), new O(), new P(),
        new Q(), new R(), new S(), new T(), new U(), new V(), new W(), new X(),
        new Y(), new Z(), new Space()
    );

    public void print(String message) {
        if (!isValidMessage(message)) {
            System.out.println("Invalid message. Only letters and spaces are allowed.");
            return;
        }

        // Create a board dynamically using List for flexibility
        List<char[]> board = initializeBoard();

        // Process each character in the message
        message.chars()
            .mapToObj(ch -> COLLECTIONS
                .get(Character.isLetter(ch) ? getPos((char) ch) : 26)
                .getCharacter())
            .forEach(character -> combine(board, character));

        printBoard(board);
    }

    private List<char[]> initializeBoard() {
        // Initialize an empty board with rows of length 0
        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < ConsoleCharacter.DEFAULT_HEIGHT; i++) {
            board.add(new char[0]);
        }
        return board;
    }

    private void printBoard(List<char[]> board) {
        board.forEach(row -> {
            System.out.println(
                new String(row).replace('\0', ' ') // Replace null characters with spaces
            );
        });
    }

    private boolean isValidMessage(String message) {
        return message.chars().allMatch(ch -> Character.isLetter(ch) || Character.isWhitespace(ch));
    }

    private int getPos(char ch) {
        return Character.toUpperCase(ch) - 'A';
    }

    private void combine(List<char[]> board, char[][] character) {
        for (int i = 0; i < character.length; i++) {
            board.set(i, ArrayUtils.addAll(board.get(i), character[i]));
        }
    }
}
