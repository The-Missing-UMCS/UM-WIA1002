package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class D extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotVerticalLine(buff, 1, 3, 5);
		plotHorizontalLines(buff, 2, 4, new int[] {0, 4});		
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 4;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 4);
		plotHorizontalLines(buff, 2, 3, new int[] {2, 4});
		buff[3][1] = true;
		return buff;
	}
}
