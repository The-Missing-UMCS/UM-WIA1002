package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class S extends ConsoleCharacter {

    public boolean[][] getUppercase() {
        int column = 4;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 2, 3, 0);
        plotHorizontalLine(buff, 1, 2, 4);
        plotDiagonalLeftTop(buff, 1, 3);

        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 4;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 2, 3, 1);
        plotHorizontalLine(buff, 1, 2, 4);
        plotDiagonalLeftTop(buff, 2, 3);
        return buff;
    }
}
