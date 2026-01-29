package com.umwia1002.solution.lab.version1.lab06.l6q1;

public class Tester {

    public static void main(String[] args) {
        // 1. Adding 'a', 'b' and 'c'
        MyStack<Character> stack = new MyStack<>();
        for (char ch = 'a'; ch <= 'c'; ch++) {
            stack.push(ch);
        }
        System.out.println(stack);

        // 2. Check if 'b' and 'k' are in the stacks
        System.out.println("'b' is in the stacks: " + stack.search('b'));
        System.out.println("'k' is in the stacks: " + stack.search('k'));
        System.out.println();

        // 3. Adding 1, 2 and 3
        MyStack<Integer> stack2 = new MyStack<>();
        for (int i = 1; i <= 3; i++) {
            stack2.push(i);
        }

        // 4. Check if 6 is in the stacks
        System.out.println(stack2);
        System.out.println("'6' is in the stacks: " + stack2.search(6));

    }
}
