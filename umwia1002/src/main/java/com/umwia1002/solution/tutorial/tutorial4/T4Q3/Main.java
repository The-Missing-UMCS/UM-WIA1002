package com.umwia1002.solution.tutorial.tutorial4.T4Q3;

import java.util.NoSuchElementException;

public class Main {
	// a) removeLast
	// b)
}

class LinkedList<E> {
	static class Node<E> {
		E item;
		Node<E> next;
	}

	Node<E> head;
	Node<E> tail;

	public E removeLast() {
		if (tail == null)
			throw new NoSuchElementException();

		Node<E> prev = null;
		Node<E> node = head;

		while (node.next != null) {
			prev = node;
			node = node.next;
		}

		if (prev == null)
			head = null;
		else
			prev.next = null;

		tail = prev;
		return node.item;

	}
}
