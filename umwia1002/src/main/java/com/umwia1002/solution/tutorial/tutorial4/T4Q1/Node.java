package com.umwia1002.solution.tutorial.tutorial4.T4Q1;

public class Node<E> {
	E item;
	Node<E> next;

	Node(E item) {
		this(item, null);
	}

	Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
	}
}
