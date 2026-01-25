package com.umwia1002.solution.pastyear.py2025s2;

public class q2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abaa"));
    }
    static class Node {
        char ch;
        Node next;
        Node prev;

        public Node(char ch, Node next, Node prev) {
            this.ch = ch;
            this.next = next;
            this.prev = prev;
        }
    }

    private static boolean isPalindrome(String s) {
        Node head = null, tail = null;

        // 1. Forming a linked list
        char[] chars = s.toCharArray();
        for(char ch : chars) {
            Node newNode = new Node(ch, null, tail);
            if(head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // 2. Check if is palindrome
        for(int i = 0; i < chars.length >> 1; i++) {
            if(head.ch != tail.ch) {
                return false;
            }
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }
}
