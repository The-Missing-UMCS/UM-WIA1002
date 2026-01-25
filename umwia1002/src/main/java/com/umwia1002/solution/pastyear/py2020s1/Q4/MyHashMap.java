package com.umwia1002.solution.pastyear.py2020s1.Q4;

import java.util.Arrays;
public class MyHashMap<K, V> {
    int size;
    Entry[] table;

    MyHashMap() {
        this(15);
    }

    MyHashMap(int initialCapacity) {
        table = new Entry[initialCapacity];
    }

    void grow() {
        int oldCapacity = table.length;
        int newCapacity = oldCapacity < 64 ? oldCapacity + 2 : oldCapacity << 1;
        table = Arrays.copyOf(table, newCapacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Entry get(K key) {
        for(int i = 0; i < size; i++) {
            if(table[i].key.equals(key))
                return table[i];
        }
        return null; // Entry not found
    }

    public String put(String key, String value) {
        // Update the value if the key exists
        for(int i = 0; i < size; i++) {
            if(table[i].key.equals(key)) {
                return table[i].setValue(value); 
            }
        }
        // Create new entry if the key does not exist
        if(size >= table.length - 1) grow();
        table[size++] = new Entry(key, value);
        return value;
    }
}
