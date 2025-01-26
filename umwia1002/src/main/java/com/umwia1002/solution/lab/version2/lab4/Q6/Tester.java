package com.umwia1002.solution.lab.version2.lab4.Q6;

import com.umwia1002.solution.lab.version2.lab4.util.LinkedList;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        int[] arr = new Random().ints(10, 0, 100).toArray();
        System.out.println("The random numbers are : " + Arrays.toString(arr));

        List<Integer> list = new LinkedList<>();
        System.out.println("Insert the random numbers into the doubly linked list");
        list.addAll(Arrays.stream(arr).boxed().toList());
        System.out.println(list);

        // a. Remove a random number from third position
        System.out.println("Remove a random number from third position");
        list.remove((int) 2);
        System.out.println(list);

        // b. Replace the number in seventh position with 999
        System.out.println("Replace the number in seventh position with 999");
        list.set(6, 999);
        System.out.println(list);

        // c. Remove all even number from the doubly linked list
        System.out.println("Remove all even number from the doubly linked list");

        // c.1. Using iterator
        Iterator<Integer> ltr = list.iterator();
        while (ltr.hasNext()) {
            if (ltr.next() % 2 == 0)
                ltr.remove();
        }

        // c.2. Using removeIf
        // list.removeIf(i -> i % 2 == 0);

        System.out.println(list);

    }
}
