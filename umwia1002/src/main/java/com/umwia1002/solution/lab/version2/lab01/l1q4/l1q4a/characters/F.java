package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters;

public class F extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 4;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotHorizontalLine(buff, 2, 4, 0);
		plotHorizontalLine(buff, 2, 3, 2);
		
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 5;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 2);
		plotHorizontalLine(buff, 2, 4, 0);
		plotHorizontalLine(buff, 1, 5, 2);
		return buff;
	}
}
