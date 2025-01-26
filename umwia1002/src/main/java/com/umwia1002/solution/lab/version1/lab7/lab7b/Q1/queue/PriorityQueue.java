package com.umwia1002.solution.lab.version1.lab7.lab7b.Q1.queue;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("unchecked")
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	
	Object[] queue;
	Comparator<? super E> comparator;
	int size;
	
	public PriorityQueue() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	}
	
	public PriorityQueue(int initialCapacity) {
		this(initialCapacity, null);
	}
	
	public PriorityQueue(Comparator<? super E> comparator) {
		this(DEFAULT_INITIAL_CAPACITY, comparator);
	}
	
	public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
		this.queue = new Object[initialCapacity];
		this.comparator = comparator;
		this.size = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < size; i++)
			sb.append(queue[i]).append(',').append(' ');
		sb.setLength(sb.length() - 2);
		sb.append(']');
		return sb.toString();
	}
	
	
	public E poll() {
		final Object[] es;
		final E result;
		
		if((result = (E) (es = queue)[0]) != null) {
			final int n = --size;
			final E x = (E) es[n];
			es[n] = null;
			if(n > 0) {
				final Comparator<? super E> cmp = (Comparator<? super E>) comparator;
				if(cmp != null)
					siftDownUsingComparator(0, x, es, size, cmp);
				else
					siftDownComparable(0, x, es, size);
			}
		}
		return result;
	}
	
	private static <T> void siftDownComparable(int k, T x, Object[] es, int n) {
		Comparable<? super T> key = (Comparable<? super T>) x;
		int half = n >>> 1;
		while(k < half) {
			int child = (k << 1) + 1;
			Object e = es[child];
			int right = child + 1;
			if(right < n && 
					((Comparable<? super T>) es[right]).compareTo((T) e) < 0) {
				e = es[child = right];
			}
			if(key.compareTo((T) e) <= 0)
				break;
			es[k] = e;
			k = child;
		}
		es[k] = key;
	}
	
	private static <T> void siftDownUsingComparator(
			int k, T x, Object[] es, int n, Comparator<? super T> cmp) {
		Comparable<? super T> key = (Comparable<? super T>) x;
		int half = n >>> 1;
		while(k < half) {
			int child = (k << 1) + 1;
			Object e = es[child];
			int right = child + 1;
			if(right < n && 
					cmp.compare((T) es[right], (T) es[child]) < 0) {
				e = es[child = right];
			}
			if(key.compareTo((T) e) <= 0)
				break;
			es[k] = e;
			k = child;
		}
		es[k] = key;
	}
	
	public void add(E o) {
		if(!offer(o))
			throw new NullPointerException();
	}
	
	public boolean offer(E o) {
		if(o == null)
			return false;
		final int i = size;
		if(i >= queue.length) 
			grow(size + 1);
		siftUp(i, o);
		size = i + 1;
		return true;
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = queue.length;
		int newCapacity = ArraysSupport.newLength(oldCapacity,
				minCapacity - oldCapacity,
				oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);
		queue = Arrays.copyOf(queue, newCapacity);
	}
	
	private void siftUp(int k, E x) {
		if(comparator != null) {
			siftUpUsingComparator(k, x, queue, comparator);
		} else {
			siftUpComparable(k, x, queue);
		}
	}
	
	private static <T> void siftUpComparable(int k, T x, Object[] es) {
		Comparable<? super T> key = (Comparable<? super T>) x;
		while(k > 0) {
			int parent = (k - 1) >>> 1;
			Object e = es[parent];
			if(key.compareTo((T) e) >= 0)
				break;
			es[k] = e;
			k = parent;
		}
		es[k] = key;
	}
	
	private static <T> void siftUpUsingComparator(int k, T x, Object[] es, Comparator<? super T> cmp) {
		while(k > 0) {
			int parent = (k - 1) >>> 1;
			Object e = es[parent];
			if(cmp.compare(x, (T) e) >= 0)
				break;
			es[k] = e;
			k = parent;
		}
		es[k] = x;
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(queue, size);
	}
	
	public E[] toArray(E[] arr) {
		final int size = this.size;
		if(arr.length < size) 
			return (E[]) Arrays.copyOf(queue, size, arr.getClass());
		System.arraycopy(queue, 0, arr, 0, size);
		if(arr.length > size)
			arr[size] = null;
		return arr;
	}
	
	public E peek() {
		return (E) queue[0];
	}
	
	@Override
	public boolean contains(E o) {
		return indexOf(o) >= 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int indexOf(E o) {
		if(o != null) {
			final Object[] es = this.queue;
			for(int i = 0; i < size; i++) 
				if(es[i].equals(o))
					return i;
		}
		return -1;
	}
}
