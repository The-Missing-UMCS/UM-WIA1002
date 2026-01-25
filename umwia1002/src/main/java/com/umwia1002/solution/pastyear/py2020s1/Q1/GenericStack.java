package com.umwia1002.solution.pastyear.py2020s1.Q1;

@SuppressWarnings("unchecked")
public class GenericStack<E> {
    Node<E> head;
    Node<E> tail;
    private int max;
    int size;

    public GenericStack() {
        this(10);
    }

    public GenericStack(int max) {
        this.max = max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public E peek() {
        return isEmpty() ? null : head.elem;
    }

    public void push(E e) {
        if (isFull()) {
            throw new IllegalStateException("The stacks is full");
        }
        Node<E> newNode = new Node<>(e, head);
        if (tail == null)
            tail = newNode;
        head = newNode;
        size++;
        System.out.println("Push: " + e);
    }

    public void pushMany(String elements) {
        System.out.println("Push many into stacks...");
        for (String e : elements.split(",")) {
            push((E) e);
        }
    }

    public E pop() {
        if (isEmpty())
            return null;
        E elem = head.elem;
        head = head.next;
        size--;
        return elem;
    }

    public E popMiddle() {
        if ((size & 1) != 1) {
            System.out.println("Current count of stacks is even number, so no middle index..");
            return null;
        }

        int middleIndex = (size >> 1);
        Node<E> prev = head;
        for (int i = 0; i < middleIndex - 1; i++) {
            prev = prev.next;
        }
        E elem = prev.next.elem;
        prev.next = prev.next.next;
        size--;
        return elem;
    }

    public E[] popAll() {
        if (isEmpty())
            return null;
        System.out.println("There are " + size + " items in the stacks. Pop all...");
        E[] tmp = (E[]) new Object[size];
        int i = 0;
        while (!isEmpty()) {
            tmp[i] = pop();
            System.out.println("Removing " + tmp[i++] + " ..");
        }
        return tmp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nStack is empty, nothing to display...");
        } else {
            System.out.println("\nThere are " + size + " items in the stacks. Displaying...");
            for (Node<E> current = head; current != null; current = current.next) {
                System.out.println(current.elem);
            }
            System.out.println();
        }
    }

    static class Node<E> {
        E elem;
        Node<E> next;

        Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
