package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class T extends ConsoleCharacter{
    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotHorizontalLine(buff, 1, 5, 0);
        plotVerticalLine(buff, 0, 4, 3);

        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotHorizontalLine(buff, 0, 4, 1);
        plotVerticalLine(buff, 0, 4, 2);
        return buff;
    }
}
