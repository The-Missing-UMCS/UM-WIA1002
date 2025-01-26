package com.umwia1002.solution.tutorial.Tutorial6;

import java.util.Stack;

public class Q2_Simulator {	
	public static void main(String[] args) {
		Q2_StackHelper helper = new Q2_StackHelper();
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		Stack<String> s3 = new Stack<>();
		s1.push("zero");
		s1.push("one");
		s1.push("two");
		helper.printStack(3, s1, s2, s3);
		
		s2.push(s1.pop());
		helper.printStack(3, s1, s2, s3);
		s3.push(s1.pop());
		helper.printStack(3, s1, s2, s3);
		s1.pop();
		helper.printStack(3, s1, s2, s3);
		s1.push(s2.pop());
		helper.printStack(3, s1, s2, s3);
		s2.push(s3.pop());
		helper.printStack(3, s1, s2, s3);
		s2.push(s1.pop());
		helper.printStack(3, s1, s2, s3);
	}
}
