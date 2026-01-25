package com.umwia1002.solution.pastyear.py2023s2.Q6;

public class BSTToCDLL {
    ListNode head = null;
    ListNode tail = null;

    public void bstToCdll(TreeNode root) {
        if (root == null)
            return;

        bstToCdll(root.left);

        ListNode newNode = new ListNode(root.value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        bstToCdll(root.right);
    }

    public void makeCircular() {
        if (head == null)
            return;
        head.prev = tail;
        tail.next = head;
    }

    public void printCircularDll() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

class ListNode {
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int value) {
        this(value, null, null);
    }

    ListNode(int value, ListNode prev, ListNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}