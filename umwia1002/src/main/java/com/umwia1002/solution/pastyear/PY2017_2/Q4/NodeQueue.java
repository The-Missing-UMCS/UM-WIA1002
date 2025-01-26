package com.umwia1002.solution.pastyear.PY2017_2.Q4;

public class NodeQueue<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    NodeQueue(E[] items) {
        for(E item : items) {
            enqueue(item);
        }
    }

    NodeQueue() {

    }

    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e, null);
        if(head == null) {
            head = newNode; 
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public E dequeue() {
        if(isEmpty()) return null;
        E elem = head.elem;
        head = head.next;
        return elem;
    }

    public E getElement(int i) {
        if(i < 0 || i >= size) return null;
        Node<E> node = head;
        for(int k = 0; k < i; k++) {
            node = node.next;
        }
        return node.elem;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> current = head;
        for(int i = 0; i < size; i++) {
            sb.append(current.elem);
            if(i < size - 1){
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }

    static class Node<E> {
        E elem;
        Node<E> next;

        Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }
}
