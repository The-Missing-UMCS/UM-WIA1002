package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class M extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLines(buff, 0, ROW - 1, new int[] {1, 5});
		plotSpecialDiagonalLeftTop(buff, 0, 2);
		plotDiagonalRightTop(buff, 0, 2);
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 9;	
		boolean[][] buff = getBuff(column + 2);
		plotDotsInRow(buff, 1, new int[] {2, 4, 6, 8});
		plotVerticalLines(buff, 2, ROW - 1, new int[] {1, 5, 9});
//		plotHorizontalLine(buff, 2, 3, 1);
//		plotHorizontalLine(buff, 5, 6, 1);
//		plotVerticalLines(buff, 2, ROW - 1, new int[] {1, 4, 7});
		return buff;
	}
}
