package com.umwia1002.solution.lab.version2.lab07.l7q1;

import java.util.Random;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = rand.ints(10, 0, 20).toArray();
        IntegerTree bst = new IntegerTree();
        System.out.print("The random numbers are ");
        for (int i : arr) {
            System.out.print(i + " ");
            bst.insert(i);
        }

        System.out.println("\nThe number of elements in the tree " + bst.getSize());

        System.out.print("The tree elements - PREORDER : ");
        bst.preOrder();
        System.out.println();

        System.out.print("The tree elements - INORDER : ");
        bst.inOrder();
        System.out.println();

        System.out.print("The tree elements - POSTORDER : ");
        bst.postOrder();
        System.out.println();

        System.out.println("The minimum number is " + bst.minValue());
        System.out.println("The maximum number is " + bst.maxValue());

        System.out.println("The total is " + bst.getTotal());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int value = sc.nextInt();
        sc.close();
        System.out.println(
            "The number of occurrence of " + value + " is " + bst.getOccurence(value));
        // The number of occurrence (allow duplicate value)
        // The total value in the
    }


}
