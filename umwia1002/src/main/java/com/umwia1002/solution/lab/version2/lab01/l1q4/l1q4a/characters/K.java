package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class K extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 4;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotDotsInColumn(buff, 4, new int[] {0, 4});
		plotDotsInColumn(buff, 3, new int[] {1, 3});
		buff[2][2] = true;
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 4;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 1, ROW - 1, 1);
		plotDotsInColumn(buff, 3, new int[] {1, 3});
		buff[2][2] = buff[ROW - 1][4] = true;
		return buff;
	}
}
