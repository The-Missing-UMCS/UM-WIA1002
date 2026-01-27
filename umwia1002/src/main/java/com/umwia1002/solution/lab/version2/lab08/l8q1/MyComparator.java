package com.umwia1002.solution.lab.version2.lab08.l8q1;

import java.util.*;

public class MyComparator {
    List<Comparator<Integer>> pipeline;

    public MyComparator(List<Comparator<Integer>> pipeline) {
        this.pipeline = pipeline;
    }

    public int compare(int n1, int n2) {
        int diff = 0;
        for(Comparator<Integer> comparator : pipeline) {
            if((diff = comparator.compare(n1, n2)) != 0) {
                return diff;
            }
        }
        return 0;
    }
}
