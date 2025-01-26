package com.umwia1002.solution.lab.version2.lab2.Q2;

/**
 * A simple log interface for managing a collection of items.
 *
 * @param <T> the type of items to be stored in the log
 */
public interface SimpleLog<T> {

    /**
     * Inserts an item into the log.
     *
     * @param item the item to be inserted
     * @return {@code true} if the item was successfully inserted,
     * {@code false} if the log is full
     */
    boolean insert(T item);

    /**
     * Checks if the log is full.
     *
     * @return {@code true} if the log is full, {@code false} otherwise
     */
    boolean isFull();

    /**
     * Gets the current number of items in the log.
     *
     * @return the number of items in the log
     */
    int size();

    /**
     * Checks if the log contains the specified item.
     *
     * @param item the item to check for
     * @return {@code true} if the item is found in the log,
     * {@code false} otherwise
     */
    boolean contains(T item);

    /**
     * Deletes the specified item from the log, if it exists.
     *
     * @param item the item to delete
     * @return {@code true} if the item was successfully deleted,
     * {@code false} if the item was not found in the log
     */
    boolean delete(T item);

    /**
     * Displays all the items in the log.
     */
    void display();

    /**
     * Clears all the items from the log, resetting its size to zero.
     */
    void clear();
}
