package com.umwia1002.solution.tutorial.Tutorial2;

public class T2Q1 {
	public static void main(String[] args) {
		Container.main(args);
	}
}

class Container<T> {
	T t;

	Container() {

	}

	public void add(T t) {
		this.t = t;
	}

	public T retrieve() {
		return t;
	}
	
	public static void main(String[] args) {
		Container<Integer> intCon = new Container<>();
		Container<String> strCon = new Container<>();
		intCon.add(50);
		strCon.add("Java");
		System.out.println(intCon.retrieve());
		System.out.println(strCon.retrieve());
	}

}
