package com.umwia1002.solution.labtest.LabTest2.Thursday.Q1;

public class DArbyStack<DArby> {
    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }

    private Node<DArby> head = null;
    private int size = 0;

    public void push(DArby o) {
        Node<DArby> newNode = new Node<>(o);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public DArby pop() {
        if(head == null)
            return null;
        DArby item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public DArby peek() {
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
        if(head == null)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(reverseString(head));
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }

    public String reverseString(Node<DArby> node) {
        if(node == null) {
           return "";
        }
        return reverseString(node.next) + node.item + ", ";
    }

    public DArby remove(int k) {
        if(k <= 0 || k > size) {
            return null;
        }

        if(k == 1) {
            return pop();
        } else {
            Node<DArby> node = head;
            for(int i = 0; i < k - 2; i++) {
                node = node.next;
            }
            DArby item = node.next.item;
            node.next = node.next.next;
            size--;
            return item;
        }
    }

    public void print() {
        for(Node<DArby> node = head; node != null; node = node.next) {
            System.out.println("Value = " + node.item);
        }
    }

}
