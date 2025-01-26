package com.umwia1002.solution.lab.version2.lab4.archieve.lab6;

public class DoubleListNode<E> {
	E element;
	DoubleListNode<E> prev;
	DoubleListNode<E> next;

	DoubleListNode(DoubleListNode<E> prev, E element, DoubleListNode<E> next) {
		this.prev = prev;
		this.element = element;
		this.next = next;
	}
}
