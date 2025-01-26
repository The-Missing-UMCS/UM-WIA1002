package com.umwia1002.solution.pastyear.PY2017_2.Q3;

public class Node<E> {
    E item;
    Node<E> left;
    Node<E> right;

    Node(E item) {
        this.item = item;
    }

    public String toString() {
        return item.toString();
    }
}
