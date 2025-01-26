package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class W extends ConsoleCharacter{
      public boolean[][] getUppercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);
        plotVerticalLine(buff, 1, 2, 0);
        plotVerticalLine(buff, 1, 2, 2);
        plotVerticalLine(buff, 1, 2, 4);
        buff[3][0] = true;
        buff[4][1] = true;
        buff[3][2] = true;
        buff[4][3] = true;
        buff[3][4] = true;
        
        return buff;
    }

    public boolean[][] getLowercase() {
        int column = 5;
        boolean[][] buff = getBuff(column + 2);

        plotVerticalLine(buff, 2, 2, 0);
        plotVerticalLine(buff, 2, 2, 2);
        plotVerticalLine(buff, 2, 2, 4);
        buff[3][0] = true;
        buff[4][1] = true;
        buff[3][2] = true;
        buff[4][3] = true;
        buff[3][4] = true;
        return buff;
    }
}
