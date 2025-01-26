package com.umwia1002.solution.lab.version1.lab10;

import com.umwia1002.solution.lab.version1.lab10.iterative.BubbleSort;
import com.umwia1002.solution.lab.version1.lab10.iterative.InsertionSort;
import com.umwia1002.solution.lab.version1.lab10.iterative.SelectionSort;
import com.umwia1002.solution.lab.version1.lab10.recursive.HeapSort;
import com.umwia1002.solution.lab.version1.lab10.recursive.IterativeMergeSort;
import com.umwia1002.solution.lab.version1.lab10.recursive.QuickSort;
import com.umwia1002.solution.lab.version1.lab10.recursive.RecursiveMergeSort;

import java.util.Arrays;
import java.util.List;

import static com.umwia1002.solution.util.ConsoleUtil.logInfo;

public class Tester {
    public static void main(String[] args) {
        List<SortingAlgorithm> algorithms = Arrays.asList(
            new BubbleSort(), new InsertionSort(), new SelectionSort(),
            new HeapSort(), new IterativeMergeSort(), new RecursiveMergeSort(),
            new QuickSort());

        algorithms.forEach(algorithm -> {
            logInfo("Algorithm: %s".formatted(algorithm.name()));

            Integer[] arr = {1, 1, 5, 2, 2, 4, 3};
            System.out.printf("Before sorting: %s%n", Arrays.toString(arr));

            algorithm.sort(arr);
            System.out.printf("%s --> ascending sort: %s%n", algorithm.name(), Arrays.toString(arr));

            algorithm.sortDescending(arr);
            System.out.printf("%s --> descending sort: %s%n", algorithm.name(), Arrays.toString(arr));
            System.out.println();
        });
    }
}
