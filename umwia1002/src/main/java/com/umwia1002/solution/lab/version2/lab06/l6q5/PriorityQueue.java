package com.umwia1002.solution.lab.version2.lab06.l6q5;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A priority queue implementation backed by a doubly linked list,
 * which orders its elements according to their natural ordering.
 * The highest element (according to {@code compareTo}) is at the head of the queue.
 *
 * @param <E> the type of elements held in this queue
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    int size;
    Node<E> head;
    Node<E> tail;

    /**
     * Returns (but does not remove) the head element of this queue.
     * For {@code Queue.peek()}, if the queue is empty, {@code null} is returned.
     *
     * @return the head element, or {@code null} if the queue is empty
     */
    @Override
    public E peek() {
        return (head == null) ? null : head.item;
    }

    /**
     * Returns the head element of this queue.
     *
     * @return the head element
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        E item = peek();
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    /**
     * Removes and returns the head element of this queue.
     *
     * @return the head element that was removed
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return unlink(head);
    }

    /**
     * Removes and returns the head element of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head element that was removed, or {@code null} if empty
     */
    @Override
    public E poll() {
        if (head == null) {
            return null;
        }
        return unlink(head);
    }

    /**
     * Inserts the specified element into this priority queue.
     * The element is placed in order so that the highest element (according to {@code compareTo})
     * is at the head.
     *
     * @param e the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        if (head == null) {
            addFirst(e);
        } else {
            // Find the first node where e is greater than the node's item.
            Node<E> node;
            for (node = head; node != null; node = node.next) {
                if (e.compareTo(node.item) > 0) {
                    linkBefore(e, node);
                    return true;
                }
            }
            // If not inserted in the loop, then e is less than or equal to every element;
            // add it at the end.
            addLast(e);
        }
        return true;
    }

    /**
     * Inserts the specified element into this queue.
     * This method is equivalent to {@link #add(Comparable)}.
     *
     * @param e the element to add
     * @return {@code true} if the element was added, else {@code false}
     */
    @Override
    public boolean offer(E e) {
        return add(e);
    }

    /**
     * Inserts the element at the front of the list.
     *
     * @param e the element to add
     */
    void addFirst(E e) {
        Node<E> newNode = new Node<>(null, e, head);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * Inserts the element at the end of the list.
     *
     * @param e the element to add
     */
    void addLast(E e) {
        Node<E> newNode = new Node<>(tail, e, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Inserts the specified element immediately before the specified successor node.
     *
     * @param item the element to insert
     * @param succ the node before which the element should be inserted
     */
    void linkBefore(E item, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, item, succ);
        if (pred == null) {
            head = newNode;
        } else {
            pred.next = newNode;
        }
        succ.prev = newNode;
        size++;
    }

    /**
     * Unlinks (removes) the given node from the list and returns its element.
     *
     * @param node the node to remove
     * @return the element contained in the removed node
     */
    private E unlink(Node<E> node) {
        final E element = node.item;
        final Node<E> next = node.next;
        final Node<E> prev = node.prev;

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
        node.item = null;
        size--;
        return element;
    }

    /**
     * Removes the first occurrence of the specified element from this queue, if it is present.
     *
     * @param o the element to be removed, if present
     * @return {@code true} if the element was removed, {@code false} otherwise
     */
    @Override
    public boolean remove(Object o) {
        for (Node<E> node = head; node != null; node = node.next) {
            if (o == null ? node.item == null : o.equals(node.item)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns {@code true} if this queue contains the specified element.
     *
     * @param o element whose presence in this queue is to be tested
     * @return {@code true} if this queue contains the specified element, {@code false} otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (Node<E> node = head; node != null; node = node.next) {
            if (o == null ? node.item == null : o.equals(node.item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this queue contains no elements.
     *
     * @return {@code true} if empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     *
     * @return an iterator over the elements
     */
    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    /**
     * Returns an array containing all of the elements in this queue in proper order.
     *
     * @return an array of the elements
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> node = head; node != null; node = node.next) {
            result[i++] = node.item;
        }
        return result;
    }

    /**
     * Returns an array containing all of the elements in this queue in proper order;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param a the array into which the elements of the queue are to be stored, if it is big
     * enough;
     * otherwise, a new array of the same runtime type is allocated for this purpose
     * @param <T> the component type of the array to contain the queue
     * @return an array containing all of the elements in this queue
     */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for (Node<E> node = head; node != null; node = node.next) {
            result[i++] = node.item;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Returns {@code true} if this queue contains all of the elements in the specified collection.
     *
     * @param c the collection to be checked for containment in this queue
     * @return {@code true} if this queue contains all of the elements, {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this queue.
     *
     * @param c the collection containing elements to be added to this queue
     * @return {@code true} if the queue changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all of this queue's elements that are also contained in the specified collection.
     *
     * @param c the collection containing elements to be removed from this queue
     * @return {@code true} if the queue changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Retains only the elements in this queue that are contained in the specified collection.
     *
     * @param c the collection containing elements to be retained in this queue
     * @return {@code true} if the queue changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> it = iterator(); it.hasNext(); ) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all of the elements from this queue.
     */
    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = tail = null;
        size = 0;
    }

    /**
     * Returns the (non-null) node at the specified index.
     * Traverses from the head if the index is in the first half,
     * otherwise traverses from the tail.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    Node<E> node(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * Node of a doubly linked list.
     *
     * @param <E> the type of element stored in the node
     */
    static class Node<E extends Comparable<E>> {

        E item;
        Node<E> prev;
        Node<E> next;

        /**
         * Constructs a new node.
         *
         * @param prev the previous node
         * @param item the element stored in this node
         * @param next the next node
         */
        Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    /**
     * An iterator over the elements in this priority queue.
     */
    public class QueueIterator implements Iterator<E> {

        private Node<E> next;
        private Node<E> lastReturned;
        private int nextIndex;

        /**
         * Constructs a new {@code QueueIterator} starting at the head of the queue.
         */
        QueueIterator() {
            next = head;
            nextIndex = 0;
        }

        /**
         * Returns {@code true} if there are more elements in the queue.
         *
         * @return {@code true} if there is another element, {@code false} otherwise
         */
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element
         * @throws NoSuchElementException if there are no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator.
         *
         * @throws IllegalStateException if the {@code next} method has not yet been called, or the
         * {@code remove} method has already been called after the last call to the {@code next}
         * method
         */
        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            PriorityQueue.this.unlink(lastReturned);
            lastReturned = null;
            nextIndex--;
        }
    }
}
