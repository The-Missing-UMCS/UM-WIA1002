package com.umwia1002.solution.lab.version2.lab09.impl;

import java.util.Objects;
import java.util.function.BiConsumer;

public abstract class AbstractArrayHashTable<K, V> implements ArrayHashTable<K, V> {

    protected final int capacity;
    protected int size;

    protected AbstractArrayHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void showHashTable() {
        StringBuilder builder = new StringBuilder();
        forEachEntry((key, value) -> builder.append(key).append(" : ").append(value).append(" | "));
        System.out.println(builder);
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        final boolean[] found = {false};
        forEachEntry((key, entryValue) -> {
            if (!found[0] && Objects.equals(entryValue, value)) {
                found[0] = true;
            }
        });
        return found[0];
    }

    protected int hash(K key, int capacity) {
        return Math.floorMod(key.hashCode(), capacity);
    }

    protected abstract void forEachEntry(BiConsumer<K, V> action);
}
