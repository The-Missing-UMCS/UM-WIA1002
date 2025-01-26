package com.umwia1002.solution.tutorial.Tutorial10.T10Q1;

import java.util.Arrays;
import java.util.Random;

public class Main {
	private static Random RANDOM = new Random();
	
	public static void main(String[] args) {
		int initialSize = 10;
		int finalSize = 1000000;
		show(initialSize, finalSize);
	}
	
	public static void show(int initialSize, int finalSize) {
		final int LOW = 1, HIGH = 1000000, REPEAT = 1000;
		
		int length = (int) Math.log10(finalSize / initialSize) + 1;
		long[][] yAxis = new long[3][length];
		int[] xAxis = new int[length];

		for (int size = initialSize, i = 0; size <= finalSize; size *= 10, i++) {
			long[] times = run(size, LOW, HIGH, REPEAT);
			System.out.printf("When size = %d, total time used = %s\n", size, Arrays.toString(times));
			xAxis[i] = size;
			for (int j = 0; j < times.length; j++)
				yAxis[j][i] = times[j] / REPEAT;
		}
		
		System.out.println("\nThe average time used (in increasing size):");
		System.out.printf("  %-25s = %s\n", "Size", Arrays.toString(xAxis));
		System.out.printf("  %-25s = %s\n", "Linear Search", Arrays.toString(yAxis[0]));
		System.out.printf("  %-25s = %s\n", "Recursive Binary Search", Arrays.toString(yAxis[1]));
		System.out.printf("  %-25s = %s\n", "Iterative Binary Search", Arrays.toString(yAxis[2]));
		
		String[] series = new String[] {"Linear Search", "Binary Search (Iteratively)", "Binary Search (Recursively)"};
		GraphDrawer drawer = new GraphDrawer(
				"Line Chart",
				"Comparison between different searching algorithm",
				"Size of the array", "Time used for searching",
				series, xAxis, yAxis, length, 3);
		
		drawer.draw();
	}
	
	public static long[] run(int size, int low, int high, int repeat) {
		int[] arr;
		long[] times = new long[3];
		long start;

		for (int i = 0; i < repeat; i++) {
			arr = RANDOM.ints(size, low, high).toArray();
			int n = RANDOM.nextInt(high) + low;

			start = System.nanoTime();
			Searching.linearSearch(arr, n);
			times[0] += (System.nanoTime() - start);

			start = System.nanoTime();
			Searching.binarySearchIterative(arr, n);
			times[1] += System.nanoTime() - start;

			start = System.nanoTime();
			Searching.binarySearchRecursive(arr, 0, arr.length - 1, n);
			times[2] += System.nanoTime() - start;
		}

		return times;
	}

}
