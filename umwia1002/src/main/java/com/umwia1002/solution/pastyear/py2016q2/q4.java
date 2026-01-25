package com.umwia1002.solution.pastyear.py2016q2;

public class q4 {
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();

        for (int i = 10; i <= 50; i += 10) {
            sl.add(i);
            System.out.printf("Adding: %d", i);
        }

        for (int i = 10; i <= 50; i += 10) {
            boolean success = sl.addAfter(i + 1, i);
            System.out.printf("Add %d After %d, result=%b%n", i + 1, i, success);
        }

        System.out.printf("%nShowing content of my linked list: %s%n", sl.traverse());

        for (int i = 0; i < 2; i++) {
            Integer removed = sl.deleteFront();
            if (removed != null) {
                System.out.printf("Deleting front: %d%n", removed);
            } else {
                System.out.printf("The list is empty.%n");
            }
        }

        System.out.printf("%nShowing content of my linked list: %s%n", sl.traverse());

        int[] deletion = {40, 40, 31, 40};
        for (int val : deletion) {
            Integer removed = sl.deleteAfter(val);
            if (removed != null) {
                System.out.printf("After %d is %d. Deleted %d%n", val, removed, removed);
            } else {
                System.out.printf("Element (%d) not found...%n", val);
            }
        }

        sl.traverse();
    }


    static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void add(int val) {
            Node newNode = new Node(val, null);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public boolean addAfter(int val, int k) {
            Node prev = node(k);
            if (prev == null) {
                return false;
            }
            prev.next = new Node(val, prev.next);
            size++;
            return true;
        }

        public Integer deleteFront() {
            if (head == null) {
                return null;
            }
            int removed = head.val;
            head = head.next;
            size--;
            return removed;
        }

        public Integer deleteAfter(int val) {
            Node node = node(val);
            if (node == null || node.next == null) {
                return null;
            }
            int removed = node.next.val;
            node.next = node.next.next;
            size--;
            return removed;
        }

        public String traverse() {
            if (size == 0) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Node node = head; node != null; node = node.next) {
                sb.append(node.val);
                if (node.next != null) {
                    sb.append(',').append(' ');
                }
            }
            return sb.append(']').toString();
        }

        private Node node(int val) {
            for (Node node = head; node != null; node = node.next) {
                if (node.val == val) {
                    return node;
                }
            }
            return null;
        }
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