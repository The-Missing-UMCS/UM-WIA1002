package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class V extends ConsoleCharacter{
     public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotVerticalLine(buff, 0, 2, 0);
        plotVerticalLine(buff, 0, 2, 4);
        buff[3][1] = true;
        buff[4][2] = true;
        buff[3][3] = true;
        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotVerticalLine(buff, 2, 2, 0);
        plotVerticalLine(buff, 2, 2, 4);
        buff[3][1] = true;
        buff[4][2] = true;
        buff[3][3] = true;
        return buff;
    }
}
