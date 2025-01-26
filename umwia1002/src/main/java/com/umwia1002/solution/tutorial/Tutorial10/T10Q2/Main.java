package com.umwia1002.solution.tutorial.Tutorial10.T10Q2;

public class Main {
	public static void main(String[] args) {
		SortingAlgorithm algo;
		algo = new InsertionSort();
		algo.run();
		
		algo = new SelectionSort();
		algo.run();
		
		algo = new BubbleSort();
		algo.run();
		
		algo = new MergeSort();
		algo.run();
	}
}

