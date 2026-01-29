package com.umwia1002.solution.lab.version2.lab04.archived.lab6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {

    DoubleListNode<E> head;
    DoubleListNode<E> tail;
    int size;

    public void addFirst(E elem) {
        DoubleListNode<E> node = new DoubleListNode<E>(null, elem, head);
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void addLast(E elem) {
        DoubleListNode<E> node = new DoubleListNode<E>(tail, elem, null);

        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
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

    void linkBefore(E elem, DoubleListNode<E> succ) {
        DoubleListNode<E> pred = succ.prev;
        DoubleListNode<E> newNode = new DoubleListNode<E>(pred, elem, succ);
        succ.prev = newNode;
        if (pred == null) {
            head = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    public E set(int i, E elem) {
        checkElementIndex(i);
        DoubleListNode<E> DoubleListNode = node(i);
        E oldVal = DoubleListNode.element;
        DoubleListNode.element = elem;
        return oldVal;
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
        tail = tail.prev;

        if (tail == null) {
            head = null;
        }
        size--;

        return element;
    }

    public E remove(int i) {
        checkElementIndex(i);
        return unlink(node(i));
    }

    public E remove(E elem) {
        if (elem == null) {
            for (DoubleListNode<E> node = head; node != null; node = node.next) {
                if (node.element == elem) {
                    return unlink(node);
                }
            }
        } else {
            for (DoubleListNode<E> node = head; node != null; node = node.next) {
                if (node.element.equals(elem)) {
                    return unlink(node);
                }
            }
        }

        return null;
    }

    E unlink(DoubleListNode<E> node) {
        E element = node.element;
        DoubleListNode<E> prev = node.prev;
        DoubleListNode<E> next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.element = null;
        size--;
        return element;
    }

    public boolean contains(E elem) {
        return indexOf(elem) >= 0;
    }

    public int indexOf(E elem) {
        int i = 0;
        if (elem == null) {
            for (DoubleListNode<E> node = head; node != null; node = node.next, i++) {
                if (node.element == elem) {
                    return i;
                }
            }
        } else {
            for (DoubleListNode<E> node = head; node != null; node = node.next, i++) {
                if (node.element.equals(elem)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(E elem) {
        int i = 0;
        if (elem == null) {
            for (DoubleListNode<E> node = tail; node != null; node = node.prev, i++) {
                if (node.element == elem) {
                    return i;
                }
            }
        } else {
            for (DoubleListNode<E> node = tail; node != null; node = node.prev, i++) {
                if (node.element.equals(elem)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    public E get(int i) {
        checkElementIndex(i);
        return node(i).element;
    }

    public void clear() {
        for (DoubleListNode<E> node = head; node != null; ) {
            DoubleListNode<E> next = node.next;
            node.element = null;
            node.next = node.prev = null;
            node = next;
        }
        head = tail = null;
    }

    DoubleListNode<E> node(int index) {
        if (index < (size >> 1)) {
            DoubleListNode<E> DoubleListNode = head;
            for (int i = 0; i < index; i++) {
                DoubleListNode = DoubleListNode.next;
            }
            return DoubleListNode;
        } else {
            DoubleListNode<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DoubleListNode<E> node = head; node != null; node = node.next) {
            sb.append(" <-- ").append(node.element).append(" --> ");
        }
        return sb.toString();
    }

    public LinkedListIterator iterator() {
        return new LinkedListIterator(0);
    }

    private boolean isElementIndex(int i) {
        return i >= 0 && i < size;
    }

    private boolean isPositionIndex(int i) {
        return i >= 0 && i <= size;
    }

    private void checkElementIndex(int i) {
        if (!isElementIndex(i)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        }
    }

    private void checkPositionIndex(int i) {
        if (!isPositionIndex(i)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(i));
        }
    }

    private String outOfBoundMsg(int i) {
        return String.format("Index: %d, Size: %d", i, size);
    }

    public class LinkedListIterator implements Iterator<E> {

        private int nextIndex;
        private DoubleListNode<E> next;
        private DoubleListNode<E> lastReturned;

        public LinkedListIterator(int i) {
            this.next = node(i);
            this.nextIndex = i;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

        public void remove() {
            unlink(lastReturned);
            nextIndex--;
            lastReturned = null;
        }
    }
}

