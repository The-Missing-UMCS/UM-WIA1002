package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class Z extends ConsoleCharacter {

    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        buff[3][1] = buff[2][2] = buff[1][3] = true;

        for (int i = 0; i < ConsoleCharacter.ROW; i++) {
            buff[0][i] = true;
            buff[4][i] = true;
        }

        return buff;
    }

    public boolean[][] getLowercase() {

        int column = 4;
        boolean[][] buff = getBuff(column + 2);

        buff[2][2] = buff[3][1] = true;

        for (int i = 0; i < 4; i++) {
            buff[1][i] = true;
            buff[4][i] = true;
        }

        return buff;
    }
}
