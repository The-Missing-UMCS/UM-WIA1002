package com.umwia1002.solution.labtest.LabTest2.Wednesday.Q1;


public class TestDIOStack {
    public static void main(String[] args) {
        DIOStack<String> stack = new DIOStack<>();
        System.out.println(stack);
        stack.push("Spiral Staircase");
        stack.push("Rhinoceros Beetle");
        stack.push("Desolation Row");
        stack.push("Fig Tart");
        stack.push("Rhinoceros Beetle");

        System.out.println(stack);
        System.out.println();
        for (int i = 0; i < 4; i++)
            System.out.print(stack.pop() + " > ");
        System.out.println();
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println();
        stack.push("Via Dolorosa");
        stack.push("Rhinoceros Beetle");
        stack.push("Singularity Point");
        stack.push("Giotto");
        stack.push("Angel");
        stack.push("Hydrangea");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack);
        System.out.println();
        stack.push("Rhinoceros Beetle");
        stack.push("Singularity Point");
        stack.push("Secret Emperor");
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