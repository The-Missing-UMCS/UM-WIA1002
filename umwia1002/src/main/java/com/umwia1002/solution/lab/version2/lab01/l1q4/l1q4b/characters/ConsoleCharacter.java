package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4b.characters;

public interface ConsoleCharacter {
    int DEFAULT_HEIGHT = 5;
    int DEFAULT_SPACE = 1;

    String getAscii();

    default char[][] getCharacter() {
        String[] lines = getAscii().split("\n");
        int size = lines[0].length();
        char[][] character = new char[DEFAULT_HEIGHT][size + DEFAULT_SPACE * 2];

        for (int i = 0; i < DEFAULT_HEIGHT; i++) {
            System.arraycopy(lines[i].toCharArray(), 0, character[i], 1, size);
        }
        return character;
    }
}