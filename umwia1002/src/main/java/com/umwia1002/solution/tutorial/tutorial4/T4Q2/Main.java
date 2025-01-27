package com.umwia1002.solution.tutorial.tutorial4.T4Q2;

public class Main {
	// a) contains
	// b) 
}

class LinkedList<E> {
	static class Node<E> {
		E element;
		Node<E> next;
	}

	Node<E> head;
	Node<E> tail;
	int size;

	public boolean contains(E e) {
//		for(Node<E> node = head; node != null; node = node.next)
//			if(item.equals(node.item))
//				return true;
//		return false;
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (e.equals(current))
				return true;
			current = current.next;
		}
		return false;

	}
}
