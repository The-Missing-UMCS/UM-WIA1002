package com.umwia1002.solution.lab.version1.lab7.lab7a.Q1;

public class Tester {
	public static void main(String[] args) {
		String[] fruitsOne = {"Durian", "Blueberry"};
		String[] fruitsTwo = {"Apple", "Orange", "Grapes", "Cherry"};
		
		MyQueue<String> fruitQ = new MyQueue<>(fruitsOne);
		for(String fruit : fruitsTwo) {
			fruitQ.enqueue(fruit);
		}
		
		// C. Display the queue
		System.out.println("Display the queue: " + fruitQ);
		System.out.println();
		
		// D. Show the top item
		System.out.println("Top item: " + fruitQ.peek());
		System.out.println();
		
		// E. Get the queue size
		System.out.println("Queue size: " + fruitQ.getSize());
		System.out.println();
		
		// F. Delete Durian
		System.out.println(fruitQ.dequeue() + " is deleted.");
		System.out.println();
		
		// G. Get item in index of position of 2
		System.out.println(fruitQ.getElement(2) + " is in index of position of 2");
		System.out.println();
		
		// H. Check whether the queue consists of Cherry
		System.out.println("Queue consists of Cherry: " + fruitQ.contains("Cherry"));
		System.out.println();
		
		// I. Check whether the queue consists of Durian
		System.out.println("Queue consists of Durian: " + fruitQ.contains("Durian"));
		System.out.println();
		
		// J. Display the queue using the isEmpty() condition
		System.out.println("Display the queue using the isEmpty() condition:");
		while(!fruitQ.isEmpty())
			System.out.print(fruitQ.dequeue() + " ");
		System.out.println();
		
	}
}
