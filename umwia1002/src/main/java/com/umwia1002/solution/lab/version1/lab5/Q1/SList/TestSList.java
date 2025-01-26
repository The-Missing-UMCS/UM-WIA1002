package com.umwia1002.solution.lab.version1.lab5.Q1.SList;

public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");
        list.display();

        list.removeInitial();
        list.display();

        System.out.println("Contains 'difficult' = " + list.contains("difficult"));

        list.clear();
        list.display();

    }

}
