package com.umwia1002.solution.pastyear.PY2019_2.Q3;

public class Stack<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        Node<E> newNode = new Node<>(e, head);
        if(tail == null) tail = newNode;
        head = newNode;
        size++;
    }

    public E peek() {
        return head == null ? null : head.elem;
    }

    public E pop() {
        if(head == null) return null;
        E elem = head.elem;
        head = head.next;
        size--;
        return elem;
    }
    
    static class Node<E> {
        E elem;
        Node<E> next;

        Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
