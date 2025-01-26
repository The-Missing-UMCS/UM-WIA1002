package com.umwia1002.solution.pastyear.PY2019_2.Q1;

public class MyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head);
        if(tail == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if(head == null) {
            return null;
        }
        E elem = head.elem;
        head = head.next;
        size--;
        return elem;
    }

    public String toString() {
        if(size == 0) {
            return "[size=0]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[size=%d] >> ", size));
        for(Node<E> current = head; current != null; current = current.next) {
            sb.append(current.elem);
            if(current.next != null)
                sb.append(" >> ");
        }
        return sb.toString();
    }
}
