package com.umwia1002.solution.lab.version1.lab7.lab7b.Q1;

import com.umwia1002.solution.lab.version1.lab7.lab7b.Q1.queue.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final int PRINT_LABEL_WIDTH = 45; // Width for labels in printing

    public static void main(String[] args) {
        // 1. Initialize the priority queue with the given input array
        //    You might use java.util.PriorityQueue as well
        int[] inputArray = {4, 8, 1, 2, 9, 6, 3, 7};
        PriorityQueue<Integer> pq = createPriorityQueue(inputArray);

        // 2. Displaying all the elements in the priority queue
        printWithLabel("Initial PriorityQueue", pq);

        // 3. Retrieving and removing the first element in the priority queue
        printWithLabel("Polled Element", pq.poll());

        // 4. Adding new element 5 into the priority queue
        pq.add(5);
        printWithLabel("After Adding Element 5", pq);

        // 5. Converting the priority queue into an array and displaying
        Integer[] arrayRepresentation = pq.toArray(new Integer[0]);
        printWithLabel("To Array", Arrays.toString(arrayRepresentation));

        // 6. Retrieving the first element in the priority queue
        printWithLabel("Peek Element", pq.peek());

        // 7. Checking if the priority queue consists of element "1"
        printWithLabel("Contains Element 1", pq.contains(1));

        // 8. Getting the current size of the priority queue
        printWithLabel("Size of PriorityQueue", pq.size());

        // 9. Displaying and removing all elements in the priority queue
        String removedElements = removeAllElements(pq);
        printWithLabel("Removed Elements", removedElements);
        printWithLabel("Is PriorityQueue Empty?", pq.isEmpty());

        // 10. Sorting the priority queue in reverse order
        PriorityQueue<Integer> reversePQ = createReversePriorityQueue(arrayRepresentation);
        printWithLabel("PriorityQueue in Reverse Order", reversePQ);
    }

    /**
     * Creates a customized PriorityQueue with natural ordering from the given input array.
     */
    private static PriorityQueue<Integer> createPriorityQueue(int[] inputArray) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(inputArray).forEach(pq::add); // Add elements from the array to the queue
        return pq;
    }

    /**
     * Creates a customized PriorityQueue with reverse ordering from the given input array.
     */
    private static PriorityQueue<Integer> createReversePriorityQueue(Integer[] inputArray) {
        PriorityQueue<Integer> reversePQ = new PriorityQueue<>(Comparator.comparingInt(x -> -x));
        Arrays.stream(inputArray).forEach(reversePQ::add); // Add elements from the array to the queue
        return reversePQ;
    }

    /**
     * Removes and returns all elements from the PriorityQueue as a string.
     */
    private static String removeAllElements(PriorityQueue<Integer> pq) {
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * Prints a label and value with consistent formatting.
     */
    private static void printWithLabel(String label, Object value) {
        System.out.printf(" %-" + PRINT_LABEL_WIDTH + "s : %s%n", label, value);
    }
}
