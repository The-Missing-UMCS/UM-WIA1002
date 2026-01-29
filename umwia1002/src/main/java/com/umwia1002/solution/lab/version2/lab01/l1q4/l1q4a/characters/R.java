package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class R extends ConsoleCharacter{
    
    public boolean [][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotVerticalLine(buff, 0, 4, 0);
        plotHorizontalLine(buff, 1, 2, 0);
        plotHorizontalLine(buff, 1, 2, 2);
        buff[1][3] = true;
        plotDiagonalLeftTop(buff, 2, 4);
        return buff;
    }
    
    public boolean [][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotVerticalLine(buff, 1, 4, 0);
        
        buff[2][1] = true;
        buff[1][2] = true;
        buff[1][3] = true;
        buff[2][4] = true;
        return buff;
    }
}
