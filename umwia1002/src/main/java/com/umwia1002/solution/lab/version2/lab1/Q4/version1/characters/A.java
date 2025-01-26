package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class A extends ConsoleCharacter {

	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLines(buff, 1, ROW - 1, new int[] {1, 5});
		plotHorizontalLines(buff, 2, 4, new int[] {0, 2});		
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 2, ROW - 1, 5);
		plotVerticalLine(buff, 2, 3, 1);
		plotHorizontalLine(buff, 2, 4, 1);
		plotHorizontalLine(buff, 2, 3, ROW - 1);
		return buff;
	}
	
}
