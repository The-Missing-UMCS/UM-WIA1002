package com.umwia1002.solution.lab.version2.lab4.util;

import java.util.*;

/**
 * A generic doubly-linked list implementation that implements the List interface.
 *
 * @param <E> the type of elements stored in the LinkedList.
 */
public class LinkedList<E extends Comparable<E>>
    implements List<E>, Q1Interface<E>, Q2Interface<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public boolean add(E elem) {
        linkLast(elem);
        return true;
    }

    @Override
    public void addSortNode(E elem) {
        Node<E> current = head;
        while (current != null && current.element.compareTo(elem) < 0) {
            current = current.next;
        }

        // If the element is greater than all elements in the list
        if (current == null) {
            linkLast(elem);
        } else {
            linkBefore(elem, current);
        }
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == 0) {
            linkFirst(element);
        } else if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    public void addFirst(E elem) {
        linkFirst(elem);
    }

    public void addLast(E elem) {
        linkLast(elem);
    }

    private void linkFirst(E element) {
        Node<E> newNode = new Node<>(element, null, head);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    private void linkLast(E element) {
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    private void linkBefore(E element, Node<E> successor) {
        Node<E> predecessor = successor.prev;
        Node<E> newNode = new Node<>(element, predecessor, successor);
        successor.prev = newNode;

        // If the successor is the head of the list
        // it will be an addFirst operation
        if (predecessor == null) {
            head = newNode;
        } else {
            predecessor.next = newNode;
        }
        size++;
    }

    @Override
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public boolean remove(Object obj) {
        for (Node<E> current = head; current != null; current = current.next) {
            if (Objects.equals(current.element, obj)) {
                unlink(current);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        checkNotEmpty();
        return unlinkFirst(head);
    }

    public E removeLast() {
        checkNotEmpty();
        return unlinkLast(tail);
    }

    private E unlinkFirst(Node<E> first) {
        final E element = first.element;
        final Node<E> next = first.next;
        first.element = null; // help GC
        first.next = null; // help GC
        head = next;

        // If the list has only one node, and it is removed,
        // then tail should be null as well
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return element;
    }

    private E unlinkLast(Node<E> last) {
        final E element = last.element;
        final Node<E> prev = last.prev;
        last.element = null; // help GC
        last.prev = null; // help GC
        tail = prev;

        // If the list has only one node, and it is removed,
        // then head should be null as well
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        return element;
    }

    private E unlink(Node<E> node) {
        E element = node.element;
        Node<E> next = node.next;
        Node<E> prev = node.prev;

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

        node.element = null; // help GC
        size--;
        return element;
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).element;
    }

    public E getFirst() {
        checkNotEmpty();
        return head.element;
    }

    public E getLast() {
        checkNotEmpty();
        return tail.element;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int indexOf(Object obj) {
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next, index++) {
            if (Objects.equals(current.element, obj)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        int index = size - 1;
        for (Node<E> current = tail; current != null; current = current.prev, index--) {
            if (Objects.equals(current.element, obj)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0); // Default to start at the beginning of the list
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index); // Ensure index is valid

        return new ListIterator<>() {
            private Node<E> next = (index == size) ? null : node(index); // Start from the given index
            private Node<E> lastReturned = null; // Tracks the last accessed element
            private int nextIndex = index; // Tracks the index of the next element

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
                E element = next.element;
                next = next.next;
                nextIndex++;
                return element;
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                next = (next == null) ? tail : next.prev; // Move backward
                lastReturned = next;
                nextIndex--;
                return next.element;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }
                Node<E> lastNext = lastReturned.next; // Save reference for continuity
                unlink(lastReturned);
                if (next == lastReturned) {
                    next = lastNext; // Adjust `next` if it pointed to the removed node
                } else {
                    nextIndex--;
                }
                lastReturned = null;
            }

            @Override
            public void set(E e) {
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }
                lastReturned.element = e; // Update the element of the last accessed node
            }

            @Override
            public void add(E e) {
                lastReturned = null;
                if (next == null) { // If adding at the end
                    linkLast(e);
                } else { // Add before `next`
                    linkBefore(e, next);
                }
                nextIndex++;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (Node<E> current = head; current != null; ) {
            Node<E> next = current.next;
            current.element = null;
            current.prev = current.next = null;
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

    public List<List<E>> splitList() {
        return splitList(2);
    }

    @Override
    public List<List<E>> splitList(int n) {
        checkSplitSize(n);
        List<List<E>> splitLists = initializeLists(n);

        int subSize = size / n;
        int extra = size % n;
        Node<E> current = head;

        for (int listIndex = 0; listIndex < n; listIndex++) {
            int count = subSize + (extra-- > 0 ? 1 : 0);
            List<E> currentList = splitLists.get(listIndex);

            for (int j = 0; j < count && current != null; j++) {
                currentList.add(current.element);
                current = current.next;
            }
        }

        return splitLists;
    }

    public List<List<E>> alternateList() {
        return alternateList(2);
    }

    @Override
    public List<List<E>> alternateList(int n) {
        checkSplitSize(n);

        List<List<E>> alternateLists = initializeLists(n);

        int listIndex = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            alternateLists.get(listIndex).add(current.element);
            listIndex = (listIndex + 1) % n;
        }

        return alternateLists;
    }

    @Override
    public List<E> mergeList(List<List<E>> lists) {
        LinkedList<E> merged = new LinkedList<>();

        for (List<E> list : lists) {
            merged.addAll(list);
        }

        return merged;
    }

    @Override
    public List<E> mergeAlternateList(List<List<E>> lists) {
        Objects.requireNonNull(lists, "Lists cannot be null");
        LinkedList<E> merged = new LinkedList<>();

        List<Iterator<E>> iterators = new ArrayList<>();
        for (List<E> list : lists) {
            iterators.add(list.iterator());
        }

        boolean hasMoreElements = true;
        while (hasMoreElements) {
            hasMoreElements = false; // Assume no more elements to merge
            for (Iterator<E> iterator : iterators) {
                if (iterator.hasNext()) {
                    merged.addLast(iterator.next());
                    hasMoreElements = true; // Found at least one more element
                }
            }
        }

        return merged;
    }

    public void reverse() {
        head = reverse(head);
    }

    Node<E> reverse(Node<E> node) {
        if (node == null) {
            return null; // This will be new head
        } else {
            Node<E> tmp = node.next;
            node.next = node.prev;
            node.prev = tmp;

            if (node.prev == null)
                return node;

            return reverse(node.prev);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<E> current = head; current != null; current = current.next) {
            sb.append(current.element);
            if (current.next != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    @Override
    public String toQ1String() {
        StringBuilder sb = new StringBuilder();
        for (Node<E> node = head; node != null; node = node.next) {
            sb.append(node.element).append("--> ");
        }
        return sb.toString();
    }

    @Override
    public String toQ2String() {
        return toQ1String();
    }

    private List<List<E>> initializeLists(int n) {
        List<List<E>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new LinkedList<>());
        }
        return lists;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkNotEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("The list is empty.");
        }
    }

    private void checkSplitSize(int n) {
        if (n > size) {
            throw new IllegalArgumentException("Number of splits (%d) exceeds list size (%d).".formatted(n, size));
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> next = head;
            private Node<E> lastReturned;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                E element = next.element;
                next = next.next;
                return element;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException();
                }
                unlink(lastReturned);
                lastReturned = null;
            }
        };
    }

    // Unsupported operations for brevity
    @Override
    public boolean addAll(Collection<? extends E> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        for (E element : c) {
            add(element);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        checkPositionIndex(index);

        Node<E> currentNode = (index == size) ? null : node(index);
        Node<E> prevNode = (index == 0) ? null : (currentNode != null ? currentNode.prev : tail);

        for (E element : c) {
            if (prevNode == null) { // Inserting at the start of the list
                linkFirst(element);
                prevNode = head;
            } else if (currentNode == null) {
                linkLast(element);
                prevNode = tail;
            } else {
                linkBefore(element, currentNode);
                prevNode = prevNode.next;
            }
        }

        return !c.isEmpty();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        boolean modified = false;
        for (Node<E> current = head; current != null; ) {
            Node<E> next = current.next;
            if (!c.contains(current.element)) {
                unlink(current);
                modified = true;
            }
            current = next;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        boolean modified = false;
        for (Node<E> current = head; current != null; ) {
            Node<E> next = current.next;
            if (c.contains(current.element)) {
                unlink(current);
                modified = true;
            }
            current = next;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c, "Collection cannot be null");
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        checkPositionIndex(fromIndex);
        checkPositionIndex(toIndex);
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        }

        LinkedList<E> subList = new LinkedList<>();
        Node<E> current = node(fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.element);
            current = current.next;
        }
        return subList;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            array[i++] = current.element;
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }

        int i = 0;
        Object[] result = a;
        for (Node<E> current = head; current != null; current = current.next) {
            result[i++] = current.element;
        }

        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Node class representing elements in the LinkedList.
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
