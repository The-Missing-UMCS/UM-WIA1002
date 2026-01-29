package com.umwia1002.solution.tutorial.tutorial04.t4q1;

import java.util.NoSuchElementException;

public class LinkedList<E> {

    Node<E> head;
    Node<E> tail;
    int size;

    public void addFirst(E item) {
//      e)
//      Condition to consider:
//      Whether the list contains any node.
//      If it doesn't, the tail should be set to this new node.
//
//      f)
//      Set the next of this firstNode to the current head.
//      Set the head to this firstNode.
//
//      g)
        Node<E> newNode = new Node<>(item, head);
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addLast(E item) {
//      e)
//      Condition to consider:
//      Whether the list contains any node.
//      If it doesn't, the head should be set to this new node.
//
//      f)
//      Set the next of the tail to the newNode
//
//      g)
        Node<E> newNode = new Node<>(item, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(E item) {
        addLast(item);
    }

    public void add(int index, E item) {
//		e)
//		Condition to consider:
//		Throw an exception when index < 0 || index > size
//		Add the node otherwise

//		f)
//		If index equals 0, invoke addFirst() method
//		If index equals the size of the list, invoke the addLast() method
//		Otherwise, search for the (index - 1) th node assign it to the prev
//		Add the newNode next to the prev
//		Set the next of the newNode to the node after the prev
//		Increment the size of the list by 1
//		
//		g)
        checkPositionIndex(index);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(item, prev.next);
            size++;
        }
    }

    public E removeFirst() {
//		e) 
//		Condition to consider:
//		If the list has no node, throw NoSuchElementException
//		If the list has only one node, set both head and tail to null.
//
//		f)
//		Set the head to the node after the current head
//		Return the item of the initial head
//		
//		g)
        if (head == null) {
            throw new NoSuchElementException();
        }
        E elem = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return elem;
    }

    public E removeLast() {
//      e)
//      Condition to consider:
//		If the list has no node, throw NoSuchElementException
//		If the list has only one node, set both head and tail to null.
//
//      f)
//      Assign the node before the tail to prev.
//      Set the next of the prev to null.
//      Return the item of the initial tail.
//
//      g)
        E elem = tail.item;
        if (head.next == null) {
            head = tail = null;
        } else {
            Node<E> prev = node(size - 2);
            prev.next = null;
            tail = prev;
            size--;
        }
        return elem;
    }

    public E remove(int index) {
//      e)
//      Condition to consider:
//      Throw IndexOutOfBoundsException when index < 0 || index > size - 1
//
//      f)
//      If the index is 0, invoke the removeFirst method.
//      Otherwise, search for (index-1)th node and assign it to current.
//      Set the next of the current to the node after the next of the current.
//      Return the item of the node after the initial current.
//
//      g)
        checkElementIndex(index);
        if (index == 0) {
            return removeFirst();
        } else {
            Node<E> prev = node(index - 1);
            E elem = prev.next.item;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
            return elem;
        }
    }

    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }

    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.item;
    }

    public E getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.item;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    Node<E> node(int index) {
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    int indexOf(E item) {
        int index = 0;
        for (Node<E> node = head; node != null; node = node.next) {
            if (node.item.equals(item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    private String outOfBoundMsg(int index) {
        return String.format("Index: %d, Size: %d", index, size);
    }
}
