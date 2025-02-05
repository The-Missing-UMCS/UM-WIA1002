package com.umwia1002.solution.tutorial.tutorial7.tutorial7b;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T7bQ4 {
	// (a) 
	// To ensure the PriorityQueue removes elements based on the given comparison logic, 
	// specifically by string length of name.
	
	// (b)
	//	Ali
	//	Jason
	//	Muhamad
	
	//  Note: 
	//  By default, a Java PriorityQueue uses a (array-based) min-heap structure 
	//  to implement its underlying storage.
	
	public static void main(String[] args) {
		PriorityQueue2.main(args);
	}
}

class PriorityQueue2 {
	public static void main(String... args) {
		PriorityQueueComparator pqc = new PriorityQueueComparator();
		PriorityQueue<String> pq = new PriorityQueue<>(5, pqc);
		pq.add("Jason");
		pq.add("Ali");
		pq.add("Muhamad");
		for (String s : pq) {
			System.out.println(s);
		}
	}
}

class PriorityQueueComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length()) {
			System.out.println(s1 + " is shorter than " + s2);
			return -1;
		}
		if (s1.length() > s2.length()) {
			System.out.println(s1 + " is longer than " + s2);
			return 1;
		}
		return 0;
	}
}
