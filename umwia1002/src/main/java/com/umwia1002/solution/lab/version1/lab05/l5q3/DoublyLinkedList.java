package com.umwia1002.solution.lab.version1.lab05.l5q3;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    private static class Node<E> {

        Node<E> prev;
        Node<E> next;
        E item;

        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(null, e, head);
        Node<E> next = head;
        head = newNode;

        if (tail == null) {
            tail = newNode;
        } else {
            next.prev = newNode;
        }

        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(tail, e, null);
        Node<E> last = tail;

        if (head == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(prevNode, e, nextNode);
            nextNode.prev = newNode;
            prevNode.next = newNode;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E item = head.item;
        Node<E> next = head.next;
        head.item = null;
        head.next = null; // Helps GC
        head = next;

        if (head == null) {
            tail = null;
        } else {
            next.prev = null;
        }

        size--;
        return item;
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        E item = tail.item;
        Node<E> prev = tail.prev;
        tail.item = null;
        tail.prev = null; // Helps GC
        tail = prev;

        if (tail == null) {
            head = null;
        } else {
            prev.next = null;
        }

        size--;
        return item;
    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> node = node(index);

        E item = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            // If remove the head
            head = next;
        } else {
            prev.next = next;
            // If previousNode != null, set it to null to help GC
            node.prev = null;
        }

        if (next == null) {
            // If remove the tail
            tail = prev;
        } else {
            next.prev = prev;
            // If nextNode != null, set it to null to help GC
            node.next = null;
        }

        node.item = null;
        size--;
        return item;
    }

    public void iterateForward() {
        for (Node<E> node = head; node != null; node = node.next) {
            System.out.print(node.item + " ");
        }
        System.out.println();
    }

    public void iterateBackward() {
        for (Node<E> node = tail; node != null; node = node.prev) {
            System.out.print(node.item + " ");
        }
        System.out.println();
    }

    public void clear() {
        for (Node<E> slow = head; slow != null; ) {
            Node<E> fast = slow.next;
            slow.item = null;
            slow.next = slow.prev = null;
            slow = fast;
        }
        head = tail = null;
        size = 0;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private String outOfBoundMsg(int index) {
        return String.format("Index : %d, Size : %d", index, size);
    }
}
