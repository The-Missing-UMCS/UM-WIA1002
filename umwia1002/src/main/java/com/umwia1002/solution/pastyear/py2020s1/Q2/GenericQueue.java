package com.umwia1002.solution.pastyear.py2020s1.Q2;

@SuppressWarnings("unchecked")
public class GenericQueue<E> {
    Node<E> head;
    Node<E> tail;
    int size;
    int max;

    GenericQueue() {
        this(15);
    }

    GenericQueue(int max) {
        this.max = max;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public E peek() {
        return head == null ? null : head.elem;
    }

    public void enqueue(E e) {
        if (isFull())
            return;
        Node<E> newNode = new Node<>(e, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        System.out.println("Enqueue: " + e);
    }

    public E dequeue() {
        if (isEmpty())
            return null;
        E elem = head.elem;
        head = head.next;
        size--;
        System.out.println("Dequeue: " + elem);
        return elem;
    }

    public void changeOrder(int k) {
        /*
         * 10 20 30 40 50 60 70 80 90
         *             ^
         *      50 should be the first,
         *      So, 
         *      --> currentTail.next = 10,
         *      --> newHead = 50, 
         *      --> newTail = 40,
         */
        System.out.println("\nChange queue order...");
        Node<E> prev = head;
        for (int i = 1; i < k - 1; i++) {
            prev = prev.next;
        }
        tail.next = head;
        head = prev.next;
        prev.next = null;
        tail = prev;
    }

    public void enqueueMany(String elements) {
        for (String e : elements.split(",")) {
            enqueue((E) e);
        }
    }

    public E[] dequeueAll() {
        System.out.println("\nThere are " + size + " items in the queue. Removing them all...");
        if (isEmpty())
            return null;
        E[] tmp = (E[]) new Object[size];
        int i = 0;
        while (!isEmpty()) {
            tmp[i] = dequeue();
        }
        return tmp;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nNothing to display");
        } else {
            System.out.println("\nThere are " + size + " items in the queue. Displaying...");
            for (Node<E> current = head; current != null; current = current.next) {
                System.out.print(current.elem + " | ");
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
