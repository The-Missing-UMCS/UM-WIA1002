package com.umwia1002.solution.lab.version2.lab8.Q3;

public class DualPivotQuickSort extends Sorting {

    public DualPivotQuickSort() {
        super("Dual Pivot Quick Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length, low = 0, high = n - 1;
        int[] stack = new int[n];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;

        while (top >= 0) {
            high = stack[top--];
            low = stack[top--];

            int[] pivot = partition(arr, low, high);

            if (pivot[0] - 1 > low) {
                stack[++top] = low;
                stack[++top] = pivot[0] - 1;
            }

            if (pivot[0] + 1 < pivot[1] - 1) {
                stack[++top] = pivot[0] + 1;
                stack[++top] = pivot[1] - 1;
            }

            if (pivot[1] + 1 < high) {
                stack[++top] = pivot[1] + 1;
                stack[++top] = high;
            }
        }
    }

    public int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high])
            swap(arr, low, high);

        // p is the left pivot, and q
        // is the right pivot.
        int leftPos = low + 1, rightPos = high - 1,
                leftPivot = arr[low], rightPivot = arr[high];

        for (int index = low + 1; index <= rightPos; index++) {
            if (arr[index] < leftPivot) {
                swap(arr, index, leftPos);
                leftPos++;
            } else if (arr[index] >= rightPivot) {
                while (arr[rightPos] > rightPivot && index < rightPos)
                    rightPos--;

                swap(arr, index, rightPos);
                rightPos--;

                if (arr[index] < leftPivot) {
                    swap(arr, index, leftPos);
                    leftPos++;
                }
            }
        }
        leftPos--;
        rightPos++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, leftPos);
        swap(arr, high, rightPos);

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { leftPos, rightPos };
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        DualPivotQuickSort sort = new DualPivotQuickSort();
        int[] arr = new int[] { 2, 1, 7, 4 };
        sort.sort(arr);
        for (int i : arr)
            System.out.println(i);
    }
}
