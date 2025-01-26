package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class O extends ConsoleCharacter {

    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 2, 4, 0);
        plotHorizontalLine(buff, 2, 4, 4);
        plotVerticalLine(buff, 1, 3, 1);
        plotVerticalLine(buff, 1, 3, 5);
        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 4;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 1, 2, 1);
        plotHorizontalLine(buff, 1, 2, 4);
        plotVerticalLine(buff, 2, 3, 0);
        plotVerticalLine(buff, 2, 3, 3);
        return buff;
    }
}
