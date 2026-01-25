package com.umwia1002.solution.pastyear.py2016q2;

public class q3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 10; i <= 90; i += 10) {
            queue.enqueue(i);
        }

        System.out.println("Before changing the order = " + queue);
        queue.changeOrder(4);
        System.out.println("After changing the order  = " + queue);
    }

    static class Queue<E> {
        Node<E> head;
        Node<E> tail;
        int size;

        public void changeOrder(int k) {
            if (k - 1 >= size) {
                return;
            }
            for (int i = 0; i < k - 1; i++) {
                enqueue(dequeue());
            }
        }

        public E dequeue() {
            if (head == null) {
                return null;
            }
            E item = head.item;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return item;
        }

        public void enqueue(E item) {
            Node<E> newNode = new Node<>(item, null);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public E peek() {
            return head == null ? null : head.item;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (head == null) {
                return "[]";
            }

            sb.append('[');
            for (Node<E> node = head; node != null; node = node.next) {
                sb.append(node.item);
                if (node.next != null) {
                    sb.append(',').append(' ');
                }
            }
            return sb.append(']').toString();
        }

        static class Node<E> {
            E item;
            Node<E> next;

            Node(E item, Node<E> next) {
                this.item = item;
                this.next = next;
            }
        }
    }
}
