package com.umwia1002.solution.lab.version1.lab3;

import java.util.Arrays;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.joining;

public class ArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        initializeBag("bag1", bag1, contentsOfBag1);
        initializeBag("bag2", bag2, contentsOfBag2);
        interaction(BagInterface::union, bag1, bag2, "bag3, test the method union of bag1 and bag2");
        interaction(BagInterface::intersection, bag1, bag2, "bag4, test the method intersection of bag1 and bag2");
        interaction(BagInterface::difference, bag1, bag2, "bag5, test the method difference of bag1 and bag2");
    }

    private static void interaction(BiFunction<BagInterface<String>, BagInterface<String>, BagInterface<String>> func,
                                    BagInterface<String> bag1, BagInterface<String> bag2,
                                    String message) {
        System.out.println(message);
        BagInterface<String> result = func.apply(bag1, bag2);
        displayBag(result);
    }

    private static void initializeBag(String label, BagInterface<String> bag, String[] content) {
        // 1. Add the contents of the array to the bag
        System.out.printf("Adding to %s: %s%n", label, String.join(" ", content));
        Arrays.stream(content).forEach(bag::add);

        // 2. Display the contents of the bag
        displayBag(bag);
    }

    private static void displayBag(BagInterface<String> bag) {
        Object[] content = bag.toArray();
        System.out.printf("The bag contains %d string(s), as follows:%n", content.length);
        String objectString = Arrays.stream(content).map(Object::toString).collect(joining(","));
        System.out.println(objectString + System.lineSeparator());
    }

}
