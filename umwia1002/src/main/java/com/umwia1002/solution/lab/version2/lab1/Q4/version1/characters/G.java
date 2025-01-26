package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public class G extends ConsoleCharacter {
	public boolean[][] getUppercase() {
		int column = 5;
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, ROW - 1, 1);
		plotVerticalLine(buff, 2, ROW - 1, 5);
		plotHorizontalLine(buff, 1, 5, 0);
		plotHorizontalLine(buff, 3, 5, 2);
		plotHorizontalLine(buff, 1, 5, 4);
		return buff;
	}

	public boolean[][] getLowercase() {
		int column = 4;	
		boolean[][] buff = getBuff(column + 2);
		plotVerticalLine(buff, 0, 2, 1);
		plotVerticalLine(buff, 0, ROW - 1, 4);
		plotHorizontalLines(buff, 2, 3, new int[] {0, 2, 4});
		buff[4][1] = true;
		return buff;
	}
	
}
