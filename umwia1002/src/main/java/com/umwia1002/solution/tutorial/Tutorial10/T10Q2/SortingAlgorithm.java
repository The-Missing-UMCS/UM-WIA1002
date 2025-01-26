package com.umwia1002.solution.tutorial.Tutorial10.T10Q2;

import java.util.Arrays;
import java.util.Random;

public abstract class SortingAlgorithm {
	protected static final int MAIN_DECOR = 9;
	protected static final int SUB_DECOR = 15;
	
	String name;
	Random rand;

	SortingAlgorithm(String name) {
		this.name = name;
		this.rand = new Random();
	}

	public void run() {
		int[] arr = rand.ints(10, 0, 10).toArray();
		System.out.println(name);
		System.out.print("Before: ");
		System.out.println(Arrays.toString(arr));
		System.out.println("Steps:");
		sort(arr);
		System.out.print("After: ");
		System.out.println(Arrays.toString(arr));
		System.out.println();
	}

	protected static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public abstract void sort(int[] arr);
	
	protected void printPos(int leftPos, int rightPos) {
		printPos(leftPos, rightPos, MAIN_DECOR);
	}

	protected void printPos(int leftPos, int rightPos, int decor) {
		if (leftPos == rightPos) {
			System.out.println(" ".repeat(space(leftPos) + 9) + "^");
		} else {
			int leftSpace = space(leftPos);
			int rightSpace = space(rightPos);
			System.out.printf("%s%s^%s^\n", " ".repeat(decor), " ".repeat(leftSpace),
					" ".repeat(rightSpace - leftSpace - 1));
		}
	}

	protected int space(int pos) {
		return 1 + pos * 3;
	}
}
