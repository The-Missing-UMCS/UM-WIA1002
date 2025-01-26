package com.umwia1002.solution.lab.version2.lab1.Q4.version1.characters;

public abstract class ConsoleCharacter {
	protected static final int ROW = 5;
	
	protected boolean[][] getBuff(int column) {
		boolean[][] buff = new boolean[ROW][];
		for(int i = 0; i < ROW; i++) {
			buff[i] = new boolean[column];
		}
		return buff;
	}
	
	protected void plotVerticalLine(boolean[][] buff, int startRow, int endRow, int column) {
		for(int i = startRow; i <= endRow; i++) 
			buff[i][column] = true;
	}
	
	protected void plotVerticalLines(boolean[][] buff, int startRow, int endRow, int... columns) {
		for(int column : columns)
			plotVerticalLine(buff, startRow, endRow, column);
	}
	
	protected void plotHorizontalLine(boolean[][] buff, int startColumn, int endColumn, int row) {
		for(int i = startColumn; i <= endColumn; i++) 
			buff[row][i] = true;
	}
	
	protected void plotHorizontalLines(boolean[][] buff, int startColumn, int endColumn, int... rows) {
		for(int row : rows)
			plotHorizontalLine(buff, startColumn, endColumn, row);
	}
	
	protected void plotDotsInRow(boolean[][] buff, int row, int... dotColumns) {
		for(int dotColumn : dotColumns)
			buff[row][dotColumn] = true;
	}
	
	protected void plotDotsInColumn(boolean[][] buff, int column, int... dotRows) {
		for(int dotRow : dotRows)
			buff[dotRow][column] = true;
	}
	
	protected void plotSpecialDiagonalLeftTop(boolean[][] buff, int startRowIndex, int endRowIndex) {
		for(int i = startRowIndex; i <= endRowIndex; i++) 
			buff[i][i + 1] = true;
	}
	
	protected void plotDiagonalLeftTop(boolean[][] buff, int startRowIndex, int endRowIndex) {
		for(int i = startRowIndex; i <= endRowIndex; i++) 
			buff[i][i] = true;
	}
	
	protected void plotDiagonalRightTop(boolean[][] buff, int startRowIndex, int endRowIndex) {
		int column = buff[0].length - startRowIndex - 2;
		for(int i = startRowIndex; i <= endRowIndex; i++)
			buff[i][column--] = true;
	}
	
	public abstract boolean[][] getUppercase();
	public abstract boolean[][] getLowercase();
	
	
}
