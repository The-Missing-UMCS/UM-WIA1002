# Time Complexity Analysis - Transaction.transformation()

To calculate the time complexity of the transformation() method, we need to analyze each loop and operation involved.

## Using Map

### First loop (grouping transactions by user and date)

- `for loop` over `dataList()`: $O(n)$
- `computeIfAbsent` operation: $O(\log n)$ (worst-case) for each entry in the resulting `Map`

Total time complexity for first loop: $O(n\log n)$

### Second loop (calculate mean for each user-date pair)

- for loop over userTransactionsMap.entrySet(): $O(u)$, where $u$ is the number of distinct users
- for loop over dateTransactionMap.entrySet(): $O(d)$, where $d$ is the number of distinct dates for the current user

- Calculating running sum and running weighted count for each date: $O(1)$ for each DateData object
- Calculating the mean for each date: $O(1)$
- Putting the mean in dateMeanMap: $O(\log d)$
- Putting the dateMeanMap for the current user in userDateMeanMap: $O(\log u)$

Total time complexity for second loop: $O(ud\log d)$

### Third loop (update transaction amount with deviation from mean)

- for loop over dataList(): $O(n)$
- Finding the mean for the current user and date: $O(\log d)$
- Calculating the deviation: $O(1)$
- Setting the new data value for the transaction: $O(1)$

Total time complexity for third loop: $O(n\log d)$

Overall time complexity of transformation() method: $O(n\log n + ud\log d + n\log d)$

## Using nested for loop

Let $n$ be the number of data points.

The first loop iterates over each data point and performs an inner loop over all data points, resulting in a time complexity of $O(n^2)$.

The second loop simply iterates over all data points and performs constant-time operations, giving a time complexity of $O(n)$.

The overall time complexity is therefore $O(n^2 + n) = O(n^2)$.

## Conclusion

Therefore, Algorithm 1 is generally better than Algorithm 2, especially for larger datasets. However, Algorithm 2 may be less efficient for smaller datasets or datasets with few distinct users and dates.
