package com.umwia1002.solution.tutorial.tutorial8;

import java.util.Arrays;

public class T8Q2 {
	public static void main(String[] args) {
		final int[][] adjacencyMatrix = 
			{{0, 0, 1, 1, 0, 0, 0, 0, 0},
			 {0, 0, 0, 1, 0, 0, 0, 0, 0},
			 {0, 0, 0, 0, 1, 1, 0, 0, 0},
			 {0, 0, 0, 0, 1, 0, 0, 0, 0},
			 {0, 0, 0, 0, 0, 0, 1, 0, 0},
			 {0, 0, 0, 0, 0, 0, 0, 1, 0},
			 {0, 0, 0, 0, 0, 0, 0, 1, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 1},
             {0, 0, 0, 0, 0, 0, 0, 0, 0}};
		
		printAdjacencyMatrix(adjacencyMatrix);
		// Adjacency matrix is used
	}
	
	public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
		final int SPACE = 4;
		final int MARGIN = 2;
		
		System.out.printf("%" + SPACE + "s", "");
		
		for(int ch = 'A'; ch <= 'I'; ch++)
			System.out.print((char) ch + " ".repeat(MARGIN));
		System.out.println();
		
		int ch = 'A';
		for(int[] row : adjacencyMatrix) {
			System.out.println((char) ch + " ".repeat(SPACE - 2) + Arrays.toString(row));
			ch++;
		}
	}
}
