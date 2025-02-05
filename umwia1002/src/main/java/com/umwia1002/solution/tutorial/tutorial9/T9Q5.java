package com.umwia1002.solution.tutorial.tutorial9;

public class T9Q5 {
	public static void main(String[] args) {
		printDigit(4567);
		print(0);
	}
	
	public static void print(int n) {
		if(n > 0) {
			print(n / 10);
			System.out.print(n % 10 + " ");
		}
	}
	
	public static void printDigit(int n) {
		if(n == 0)
			System.out.print(n);
		else 
			print(n);
		System.out.println();
	}
}
