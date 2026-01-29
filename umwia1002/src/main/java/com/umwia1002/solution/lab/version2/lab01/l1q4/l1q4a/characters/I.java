package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class I extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotHorizontalLines(buff, 1, 5, new int[] {0, 4});
		plotVerticalLines(buff, 1, 3, 3);
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 1;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 2, ROW - 1, 1);
		buff[0][1] = true;
		return buff;
	}
}
