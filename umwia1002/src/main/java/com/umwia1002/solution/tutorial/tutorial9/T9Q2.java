package com.umwia1002.solution.tutorial.Tutorial9;

public class T9Q2 {
	public static void main(String[] args) {
		// StackOverflow error
		// The base case n == 0 will never execute for n > 0 
	}
	
	public static int f(int n) {
		if(n == 0)
			return n;
		else 
			return f(n + 1) + n;
	}
}
