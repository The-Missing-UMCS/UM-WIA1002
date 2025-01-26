package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class J extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotHorizontalLine(buff, 1, 5, 0);
		plotHorizontalLine(buff, 1, 3, ROW - 1);
		plotVerticalLine(buff, 1, 3, 4);
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 4;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 2, ROW - 1, 4);
		plotVerticalLine(buff, 3, ROW - 1, 1);
		plotHorizontalLine(buff, 2, 3, ROW - 1);
		buff[0][4] = true;
		return buff;
	}
}
