package com.umwia1002.solution.lab.version2.lab4.archieve.lab5;

import java.util.*;

public class LinkedList<E extends Comparable<E>> {
	Node<E> head;
	Node<E> tail;
	int size;

	public static class Node<E extends Comparable<E>> {
		E element;
		Node<E> prev;
		Node<E> next;

		Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
	}

	public void addFirst(E elem) {
		Node<E> node = new Node<E>(null, elem, head);
		head = node;
		if (tail == null) {
			tail = head;
		}
		size++;
	}

	public void addLast(E elem) {
		Node<E> node = new Node<E>(tail, elem, null);

		if (tail == null)
			head = node;
		else
			tail.next = node;

		tail = node;
		size++;
	}

	public void add(E elem) {
		addLast(elem);
	}

	public void add(int index, E elem) {
		checkPositionIndex(index);
		if (index == size) {
			addLast(elem);
		} else {
			linkBefore(elem, node(index));
		}
	}

	void linkBefore(E elem, Node<E> succ) {
		Node<E> pred = succ.prev;
		Node<E> newNode = new Node<E>(pred, elem, succ);
		succ.prev = newNode;
		if (pred == null)
			head = newNode;
		else
			pred.next = newNode;
		size++;
	}

	public E set(int i, E elem) {
		checkElementIndex(i);
		Node<E> node = node(i);
		E oldVal = node.element;
		node.element = elem;
		return oldVal;
	}

	public E removeFirst() {
		if (head == null)
			throw new NoSuchElementException();

		E element = head.element;
		head = head.next;

		if (head == null)
			tail = null;
		size--;

		return element;
	}

	public E removeLast() {
		if (tail == null)
			throw new NoSuchElementException();

		E element = tail.element;
		tail = tail.prev;

		if (tail == null)
			head = null;
		size--;

		return element;
	}

	public E remove(int i) {
		checkElementIndex(i);

		if (i == 0) {
			return removeFirst();
		} else if (i == size - 1) {
			return removeLast();
		} else {
			Node<E> node = node(i);
			E element = node.element;
			node.prev.next = node.next;
			size--;
			return element;
		}
	}

	public E remove(E elem) {
		if (elem == null) {
			for (Node<E> node = head; node != null; node = node.next) {
				if (node.element == elem)
					return unlink(node);
			}
		} else {
			for (Node<E> node = head; node != null; node = node.next) {
				if (node.element.equals(elem))
					return unlink(node);
			}
		}

		return null;
	}

	public E unlink(Node<E> node) {
		E element = node.element;
		Node<E> prev = node.prev;
		Node<E> next = node.next;

		if (prev == null) {
			head = next;
		} else {
			prev.next = next;
			node.next = null;
		}

		if (next == null) {
			tail = prev;
		} else {
			next.prev = prev;
			node.prev = null;
		}

		node.element = null;
		size--;
		return element;
	}

	public boolean contains(E elem) {
		return indexOf(elem) >= 0;
	}

	public int indexOf(E elem) {
		int i = 0;
		if (elem == null) {
			for (Node<E> node = head; node != null; node = node.next, i++)
				if (node.element == elem)
					return i;
		} else {
			for (Node<E> node = head; node != null; node = node.next, i++) {
				if (node.element.equals(elem))
					return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E elem) {
		int i = 0;
		if (elem == null) {
			for (Node<E> node = tail; node != null; node = node.prev, i++)
				if (node.element == elem)
					return i;
		} else {
			for (Node<E> node = tail; node != null; node = node.prev, i++) {
				if (node.element.equals(elem))
					return i;
			}
		}
		return -1;
	}

	public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.element;
	}

	public E getLast() {
		if (tail == null)
			throw new NoSuchElementException();
		return tail.element;
	}

	public E get(int i) {
		checkElementIndex(i);
		return node(i).element;
	}

	public void clear() {
		for (Node<E> node = head; node != null;) {
			Node<E> next = node.next;
			node.element = null;
			node.next = node.prev = null;
			node = next;
		}
		head = tail = null;
	}

	Node<E> node(int index) {
		if (index < (size >> 1)) {
			Node<E> node = head;
			for (int i = 0; i < index; i++)
				node = node.next;
			return node;
		} else {
			Node<E> node = tail;
			for (int i = size - 1; i > index; i--)
				node = node.prev;
			return node;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Node<E> node = head; node != null; node = node.next) {
			sb.append(node.element).append(' ').append('-').append('-').append('>').append(' ');
		}

		return sb.toString();
	}

	public LinkedListIterator iterator() {
		return new LinkedListIterator(0);
	}

	private boolean isElementIndex(int i) {
		return i >= 0 && i < size;
	}

	private boolean isPositionIndex(int i) {
		return i >= 0 && i <= size;
	}

	private void checkElementIndex(int i) {
		if (!isElementIndex(i))
			throw new IndexOutOfBoundsException(outOfBoundMsg(i));
	}

	private void checkPositionIndex(int i) {
		if (!isPositionIndex(i))
			throw new IndexOutOfBoundsException(outOfBoundMsg(i));
	}

	private String outOfBoundMsg(int i) {
		return String.format("Index: %d, Size: %d", i, size);
	}

	public class LinkedListIterator implements Iterator<E> {
		private int nextIndex;
		private Node<E> next;
		private Node<E> lastReturned;

		public LinkedListIterator(int i) {
			this.next = node(i);
			this.nextIndex = i;
		}

		@Override
		public boolean hasNext() {
			return nextIndex < size;
		}

		@Override
		public E next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.element;
		}

		public void remove() {
			nextIndex--;
			unlink(lastReturned);
			lastReturned = null;
		}
	}
}
