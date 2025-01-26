package com.umwia1002.solution.tutorial.Tutorial1.T1Q3;

public class C {
	public static void main(String[] args) {
		Object[] o = { new A(), new B() };
		System.out.print(o[0]);
		System.out.print(o[1]);
		// AB
	}
}

class A extends B {
	public String toString() {
		return "A";
	}
}

class B {
	public String toString() {
		return "B";
	}
}
