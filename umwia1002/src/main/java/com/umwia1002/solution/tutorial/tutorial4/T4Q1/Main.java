package com.umwia1002.solution.tutorial.tutorial4.T4Q1;

public class Main {
	public static void main(String[] args) {
		// a)
        LinkedList<Character> list = new LinkedList<>();
        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('z');
        list.head = node1;
        list.tail = node2;

        // c)
        node1.next = node2;

        // h)
        list.addLast('c');
        list.add(2, 'd');
        list.remove(1);
	}
}
