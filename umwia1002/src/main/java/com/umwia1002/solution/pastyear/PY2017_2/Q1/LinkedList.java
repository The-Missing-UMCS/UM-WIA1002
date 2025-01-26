package com.umwia1002.solution.pastyear.PY2017_2.Q1;

public class LinkedList {
    Node head;
    Node tail;
    int size;

    public void insertFirstLink(String name, int sold) {
        Node newNode = new Node(name, sold, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void addAfter(String match, String name, int sold) {
        System.out.printf("\nAdding %s after %s\n", name, match);
        int i = 1;
        for (Node prev = head; prev != null; prev = prev.next, i++) {
            if (prev.name.equals(match)) {
                System.out.printf("Found %s which is handbag number %d in the linked list\n", match, i);
                Node newNode = new Node(name, sold, prev.next);
                prev.next = newNode;
                size++;
                break;
            }
        }
    }

    public void removeLink(String match) {
        System.out.printf("Removing %s..\n", match);
        int i = 1;
        for (Node node = head; node != null; node = node.next, i++) {
            if (node.next != null && node.next.name.equals(match)) {
                System.out.printf("Found a match.. %s is handbag number %d in the linked list\n", match, i);
                node.next = node.next.next;
                size--;
                break;
            }
        }
    }

    public void display() {
        System.out.println("\nDisplaying the Linked List " + "*".repeat(40));
        for(Node node = head; node != null; node = node.next) {
            System.out.println(node);
        }
        System.out.println();
    }

    static class Node {
        String name;
        int sold;
        Node next;

        Node(String name, int sold, Node next) {
            this.name = name;
            this.sold = sold;
            this.next = next;
        }

        public String toString() {
            return name + ": " + String.format("%,d", sold) + " Sold";
        }
    }
}
