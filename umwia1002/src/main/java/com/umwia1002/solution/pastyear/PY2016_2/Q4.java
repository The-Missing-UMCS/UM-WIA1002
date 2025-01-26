package com.umwia1002.solution.pastyear.PY2016_2;

import java.util.NoSuchElementException;

public class Q4 {
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(40);
        sl.add(50);

        sl.addAfter(11, 10);
        sl.addAfter(21, 20);
        sl.addAfter(31, 30);
        sl.addAfter(41, 40);
        sl.addAfter(51, 50);

        sl.traverse();
        sl.deleteFront();
        sl.deleteFront();
        sl.traverse();
        sl.deleteAfter(40);
        sl.deleteAfter(40);
        sl.deleteAfter(31);
        sl.deleteAfter(40);
        sl.traverse();
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public void add(int val) {
        Node newNode = new Node(val, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        System.out.println("Adding: " + val);
    }

    public boolean addAfter(int val, int k) {
        Node prev = node(k);
        Node newNode = new Node(val, prev.next);
        prev.next = newNode;
        size++;
        return true;
    }

    public void deleteFront() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nDeleting front: " + head.val);
        head = head.next;
        size--;
    }

    public void deleteAfter(int val) {
        Node node = node(val);
        System.out.println("\nTesting deleteAfter:");
        if (node == null || node.next == null) {
            System.out.printf("Element (%d) not found...\n", val);
            return;
        }
        System.out.printf("After %d is %d. Deleting %d\n", node.val, node.next.val, node.next.val);
        node.next = node.next.next;
        size--;
    }

    public void traverse() {
        System.out.println("\nShowing content of my linked list:");
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.val + " ");
        }
        System.out.println();
    }

    private Node node(int val) {
        for (Node node = head; node != null; node = node.next) {
            if (node.val == val) {
                return node;
            }
        }
        return null;
    }

    static class Node {
        int val;
        Node next;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

}
