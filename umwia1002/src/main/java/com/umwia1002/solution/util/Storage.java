package com.umwia1002.solution.util;

/**
 * Generic interface for storage operations.
 *
 * @param <T> The type of objects stored.
 */
public interface Storage<T> {
    /**
     * Adds an object to the storage.
     *
     * @param object The object to be stored.
     * @return true if the object was successfully added.
     */
    boolean add(T object);

    /**
     * Displays the stored objects.
     */
    void display();
}
