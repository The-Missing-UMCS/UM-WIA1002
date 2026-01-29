package com.umwia1002.solution.lab.version2.lab05.l5q1;

public class Main {

    public static void main(String[] args) {
        MyStack<String> container = new MyStack<>();

        // a. Ahmad randomly selects a number of candy and insert into a candy container
        String[] colours = {"Orange", "Red", "Blue", "Orange", "Yellow", "Yellow", "Blue"};
        for (String colour : colours) {
            container.push(colour);
        }

        System.out.println("The candies in the container:");
        System.out.println(container);

        // b.
        System.out.println(
            "Ali takes all the candies one by one from the container and eats the blue ones.");

        MyStack<String> outside = new MyStack<>();
        while (!container.empty()) {
            if (container.peek().equals("Blue")) {
                container.pop(); // Eat the blue ones
            } else {
                outside.push(container.pop());
            }
        }

        // c.
        System.out.println("He puts back the rest of candies in the container.");
        while (!outside.empty()) {
            container.push(outside.pop());
        }

        // d.
        System.out.println("The candies in the container: ");
        System.out.println(container);


    }
}
