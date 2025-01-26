package com.umwia1002.solution.lab.version2.lab8.Q1;

import java.util.*;

public abstract class MergeSort {
    MyComparator conditions;

    MergeSort() {
        this(new MyComparator(List.of(Comparator.comparingInt(x -> x))));
    }
    MergeSort(MyComparator conditions) {
        this.conditions = conditions;
    }
    
    public abstract void sort(int[] arr);
}
