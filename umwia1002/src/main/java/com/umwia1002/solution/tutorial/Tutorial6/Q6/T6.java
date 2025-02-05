package com.umwia1002.solution.tutorial.Tutorial6.Q6;

import java.util.Stack;

public class T6 {
	public static void main(String[] args) {
		// Q1: c. peek
		// Q2.
		// new Q2Simulator().run();
		Stack<String> s1 = new Stack<>();
		Stack<String> s2 = new Stack<>();
		Stack<String> s3 = new Stack<>();
		s1.push("zero");
		s1.push("one");
		s1.push("two");
		
		s2.push(s1.pop());
		s3.push(s1.pop());
		s1.pop();
		s1.push(s2.pop());
		s2.push(s3.pop());
		s2.push(s1.pop());
		
		// Q3
		// a) 1-2-3 --> push 1, pop 1, push 2, pop 2, push 3, pop 3
		// b) 2-3-1 --> push 1, push 2, pop 2, push 3, pop 3, pop 1
		// c) 3-2-1 --> push 1, push 2, push 3, pop 3, pop 2, pop 1
		// d) 1-3-2 --> push 1, pop 1, push 2, push 3, pop 3, pop 2
		
		// Q4
		// a) a b c * +
		// b) a b * c d / - 
		// c) a b c * d + e / +
		
		// Q5
		// a) (a + b) * c
		// b) a * (b + c)
		
		// Q6 D. All of the above
	}
}