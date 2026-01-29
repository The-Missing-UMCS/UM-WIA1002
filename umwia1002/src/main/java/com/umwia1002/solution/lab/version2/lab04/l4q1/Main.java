package com.umwia1002.solution.lab.version2.lab04.l4q1;

import com.umwia1002.solution.lab.version2.lab04.util.LinkedList;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        int[] arr = new Random().ints(10, 0, 100).toArray();
        System.out.println("The random numbers are : " + Arrays.toString(arr));

        LinkedList<Integer> list = new LinkedList<>();
        performOperation("Insert the random numbers at the back of the linked list",
            list, ls -> Arrays.stream(arr).forEach(ls::addLast));
        performOperation("Insert the random numbers in the front of the linked list",
            list, ls -> Arrays.stream(arr).forEach(ls::addFirst));
        performOperation("Insert the random numbers in a sorted linked list",
            list, ls -> Arrays.stream(arr).forEach(ls::addSortNode));
    }

    private static void performOperation(String operation,
                                         LinkedList<Integer> list,
                                         Consumer<LinkedList<Integer>> consumer) {
        System.out.println(operation);
        consumer.accept(list);
        System.out.println(list.toQ1String());
        list.clear();
    }
}
