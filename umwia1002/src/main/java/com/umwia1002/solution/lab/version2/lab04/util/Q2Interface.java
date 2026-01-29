package com.umwia1002.solution.lab.version2.lab04.util;

import java.util.List;

public interface Q2Interface<E extends Comparable<E>> {

    List<List<E>> splitList(int n);

    List<List<E>> alternateList(int n);

    List<E> mergeList(List<List<E>> lists);

    List<E> mergeAlternateList(List<List<E>> lists);

    void reverse();

    String toQ2String();
}
