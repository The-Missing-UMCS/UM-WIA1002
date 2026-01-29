package com.umwia1002.solution.lab.version1.lab05.l5q1.SList;

import java.util.NoSuchElementException;

public class SList<E> {

    SNode<E> head;
    SNode<E> tail;
    int size;

    public void appendEnd(E e) {
        SNode<E> newNode = new SNode<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeInitial() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E elem = head.element;

        if (head.equals(tail)) {
            head = tail = null;
        } else {
            head = head.next;
        }

        size--;
        return elem;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public void clear() {
        for (SNode<E> slow = head; slow != null; ) {
            SNode<E> fast = slow.next;
            slow.element = null;
            slow.next = null;
            slow = fast;
        }
        head = tail = null;
        size = 0;
    }

    public void display() {
        System.out.print("[");
        SNode<E> node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.element + ((i == size - 1) ? "" : ", "));
            node = node.next;
        }
        System.out.println("]");
    }

    private int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (SNode<E> node = head; node != null; node = node.next) {
                if (node.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (SNode<E> node = head; node != null; node = node.next) {
                if (node.element.equals(e)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    private static class SNode<E> {

        E element;
        SNode<E> next;

        public SNode(E element) {
            this(element, null);
        }

        public SNode(E element, SNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }


}
