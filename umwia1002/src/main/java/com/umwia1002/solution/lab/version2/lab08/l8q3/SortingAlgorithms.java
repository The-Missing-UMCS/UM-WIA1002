package com.umwia1002.solution.lab.version2.lab08.l8q3;

import java.util.List;

public final class SortingAlgorithms {

    private static final BubbleSort BUBBLE_SORT = new BubbleSort();
    private static final SelectionSort SELECTION_SORT = new SelectionSort();
    private static final InsertionSort INSERTION_SORT = new InsertionSort();
    private static final MergeSort MERGE_SORT = new MergeSort();
    private static final HeapSort HEAP_SORT = new HeapSort();
    private static final SinglePivotQuickSort SINGLE_PIVOT_QUICK_SORT = new SinglePivotQuickSort();
    private static final DualPivotQuickSort DUAL_PIVOT_QUICK_SORT = new DualPivotQuickSort();

    private SortingAlgorithms() {
    }

    public static BubbleSort bubbleSort() {
        return BUBBLE_SORT;
    }

    public static SelectionSort selectionSort() {
        return SELECTION_SORT;
    }

    public static InsertionSort insertionSort() {
        return INSERTION_SORT;
    }

    public static MergeSort mergeSort() {
        return MERGE_SORT;
    }

    public static HeapSort heapSort() {
        return HEAP_SORT;
    }

    public static SinglePivotQuickSort singlePivotQuickSort() {
        return SINGLE_PIVOT_QUICK_SORT;
    }

    public static DualPivotQuickSort dualPivotQuickSort() {
        return DUAL_PIVOT_QUICK_SORT;
    }

    public static List<SortingAlgorithm> all() {
        return List.of(
            BUBBLE_SORT,
            INSERTION_SORT,
            SELECTION_SORT,
            HEAP_SORT,
            MERGE_SORT,
            SINGLE_PIVOT_QUICK_SORT,
            DUAL_PIVOT_QUICK_SORT
        );
    }
}
