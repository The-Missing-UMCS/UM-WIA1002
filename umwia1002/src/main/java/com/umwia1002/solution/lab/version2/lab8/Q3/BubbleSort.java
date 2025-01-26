package com.umwia1002.solution.lab.version2.lab8.Q3;

public class BubbleSort extends Sorting {

    public BubbleSort() {
        super("Bubble Sort");
    }

    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            boolean isSwap = false;
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    isSwap = true;
                    int tmp = arr[j + 1];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }

            if(!isSwap) break;
        }
    }
}
