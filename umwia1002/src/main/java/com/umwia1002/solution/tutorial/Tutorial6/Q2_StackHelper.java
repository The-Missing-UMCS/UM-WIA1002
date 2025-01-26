package com.umwia1002.solution.tutorial.Tutorial6;

import java.util.Iterator;
import java.util.Stack;

public class Q2_StackHelper {
	private static final int SIZE = 10;
	private static final int STACK_SPACE = 5;
	
	@SuppressWarnings("unchecked")
	public void printStack(int size, Stack<String> a, Stack<String> b, Stack<String> c) {
		Iterator<String>[] iterators = new Iterator[3];
		StringBuilder sb = new StringBuilder();
		
		iterators[0] = a.iterator();
		iterators[1] = b.iterator();
		iterators[2] = c.iterator();
		
		for(int i = 0; i < size; i++) {
			StringBuilder line = new StringBuilder();
			line.append(" ".repeat(STACK_SPACE));
			for(Iterator<String> iterator : iterators) {
				if(iterator.hasNext())
					line.append(filledStack(middleString(iterator.next())));
				else 
					line.append(emptyStack());
				line.append(" ".repeat(STACK_SPACE));
			}
			line.append('\n');
			line.append(bottomStack());
			sb.insert(0, line);
		}
		
		// Append the label of each stacks
		for(int i = 1; i <= 3; i++) {
			int factor = ((SIZE - 2) >> 1) + 1;
			sb.append(String.format("%ss%d%s", " ".repeat(STACK_SPACE + factor), i, " ".repeat(factor)));
		}
		
		sb.append('\n');
		System.out.println(sb);
	}
	
	public String bottomStack() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ".repeat(STACK_SPACE));
		for(int j = 0; j < 3; j++)
			sb.append(String.format("|%s|", "-".repeat(SIZE))).append(" ".repeat(STACK_SPACE));
		sb.append('\n');
		return sb.toString();
	}
	
	public String filledStack(String middleString) {
		return String.format("|%s|", middleString);
	}
	
	public String emptyStack() {
		return String.format("|%s|", " ".repeat(SIZE));
	}
	
	public String middleString(String str) {
		int space = SIZE - str.length();
		int left = space >> 1;
		int right = (space >> 1) + (space & 1);
		return String.format("%s%s%s", " ".repeat(left), str, " ".repeat(right));
	}
}
