package com.umwia1002.solution.pastyear.py2017s2.Q3;

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
