package com.umwia1002.solution.lab.version1.lab7.lab7a.Q2;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		String[] words = {"abba", "aba", "Hello", "pliooilp", "lol", "T_T"};
		for(String word : words) {
			System.out.printf("%10s is palindromic string: %b\n", word, isPalindromic(word));
		}
	}
	
	public static boolean isPalindromic(String str) {
		Queue<Character> queue = new LinkedList<>();
		int mid = str.length() >> 1;
		
		for(int i = 0; i < mid; i++) {
			queue.add(str.charAt(i));
		}
		
		for(int i = str.length() - 1; i >= mid + (mid & 1); i--) {
			if(str.charAt(i) != queue.remove())
				return false;
		}
		
		return true;
	}
}
