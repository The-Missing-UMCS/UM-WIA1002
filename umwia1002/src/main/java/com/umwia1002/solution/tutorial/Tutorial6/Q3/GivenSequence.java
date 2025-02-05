package com.umwia1002.solution.tutorial.Tutorial6.Q3;

import java.util.Stack;

public class Q3_GivenSequence {
	public static void main(String[] args) {
		System.out.println(solveSequence(new int[] {1, 2, 3}, new int[] {1, 3, 2}));
	}
	
	public static String solveSequence(int[] pushSequence, int[] popSequence) {
		int pPush = 0, pPop = 0, size = pushSequence.length;
		Stack<Integer> stack = new Stack<>();
		StringBuilder stepBuilder = new StringBuilder();
		
		while(pPush < size || !stack.isEmpty()) {
			if(!stack.empty() && popSequence[pPop] == stack.peek()) {
				int val = stack.pop();
				stepBuilder.append("Pop " + val + " ");
				pPop++;
			} else {
				if(pPush == 3)
					return "No solution";
				
				if(pPush < size) {
					stack.push(pushSequence[pPush]);
					stepBuilder.append("Push " + pushSequence[pPush] + " ");
					pPush++;
				}
			}
		}
		
		return stepBuilder.toString();
	}
}
