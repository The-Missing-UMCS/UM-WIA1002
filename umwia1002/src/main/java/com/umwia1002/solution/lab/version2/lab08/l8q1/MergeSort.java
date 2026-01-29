package com.umwia1002.solution.lab.version2.lab08.l8q1;

import java.util.Comparator;
import java.util.List;

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
