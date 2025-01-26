package com.umwia1002.solution.lab.version1.lab7.lab7b.Q1.queue;

public interface Queue<E> {
	String toString();
	E poll();
	void add(E o);
	Object[] toArray();
	E peek();
	boolean contains(E o);
	int size();
	boolean isEmpty();
}
