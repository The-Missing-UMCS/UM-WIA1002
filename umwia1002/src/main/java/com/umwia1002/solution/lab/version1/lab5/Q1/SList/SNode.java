package com.umwia1002.solution.lab.version1.lab5.Q1.SList;

public class SNode<E> {
    E element;
    SNode<E> next;

    public SNode() {
        this(null, null);
    }

    public SNode(E element) {
        this(element, null);
    }

    public SNode(E element, SNode<E> next) {
        this.element = element;
        this.next = next;
    }

}
