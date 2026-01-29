package com.umwia1002.solution.lab.version1.lab03;

public interface BagInterface<T> {

    /**
     * Gets the current number of entries in this bag.
     *
     * @return the integer number of entries currently in the bag
     */
    int getCurrentSize();

    /**
     * Sees whether this bag is full.
     *
     * @return true if the bag is full, or false if not
     */
    boolean isFull();

    /**
     * Sees whether this bag is empty.
     *
     * @return true if the bag is empty, or false if not
     */
    boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return either the removed entry, if the removal was successful, or null
     */
    T remove();

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false if not
     */
    boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry the entry to locate
     * @return true if this bag contains anEntry, or false otherwise
     */
    boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return a newly allocated array of all the entries in the bag
     */
    T[] toArray();

    /**
     * Returns a new bag that contains all the elements of this bag and another bag
     *
     * @param anotherBag the bag to be added
     * @return a new bag that contains all the elements of this bag and another bag
     */
    BagInterface<T> union(BagInterface<T> anotherBag);

    /**
     * Returns a new bag that contains all the elements that are in this bag but not in another bag
     *
     * @param anotherBag the bag to be compared
     * @return a new bag that contains all the elements that are in this bag but not in another bag
     */
    BagInterface<T> difference(BagInterface<T> anotherBag);

    /**
     * Returns a new bag that contains all the elements that are common to this bag and another bag
     *
     * @param anotherBag the bag to be compared
     * @return a new bag that contains all the elements that are common to this bag and another bag
     */
    BagInterface<T> intersection(BagInterface<T> anotherBag);
}
