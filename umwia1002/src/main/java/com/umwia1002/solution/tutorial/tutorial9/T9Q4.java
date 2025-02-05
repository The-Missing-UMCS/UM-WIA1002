package com.umwia1002.solution.tutorial.Tutorial9;

public class T9Q4 {
	public static void main(String[] args) {
		System.out.println(sum(5));
	}
	
	public static int sum(int N) {
		// Triangular Number
		if(N <= 1)
			return 1;
		else
			return N + sum(N - 1);
	}
}
