package com.umwia1002.solution.labtest.LabTest2.Thursday.Q1;

public class TestDArbyStack {
    public static void main(String[] args) {
        DArbyStack<String> stack = new DArbyStack<>();
        System.out.println(stack);
        stack.push("It's My Birthday");
        stack.push("Pass Go");
        stack.push("Pass Go");
        stack.push("Pass Go");
        stack.push("Debt Collector");
        System.out.println(stack);
        System.out.println();
        for (int i = 0; i < 3; i++)
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack.remove(1));

        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println();

        stack.push("Forced Deal");
        stack.push("Deal Breaker");
        stack.push("Just Say No");
        stack.push("Deal Breaker");
        stack.push("Sly Deal");
        stack.push("Debt Collector");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.remove(7));
        // stacks.print();
        System.out.println(stack.size());
        System.out.println(stack.remove(6));
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();
        stack.push("Pass Go");
        stack.push("Double The Rent");
        stack.push("Sly Deal");
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.remove(5));
        System.out.println(stack.remove(5));
        System.out.println(stack.size());
        System.out.println();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack);
    }
}
