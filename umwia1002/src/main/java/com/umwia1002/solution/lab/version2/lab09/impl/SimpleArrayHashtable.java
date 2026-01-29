package com.umwia1002.solution.lab.version2.lab09.impl;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;

public class SimpleArrayHashtable<K, V> extends AbstractArrayHashTable<K, V> {

    private final Entry<K, V>[] entries;

    @SuppressWarnings("unchecked")
    public SimpleArrayHashtable(int capacity) {
        super(capacity);
        this.entries = (Entry<K, V>[]) new Entry[capacity];
    }

    @Override
    public boolean isFull() {
        return size == entries.length;
    }

    @Override
    public void clear() {
        Arrays.fill(entries, null);
        size = 0;
    }

    @Override
    public V get(K key) {
        int index = hash(key, entries.length);
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            return null;
        }
        return Objects.equals(entry.key, key) ? entry.value : null;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hash(key, entries.length);
        Entry<K, V> entry = entries[index];
        if (entry == null) {
            entries[index] = new Entry<>(key, value);
            size++;
            return true;
        }
        if (Objects.equals(entry.key, key)) {
            entry.value = value;
            return true;
        }
        return false;
    }

    @Override
    public V remove(K key) {
        int index = hash(key, entries.length);
        Entry<K, V> entry = entries[index];
        if (entry == null || !Objects.equals(entry.key, key)) {
            return null;
        }
        entries[index] = null;
        size--;
        return entry.value;
    }

    @Override
    public int indexOf(K key) {
        int index = hash(key, entries.length);
        Entry<K, V> entry = entries[index];
        if (entry == null || !Objects.equals(entry.key, key)) {
            return -1;
        }
        return index;
    }

    @Override
    protected void forEachEntry(BiConsumer<K, V> action) {
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                action.accept(entry.key, entry.value);
            }
        }
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
