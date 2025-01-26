package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class N extends ConsoleCharacter {

    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        buff[1][2] = buff[2][3] = buff[3][4] = true;

        for (int i = 0; i < ConsoleCharacter.ROW; i++) {
            buff[i][1] = true;
            buff[i][5] = true;
        }

        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotVerticalLine(buff, 1, ROW - 1, 0);
        buff[2][1] = buff[1][2] = buff[2][3] = true;
        plotVerticalLine(buff, 2, ROW - 1, 4);
        return buff;
    }
}
