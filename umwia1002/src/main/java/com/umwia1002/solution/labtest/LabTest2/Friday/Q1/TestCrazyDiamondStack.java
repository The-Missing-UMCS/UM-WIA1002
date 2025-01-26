package com.umwia1002.solution.labtest.LabTest2.Friday.Q1;

public class TestCrazyDiamondStack {
    public static void main(String[] args) {
        CrazyDiamondStack<String> stack = new CrazyDiamondStack<>();
        System.out.println(stack);
        stack.push("Cinderella");
        stack.push("Echoes");
        stack.push("Earth Wind and Fire");
        stack.push("The Hand");
        stack.push("Heaven's Door");
        System.out.println(stack);
        System.out.println();
        for (int i = 0; i < 4; i++)
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println();
        stack.push("Harvest");
        stack.push("The Lock");
        stack.push("Pearl Jam");
        stack.push("Surface");
        stack.push("Love Deluxe");
        stack.push("Highway Star");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();
        stack.push("Killer Queen");
        stack.push("Sheer Heart Attack");
        stack.push("Bites the Dust");
        System.out.println(stack.peek());
        System.out.println(stack);
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