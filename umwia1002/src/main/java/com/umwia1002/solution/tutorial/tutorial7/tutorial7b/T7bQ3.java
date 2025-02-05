package com.umwia1002.solution.tutorial.tutorial7.tutorial7b;

import java.util.*;

public class T7bQ3 {
	// (a) peek() gives us: C++
	
	// (b)
	//	The queue elements:
	//	C++
	//	Fortran
	//	Java
	//	Python
	
	// (c)
	//	After poll():
	//	Fortran
	//	Python
	//	Java
	
	// (d)
	//	After remove():
	//	Fortran
	//	Python
	
	// (e) Priority queue contains Ruby or not?: false
	
	// (f)
	//	Value in array: 
	//	Value: Fortran
	//	Value: Python
	
	public static void main(String[] args) {
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
		pQueue.offer("C++");
		pQueue.offer("Python");
		pQueue.offer("Java");
		pQueue.offer("Fortran");
		
		System.out.println("peek() gives us: " + pQueue.peek()); 
		
		System.out.println("The queue elements:");
        for (String s : pQueue) System.out.println(s);
		
		pQueue.poll();
		System.out.println("After poll():"); // (c)
        for (String s : pQueue) System.out.println(s); // (c)
		
		pQueue.remove("Java");
		System.out.println("After remove():"); // (d)
        for (String s : pQueue) System.out.println(s); // (d)
		
		boolean b = pQueue.contains("Ruby");
		System.out.println("Priority queue contains Ruby or not?: " + b); // (e)
		Object[] arr = pQueue.toArray();
		
		
		System.out.println("Value in array: "); // (f)
        for (Object object : arr) System.out.println("Value: " + object.toString()); // (f)
	}
}
