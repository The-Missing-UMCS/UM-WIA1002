package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class Q extends ConsoleCharacter {

    public boolean[][] getUppercase() {
        int column = 6;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 2, 4, 0);
        plotHorizontalLine(buff, 2, 4, 3);
        plotVerticalLine(buff, 1, 2, 1);
        plotVerticalLine(buff, 1, 2, 5);
        plotDiagonalLeftTop(buff, 3, 4);
        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 1, 3, 0);
        plotHorizontalLine(buff, 1, 3, 2);
        plotVerticalLine(buff, 0, 4, 3);

        buff[1][0] = true;
        buff[3][4] = true;
        return buff;
    }
}
