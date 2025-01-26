package com.umwia1002.solution.tutorial.Tutorial2;

public class T2Q2 {
	public static void main(String[] args) {
		MyArray.main(args);
	}
}

class MyArray {
	public static void main(String[] args) {
		Integer[] nums = {1, 2, 3, 4, 5};
		String[] names = {"Jane", "Tom", "Bob"};
		Character[] chars = {'a', 'b', 'c'};
		list(nums);
		list(names);
		list(chars);
	}
	
	public static <T> void list(T[] arr) {
		for(T item : arr)
			System.out.println(item);
	}
}
