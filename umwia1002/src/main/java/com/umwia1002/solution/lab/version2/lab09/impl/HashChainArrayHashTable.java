package com.umwia1002.solution.lab.version2.lab09.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class HashChainArrayHashTable<K, V> extends AbstractArrayHashTable<K, V> {

    private final Node<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashChainArrayHashTable(int capacity) {
        super(capacity);
        this.table = (Node<K, V>[]) new Node[capacity];
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public V get(K key) {
        int index = hash(key, table.length);
        for (Node<K, V> current = table[index]; current != null; current = current.next) {
            if (Objects.equals(current.entry.key, key)) {
                return current.entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key, table.length);
        Node<K, V> head = table[index];
        if (head == null) {
            table[index] = new Node<>(new Entry<>(key, value));
            size++;
            return true;
        }

        Node<K, V> current;
        for (current = head; current.next != null; current = current.next) {
            if (Objects.equals(current.entry.key, key)) {
                current.entry.value = value;
                return true;
            }
        }

        current.next = new Node<>(new Entry<>(key, value));
        size++;
        return true;
    }

    @Override
    public int indexOf(K key) {
        int index = hash(key, table.length);
        for (Node<K, V> current = table[index]; current != null; current = current.next) {
            if (Objects.equals(current.entry.key, key)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = hash(key, table.length);
        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (Objects.equals(current.entry.key, key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.entry.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    protected void forEachEntry(BiConsumer<K, V> action) {
        for (Node<K, V> head : table) {
            for (Node<K, V> current = head; current != null; current = current.next) {
                action.accept(current.entry.key, current.entry.value);
            }
        }
    }

    public List<Entry<K, V>> getChain(K key) {
        int index = hash(key, table.length);
        List<Entry<K, V>> entries = new ArrayList<>();
        for (Node<K, V> current = table[index]; current != null; current = current.next) {
            entries.add(current.entry);
        }
        return entries;
    }

    public static class Entry<K, V> {

        public final K key;
        public V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class Node<K, V> {

        private final Entry<K, V> entry;
        private Node<K, V> next;

        private Node(Entry<K, V> entry) {
            this.entry = entry;
        }
    }
}
