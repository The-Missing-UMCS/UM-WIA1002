package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class H extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLines(buff, 0, ROW - 1, new int[] {1, 5});
		plotHorizontalLine(buff, 2, 4, 2);
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 5;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotVerticalLine(buff, 3, ROW - 1, 5);
		plotHorizontalLine(buff, 3, 4, 2);
//		buff[1][2] = true;
		return buff;
	}
}
