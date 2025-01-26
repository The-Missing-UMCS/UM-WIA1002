package com.umwia1002.solution.lab.version2.lab4.archieve.lab1;

import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<E extends Comparable<E>> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(null, elem, head);
        if (head != null) head.prev = newNode;
        head = newNode;
        if (tail == null) tail = head;
        size++;
    }

    public void addLast(E elem) {
        Node<E> newNode = new Node<>(tail, elem, null);
        if (tail != null) tail.next = newNode;
        tail = newNode;
        if (head == null) head = tail;
        size++;
    }

    public void add(E elem) {
        addLast(elem);
    }

    public void add(int index, E elem) {
        checkPositionIndex(index);
        if (index == size) {
            addLast(elem);
        } else {
            linkBefore(elem, node(index));
        }
    }

    private void linkBefore(E elem, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, elem, succ);
        succ.prev = newNode;
        if (pred == null) head = newNode;
        else pred.next = newNode;
        size++;
    }

    public E set(int i, E elem) {
        checkElementIndex(i);
        Node<E> node = node(i);
        E oldVal = node.element;
        node.element = elem;
        return oldVal;
    }

    public E removeFirst() {
        checkNotEmpty();
        E elem = head.element;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return elem;
    }

    public E removeLast() {
        checkNotEmpty();
        E elem = tail.element;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return elem;
    }

    public E remove(int i) {
        checkElementIndex(i);

        if (i == 0) {
            return removeFirst();
        } else if (i == size - 1) {
            return removeLast();
        } else {
            Node<E> current = node(i);
            E element = current.element;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return element;
        }
    }

    public boolean contains(E elem) {
        return indexOf(elem) >= 0;
    }

    public int indexOf(E elem) {
        int index = 0;
        for (Node<E> node = head; node != null; node = node.next, index++) {
            if (Objects.equals(node.element, elem)) return index;
        }
        return -1;
    }

    public int lastIndexOf(E elem) {
        int i = 0;
        if (elem == null) {
            for (Node<E> node = tail; node != null; node = node.prev, i++)
                if (node.element == elem)
                    return i;
        } else {
            for (Node<E> node = tail; node != null; node = node.prev, i++) {
                if (node.element.equals(elem))
                    return i;
            }
        }
        return -1;
    }

    public E getFirst() {
        checkNotEmpty();
        return head.element;
    }

    public E getLast() {
        checkNotEmpty();
        return tail.element;
    }

    public E get(int i) {
        checkElementIndex(i);
        return node(i).element;
    }

    public void addSorted(E elem) {
        Node<E> current = head;
        while (current != null && current.element.compareTo(elem) < 0) {
            current = current.next;
        }
        if (current == null) addLast(elem);
        else linkBefore(elem, current);
    }

    public void clear() {
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            current.prev = current.next = null;
            current.element = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    private Node<E> node(int index) {
        checkElementIndex(index);
        Node<E> node;
        if (index < (size >> 1)) {
            node = head;
            for (int i = 0; i < index; i++) node = node.next;
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) node = node.prev;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<E> node = head; node != null; node = node.next) {
            sb.append(node.element).append("--> ");
        }
        return sb.toString();
    }

    private boolean isElementIndex(int i) {
        return i >= 0 && i < size;
    }

    private boolean isPositionIndex(int i) {
        return i >= 0 && i <= size;
    }

    private void checkElementIndex(int i) {
        if (!isElementIndex(i))
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
    }

    private void checkPositionIndex(int i) {
        if (!isPositionIndex(i))
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
    }

    private void checkNotEmpty() {
        if (size == 0) throw new NoSuchElementException("List is empty");
    }

    private String outOfBoundMsg(int i) {
        return String.format("Index: %d, Size: %d", i, size);
    }

    private static class Node<E extends Comparable<E>> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }
}
