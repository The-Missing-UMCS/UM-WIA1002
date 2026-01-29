package com.umwia1002.solution.lab.version1.lab07.lab7b.l7bQ1.queue;

public interface Queue<E> {

    String toString();

    E poll();

    void add(E o);

    Object[] toArray();

    E peek();

    boolean contains(E o);

    int size();

    boolean isEmpty();
}
