package com.umwia1002.solution.lab.version2.lab04.l4q7;

import com.umwia1002.solution.util.InputUtil;

public class Main {

    public static void main(String[] args) {
        String[] arr = InputUtil.getStringInput("Enter a sentence: ").split(" ");

        // 1. Instantiate the CircularLinkedList
        CircularLinkedList<String> list = new CircularLinkedList<>();
        for (String word : arr) {
            list.addCircularNode(word);
        }

        System.out.println("The words in the circular linked list");
        list.displayCircularList();

        // 2. Delete a word from the CircularLinkedList
        System.out.println("After delete a word");
        list.deleteCircularNode();
        list.displayCircularList();

        System.out.println("The second item in the list is '" + list.getCircularItem(1) + "'");
    }
}
