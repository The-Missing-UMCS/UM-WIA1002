package com.umwia1002.solution.pastyear.PY2017_2.Q2;

import java.util.Scanner;

public class TestPileStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create a new stacks: an empty pile of books");
        StackInterface<String> bookPile = new GenericStack<>();
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        System.out.println();

        System.out.println("Push 3 books to the pile:");
        for (int i = 1; i <= 3; i++){
            System.out.print("Enter book title " + i + ": " + "\u001B[3m");
            String title = sc.nextLine();
            bookPile.push(title);
            System.out.println("\033[0m");
        }

        System.out.println();
        System.out.println("The new books that you added are: " + bookPile);
        System.out.println();

        System.out.println("The pile should not be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        System.out.println("The pile has " + bookPile.size() + " books.");
        System.out.println();

        System.out.println("Get the top book and remove the top book:");
        System.out.println();
        while (!bookPile.isEmpty()) {
            String topBook = bookPile.peek();
            System.out.println(topBook + " is at the top of the pile.");
            String removedBook = bookPile.pop();
            System.out.println(removedBook + " is removed from the pile.");
            System.out.println();
        }

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());

        sc.close();
    }
}
