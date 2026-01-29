package com.umwia1002.solution.lab.version2.lab09.impl;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;

public class LinearProbeArrayHashTable<K, V> extends AbstractArrayHashTable<K, V> {

    private final Entry<K, V>[] entries;

    @SuppressWarnings("unchecked")
    public LinearProbeArrayHashTable(int capacity) {
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
        int index = indexOf(key);
        return index >= 0 ? entries[index].value : null;
    }

    @Override
    public boolean put(K key, V value) {
        if (isFull()) {
            return false;
        }
        int index = nextInsertionSlot(key);
        if (index < 0) {
            return false;
        }

        Entry<K, V> entry = entries[index];
        if (entry == null || entry.deleted) {
            entries[index] = new Entry<>(key, value);
            size++;
        } else {
            entry.value = value;
        }
        return true;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index < 0) {
            return null;
        }
        Entry<K, V> entry = entries[index];
        entry.deleted = true;
        size--;
        return entry.value;
    }

    @Override
    protected void forEachEntry(BiConsumer<K, V> action) {
        for (Entry<K, V> entry : entries) {
            if (entry != null && !entry.deleted) {
                action.accept(entry.key, entry.value);
            }
        }
    }

    @Override
    public int indexOf(K key) {
        int capacity = entries.length;
        int start = hash(key, capacity);
        for (int i = 0; i < capacity; i++) {
            int index = (start + i) % capacity;
            Entry<K, V> entry = entries[index];
            if (entry == null) {
                return -1;
            }
            if (!entry.deleted && Objects.equals(entry.key, key)) {
                return index;
            }
        }
        return -1;
    }

    private int nextInsertionSlot(K key) {
        int capacity = entries.length;
        int start = hash(key, capacity);
        int firstDeleted = -1;
        for (int i = 0; i < capacity; i++) {
            int index = (start + i) % capacity;
            Entry<K, V> entry = entries[index];
            /*
             * Imagine the following scenario:
             * index = 5, (key = W, value = 1, deleted = true)
             * index = 6, (key = X, value = 2, deleted = false)
             * index = 7, (null)
             * index = 8, (null)
             *
             * Now, if we want to find key = X, and we do not check `if (entry == null)`,
             * the method would immediately return index = 5, resulting in a duplicated key.
             * Hence, we need to scan through all possible slots until `entry == null`
             * and return either the null entry index (a totally new slot) or the first deleted slot.
             */
            if (entry == null) {
                return firstDeleted >= 0 ? firstDeleted : index;
            }

            if (entry.deleted) {
                if (firstDeleted < 0) {
                    firstDeleted = index;
                }
            } else if (Objects.equals(entry.key, key)) {
                return index;
            }
        }
        return firstDeleted;
    }

    private static class Entry<K, V> {

        private final K key;
        private V value;
        private boolean deleted;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }
}


