package com.umwia1002.solution.lab.version1.lab05.l5q2;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public void add(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void removeElement(E e) {
        checkIfElementExist(e);

        int index = indexOf(e);
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> prev = node(index - 1);
            prev.next = prev.next.next;
            size--;
        }
    }

    private void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    private void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        if (head.equals(tail)) {
            head = tail = null;
        } else {
            Node<E> newLastNode = node(size - 2);
            newLastNode.next = null;
            tail = newLastNode;
        }

        size--;
    }

    public void printList() {
        for (Node<E> node = head; node != null; node = node.next) {
            System.out.print(node.item + ((node.equals(tail)) ? ".\n" : ", "));
        }
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public void replace(E e, E newE) {
        checkIfElementExist(e);
        Node<E> node = node(indexOf(e));
        node.item = newE;
    }

    private int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.item == e) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.item.equals(e)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    private void checkIfElementExist(E e) {
        if (indexOf(e) < 0) {
            throw new NoSuchElementException();
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index out of bound.");
        }
    }

    private Node<E> node(int index) {
        checkElementIndex(index);
        Node<E> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    private static class Node<E> {

        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (!(o.getClass() == Node.class)) {
                return false;
            }

            @SuppressWarnings("unchecked")
            Node<E> node = (Node<E>) o;
            return this.item.equals(node.item) && this.next.equals(node.next);
        }
    }
}
