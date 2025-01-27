package com.umwia1002.solution.tutorial.tutorial3.T3Q2;

public interface BidCollectionInterface<E extends BidInterface> {
	/**
	 * Add an bid to this collection
	 * @param bid bid to be added
	 */
	void addBid(E bid);
	
	/**
	 * Return the bid in this collection with the best yearly cost
	 * @return the bid in this collection with the best yearly cost
	 */
	double getBestYearlyCost();
	
	/**
	 * Return the bid in this collection with the best initial cost.
	 * The initial cost will be defined as the {@code unit cost} + {@code installation cost}
	 * @return bid the bid in this collection with the best initial cost
	 */
	double getBestInitialCost();
	
	/**
	 * Clear all the items from the collection
	 */
	void clear();
	
	/**
	 * Get the number of items in this collection
	 * @return the number of items in this collection
	 */
	int getSize();
	
	/**
	 * See whether this collection is empty
	 * @return {@code true} if the collection is empty, false otherwise
	 */
	boolean isEmpty();	
}
