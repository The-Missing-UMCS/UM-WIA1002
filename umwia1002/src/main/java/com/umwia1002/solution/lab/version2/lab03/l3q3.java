package com.umwia1002.solution.lab.version2.lab03;

import com.umwia1002.solution.util.InputUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Generates permutations of an array of random integers.
 */
public class l3q3 {

    public static void main(String[] args) {
        int numElements = InputUtil.getIntInput("Enter number of elements: ");

        int[] array = generateRandomArray(numElements, 0, 9);
        System.out.println("Generated Array: " + Arrays.toString(array));

        Set<Integer> answers = generatePermutations(array);
        System.out.println("Number of Permutations: " + answers.size());
        System.out.println("Permutations: " + answers);
    }

    /**
     * Generates a random array of integers.
     *
     * @param size the size of the array
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return the generated random array
     */
    private static int[] generateRandomArray(int size, int min, int max) {
        return new Random().ints(size, min, max + 1).toArray();
    }

    /**
     * Generates all unique permutations of the given array.
     *
     * @param array the input array
     */
    public static Set<Integer> generatePermutations(int[] array) {
        Set<Integer> answers = new HashSet<>();
        generatePermutations(array, 0, answers);
        return answers;
    }

    /**
     * Recursively generates permutations and avoids duplicates using a set.
     *
     * @param array the input array
     * @param perm the current permutation being built
     * @param set the set to store unique permutations
     */
    private static void generatePermutations(int[] array, int perm, Set<Integer> set) {
        if (array.length == 0) {
            set.add(perm);
        } else {
            for (int i = 0; i < array.length; i++) {
                int[] remaining = removeElementAt(array, i);
                generatePermutations(remaining, perm * 10 + array[i], set);
            }
        }
    }

    /**
     * Removes an element from the array at the specified index.
     *
     * @param array the input array
     * @param index the index of the element to remove
     * @return the new array with the element removed
     */
    private static int[] removeElementAt(int[] array, int index) {
        int[] result = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                result[j++] = array[i];
            }
        }
        return result;
    }
}
