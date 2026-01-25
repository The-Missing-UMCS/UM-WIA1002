package com.umwia1002.solution.pastyear.py2025s2;

public class q1 {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1, new Node<>(10, new Node<>(20, null)));
        Node<Integer> n2 = new Node<>(15, new Node<>(25, new Node<>(55, null)));
        Node<Integer> n3 = merge(n1, n2);

        while (n3 != null) {
            System.out.printf("%d -> ", n3.elem);
            n3 = n3.next;
        }
        System.out.println("null");
    }

    private static <E extends Comparable<E>> Node<E> merge(Node<E> h1, Node<E> h2) {
        Node<E> n1 = h1, n2 = h2, head, curr, next;

        if (n1.elem.compareTo(n2.elem) <= 0) {
            head = curr = n1;
            n1 = n1.next;
        } else {
            head = curr = n2;
            n2 = n2.next;
        }

        for (; n1 != null && n2 != null; curr = curr.next) {
            if (n1.elem.compareTo(n2.elem) <= 0) {
                next = n1.next;
                curr.next = n1;
                n1 = next;
            } else {
                next = n2.next;
                curr.next = n2;
                n2 = next;
            }
        }

        if (n1 != null) {
            curr.next = n1;
        }
        if (n2 != null) {
            curr.next = n2;
        }

        return head;
    }

    static class Node<E> {
        E elem;
        Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
