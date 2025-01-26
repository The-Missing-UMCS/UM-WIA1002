package com.umwia1002.solution.lab.version2.lab5.Q1;

import java.util.Iterator;
import java.util.LinkedList;

public class MyStack<E> {
	private LinkedList<E> list;

	MyStack() {
		list = new LinkedList<>();
	}

	public void push(E elem) {
		list.addFirst(elem);
	}

	public E pop() {
		return list.removeFirst();
	}

	public E peek() {
		return list.getFirst();
	}
	
	public boolean empty() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<E> ltr = list.iterator();
		while (ltr.hasNext())
			sb.append(" <-- ").append(ltr.next());
		return sb.toString();
	}
}
