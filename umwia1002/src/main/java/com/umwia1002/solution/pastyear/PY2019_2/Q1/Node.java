package com.umwia1002.solution.pastyear.PY2019_2.Q1;

public class Node<E> {
    E elem;
    Node<E> next;

    Node(E elem, Node<E> next) {
        this.elem = elem;
        this.next = next;
    }
    
}