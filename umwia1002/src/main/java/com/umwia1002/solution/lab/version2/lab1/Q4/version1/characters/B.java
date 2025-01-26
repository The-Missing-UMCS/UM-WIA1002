package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class B extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 4;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotHorizontalLines(buff, 2, 3, new int[] {0, 2, 4});
		plotDotsInColumn(buff, 4, new int[] {1, 3});
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotVerticalLines(buff, 2, 3, new int[] {1, 5});
		plotHorizontalLine(buff, 2, 3, 4);
		buff[1][3] = true;
		return buff;
	}
}
