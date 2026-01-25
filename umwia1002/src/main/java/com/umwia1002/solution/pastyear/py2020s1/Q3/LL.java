package com.umwia1002.solution.pastyear.py2020s1.Q3;

public class LL {
    Node head;
    Node tail;
    int size;
    LL() { }

    public boolean isEmpty() {
        return size == 0;
    }

    public void createNode(String title, int sold) {
        Node newNode = new Node(title, sold, head);
        if(tail == null) {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void addAfter(String match, String title, int sold) {
        Node target = head;
        int i = 1;
        while(target != null) {
            if(target.title.equals(match))
                break;
            target = target.next;
            i++;
        }
        System.out.printf("Adding %s after %s\n", title, match);
        System.out.printf("Found %s which is book number %s in the linked list\n", match, i);


        if(target == null) { 
            System.out.println("No match is found!");
            return ;
        }

        Node newNode = new Node(title, sold, target.next);
        target.next = newNode;
        size++;

        display();
    }

    public boolean removeNode(String match) {
        if(isEmpty()) return false;

        System.out.println("Removing " + match);
        Node parent = head; 
        Node node = head;
        int index = 1;

        while(node != null && !node.title.equals(match)) {
            parent = node;
            node = node.next;
            index++;
        }

        if(node == head) {
            if(node == tail) // If the list contains only one node
                tail = null;
            head = head.next;
            System.out.printf("%s is the first book. Removing %s from the linked list\n", match, match);
            return true;
        }

        if(node == null) {
            System.out.println("Couldn't find bookname..\n"); // If the list doesn't contain the specific node
            return false;
        }
        
        System.out.printf("Found %s which is book number %s in the linked list\n", match, index);
        parent.next = parent.next.next;

        if(node == tail) // If the removed node is the tail node
            tail = parent;

        size--;
        return true;
    }

    public void display() {
        System.out.println("\nDisplaying the Linked List " + "*".repeat(20) + "\n");
        for(Node node = head; node != null; node = node.next) {
            System.out.println(node);
        }
        System.out.println();
    }

    static class Node {
        String title;
        int sold;
        Node next;

        Node(String title, int sold, Node next) {
            this.title = title;
            this.sold = sold * 1_000_000;
            this.next = next;
        }

        public String toString() {
            return String.format("%s: %,d Sold", title, sold);
        }
    }
}
