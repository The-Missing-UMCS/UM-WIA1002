package com.umwia1002.solution.lab.version2.lab09.impl;

public interface ArrayHashTable<K, V> {

    boolean isEmpty();

    boolean isFull();

    int getSize();

    int getCapacity();

    void clear();

    void showHashTable();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    boolean put(K key, V value);

    V remove(K key);

    int indexOf(K key);
}
