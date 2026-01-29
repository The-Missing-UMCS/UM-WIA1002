package com.umwia1002.solution.lab.version2.lab04.l4q7;

import java.util.NoSuchElementException;

public class CircularLinkedList<E> {

    int length;
    ListNode<E> head;
    ListNode<E> tail;


    public int length() {
        return length;
    }

    public void addCircularNode(E elem) {
        ListNode<E> newNode = new ListNode<E>(elem, head);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
        }
        tail = newNode;
        length++;
    }

    public E deleteCircularNode() {
        if (length == 0) {
            throw new NoSuchElementException("List is empty.");
        }

        E element = tail.element;

        if (length == 1) {
            head = tail = null;
        } else {
            // Helps GC
            ListNode<E> lastNode = tail;
            lastNode.element = null;
            lastNode.next = null;

            ListNode<E> prevToTail = node(length - 2);
            prevToTail.next = head;
            tail = prevToTail;
        }
        length--;
        return element;
    }

    public void displayCircularList() {
        if (length == 0) {
            System.out.println("List is empty.");
            return;
        }
        ListNode<E> current = head;
        for (int i = 0; i < length; i++) {
            System.out.print(current.element + (i < length - 1 ? " --> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public E getCircularItem(int i) {
        if (i < 0 || i >= length) {
            throw new NoSuchElementException();
        }
        return node(i).element;
    }

    ListNode<E> node(int index) {
        ListNode<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    static class ListNode<E> {

        E element;
        ListNode<E> next;

        ListNode(E element, ListNode<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
