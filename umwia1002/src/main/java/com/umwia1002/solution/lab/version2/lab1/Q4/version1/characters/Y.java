package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class Y extends ConsoleCharacter {
    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotDiagonalLeftTop(buff, 0, 2);
        buff[1][3] = true;
        buff[0][4] = true;
        plotVerticalLine(buff, 2, 4, 2);

        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotVerticalLine(buff, 0, 4, 4);
        plotVerticalLine(buff, 0, 1, 0);
        plotVerticalLine(buff, 3, 4, 0);
        plotHorizontalLine(buff, 1, 3, 2);
        buff[4][2] = true;

        return buff;
    }
}
