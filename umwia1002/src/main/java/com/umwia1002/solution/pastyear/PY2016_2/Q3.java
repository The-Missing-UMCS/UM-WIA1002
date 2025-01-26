package com.umwia1002.solution.pastyear.PY2016_2;

public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for(int i = 10; i <= 90; i += 10) {
            queue.enqueue(i);
        }

        System.out.println("Before changing the order = " + queue);
        queue.changeOrder(4);
        System.out.println("After changing the order  = " + queue);
    }
}

class Queue<Item> {
    Node<Item> head;
    Node<Item> tail;
    int size;

    Queue() {

    }

    public void changeOrder(int k) {
        if(k - 1 >= size) {
            return;
        }
        for(int i = 0; i < k - 1; i++) {
            enqueue(dequeue());
        }
    }

    public Item dequeue() {
        if(head == null) {
            return null;
        }
        Item item = head.item;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        size--;
        return item;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>(item, null);
        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public Item peek() {
        return head == null ? null : head.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    static class Node<Item> {
        Item item;
        Node<Item> next;

        Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(head == null) {
            return "[]";
        }

        sb.append('[');
        for(Node<Item> node = head; node != null; node = node.next) {
            sb.append(node.item);
            if(node.next != null) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }
}
