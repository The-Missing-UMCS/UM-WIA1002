package com.umwia1002.solution.lab.version2.lab4.util;

public interface Q1Interface<E extends Comparable<E>> {
    void addSortNode(E elem);

    String toQ1String();
}
