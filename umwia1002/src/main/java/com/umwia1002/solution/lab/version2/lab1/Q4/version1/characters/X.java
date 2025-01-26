package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class X extends ConsoleCharacter {
    public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotDiagonalLeftTop(buff, 0, 4);
//        plotDiagonalRightTop(buff, 0, 4);
        buff[4][0] = true;
        buff[3][1] = true;
        buff[2][2] = true;
        buff[1][3] = true;
        buff[0][4] = true;
        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotDiagonalLeftTop(buff, 1, 3);

        buff[3][1] = true;
        buff[2][2] = true;
        buff[1][3] = true;
        return buff;
    }
}
