package com.umwia1002.solution.lab.version2.lab2.Q2;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Create a text file log with maximum records equal to 5");
        TextFileLog<String> textFileLog = new TextFileLog<>(5);

        String[] names = {"James", "Ahmad", "Siti", "Ramesh", "John"};
        for (String name : names) {
            textFileLog.insert(name);
        }

        System.out.println("Current Log:");
        textFileLog.display();

        System.out.println("\nAdding another record...");
        boolean inserted = textFileLog.insert("Ng");
        System.out.println("The log is " + (inserted ? "not full" : "full"));

        String searchName = "Siti";
        System.out.printf("Searching for '%s' in the log...%n", searchName);
        System.out.printf("The log %s '%s'%n",
            textFileLog.contains(searchName) ? "contains" : "does not contain", searchName);

        System.out.println("\nClearing the log...");
        textFileLog.clear();
        System.out.println("Log size after clearing: " + textFileLog.size());
    }
}
