package com.umwia1002.solution.lab.version2.lab04.l4q2;

import com.umwia1002.solution.lab.version2.lab04.util.LinkedList;

import java.util.List;

import static com.umwia1002.solution.util.ConsoleUtil.logGreen;

public class Main {

    public static void main(String[] args) {
        // 1. Initialize the LinkedList with characters from "Banking"
        LinkedList<Character> list = initializeList("Banking");
        System.out.println("The original list: " + list);

        // 2. Split the list into two parts
        logGreen("\nSplit the list into two parts:");
        List<List<Character>> splitLists = list.splitList();
        printSplitLists(splitLists);

        // 3. Merge the two split lists
        logGreen("\nMerge the split lists:");
        List<Character> mergedList = list.mergeList(splitLists);
        System.out.println("Merged List: " + mergedList);

        // 4. Split the list by alternating nodes
        logGreen("\nSplit the list by alternating nodes:");
        List<List<Character>> alternateLists = list.alternateList();
        printSplitLists(alternateLists);

        // 5. Merge the alternating split lists
        logGreen("\nMerge the alternating split lists:");
        List<Character> mergedAlternatingList = list.mergeAlternateList(alternateLists);
        System.out.println("Merged Alternating List: " + mergedAlternatingList);

        // 6. Reverse the list using LinkedList's recursive method
        logGreen("\nReverse the list (using LinkedList's recursive method):");
        list.reverse();
        System.out.println("Reversed List: " + list);

        // 7. Reverse the list again using Tester class's recursive method
        logGreen("\nReverse the list (using Tester's recursive method):");
        reverseList(list);
        System.out.println("Reversed List: " + list);
    }

    /**
     * Initializes a LinkedList with characters from a given string.
     *
     * @param input The input string.
     * @return A LinkedList containing the characters of the string.
     */
    private static LinkedList<Character> initializeList(String input) {
        LinkedList<Character> list = new LinkedList<>();
        input.chars().mapToObj(c -> (char) c).forEach(list::add);
        return list;
    }

    /**
     * Prints the two parts of a split list.
     *
     * @param splitLists The lists created by splitting.
     */
    private static void printSplitLists(List<List<Character>> splitLists) {
        for (int i = 0; i < splitLists.size(); i++) {
            System.out.printf("List %d: %s%n", i + 1, splitLists.get(i));
        }
    }

    /**
     * Reverses the LinkedList using its built-in reverse method.
     *
     * @param list The LinkedList to reverse.
     */
    private static void reverseList(LinkedList<Character> list) {
        list.reverse();
    }
}
