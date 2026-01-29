package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class C extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotHorizontalLines(buff, 2, 5, new int[] {0, 4});
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 4;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 1, ROW - 1, 1);
		plotHorizontalLines(buff, 2, 4, new int[] {1, 4});
		return buff;
	}
}
