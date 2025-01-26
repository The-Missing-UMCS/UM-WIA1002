package com.umwia1002.solution.lab.version2.lab5.Q3;

import java.util.Stack;

public class Q3_2 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int row = 0, col = 0, N = 4, count = 0;
		
		System.out.println("Solving the " + N + " Queens problem");
		while(true) {
			for( ; row < N; row++, col = 0) {
				for( ; col < N; col++) {
					if(isSafe(stack, col)) {
						stack.push(col);
						break;
					}
				}
				
				if(stack.size() < row + 1)
					break; // Improve time complexity
			}
			
			if(stack.size() == N) {
				printStackSolution(stack);
				count++;
			}
				

			if(stack.empty())
				break; // No more solution
			
			col = stack.pop() + 1; // Backtracking
			row = stack.size();
		}
		
		System.out.println("The number of solutions is " + count);
	}

	public static boolean isSafe(Stack<Integer> stack, int col) {
		int row = stack.size();
		for(int i = 0; i < row; i++) {
			int tmp = stack.get(i);
			if(tmp == col || Math.abs(tmp - col) == row - i)
				return false;
		}
		return true;
	}
	
	public static void printStackSolution(Stack<Integer> stack) {
		int N = stack.size();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j == stack.get(i)) 
					System.out.print("Q ");
				else   		 
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
