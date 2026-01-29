package com.umwia1002.solution.lab.version1.lab04;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, head);
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            linkAfter(e, node(index - 1));
        }
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        E element = head.element;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return element;
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        E element = tail.element;

        if (head.equals(tail)) {
            head = tail = null;
        } else {
            Node<E> prev = node(size - 2);
            prev.next = null;
            tail = prev;
        }

        return element;
    }

    public E remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        }

        final Node<E> prev = node(index - 1);
        E element = prev.next.element;
        prev.next = prev.next.next;
        size--;

        return element;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    public E getFirst() {
        final Node<E> h = head;
        if (h == null) {
            throw new NoSuchElementException();
        }
        return h.element;
    }

    public E getLast() {
        final Node<E> t = tail;
        if (t == null) {
            throw new NoSuchElementException();
        }
        return t.element;
    }

    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.element == element) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.element.equals(element)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    public int lastIndexOf(E element) {
        int index = -1;
        int i = 0;
        if (element == null) {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.element == element) {
                    index = i;
                }
                i++;
            }
        } else {
            for (Node<E> node = head; node != null; node = node.next) {
                if (node.element.equals(element)) {
                    index = i;
                }
                i++;
            }
        }

        return index;
    }

    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldVal = node.element;
        node.element = e;
        return oldVal;
    }

    public void clear() {
        for (Node<E> slow = head; slow != null; ) {
            Node<E> fast = slow.next;
            slow.next = null;
            slow.element = null;
            slow = fast;
        }
        head = tail = null;
        size = 0;
    }

    public void reverse() {
        // Credit: https://github.com/samweihong/WIA1002-Data-Structure/
        if (head == null && tail == null) {
            System.out.println("[ ]");
        } else {
            String s = head.element + "";
            for (Node<E> node = head.next; node != null; node = node.next) {
                s = node.element + ", " + s;
            }
            System.out.printf("[%s]\n", s);
        }
    }

    public void print() {
        if (head == null && tail == null) {
            System.out.println("[ ]");
        } else {
            Node<E> node = head;
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(node.element + ((i == size - 1) ? "" : ", "));
                node = node.next;
            }
            System.out.println("]");
        }
    }

    public E getMiddleValue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        return node(size >> 1).element;
    }

    void linkAfter(E e, Node<E> prev) {
        prev.next = new Node<>(e, prev.next);
        size++;
    }


    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Returns the (non-null) Node at the specified element index.
     */
    Node<E> node(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public int size() {
        return this.size;
    }

    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

}