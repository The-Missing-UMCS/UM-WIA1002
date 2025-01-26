package com.umwia1002.solution.lab.version2.lab8.Q3;

public abstract class Sorting {
    public final String NAME;

    Sorting(String name) {
        this.NAME = name;
    }
    
    public abstract void sort(int[] arr);
}
