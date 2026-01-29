package com.umwia1002.solution.lab.version2.lab09;

import com.umwia1002.solution.lab.version2.lab09.impl.ArrayHashTable;
import com.umwia1002.solution.lab.version2.lab09.impl.LinearProbeArrayHashTable;

import java.util.Scanner;

public class l9q3 {

    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        ArrayHashTable<String, String> table = new LinearProbeArrayHashTable<>(MAX_SIZE);

        // Insert initial courses
        table.put("100-101", "ICND 1");
        table.put("200-101", "ICND 2");
        table.put("200-120", "CCNA Routing and Switching");
        table.put("210-260", "CCNA Security");

        System.out.println("The number of course is " + table.getSize());
        table.showHashTable();

        System.out.println("Adding a new course");
        table.put("300-101", "ROUTE");
        System.out.println("The number of course is " + table.getSize());
        table.showHashTable();

        System.out.println("Modifying 210-260");
        table.put("210-260", "CCNA RS Security");
        System.out.println("The number of course is " + table.getSize());
        table.showHashTable();

        System.out.println("Remove the course 200-101");
        table.remove("200-101");
        System.out.println("The number of course is " + table.getSize());
        table.showHashTable();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a course code to search : ");
            String code = scanner.nextLine().trim();
            String name = table.get(code);
            if (name == null) {
                System.out.println("Course " + code + " does not exist");
            } else {
                System.out.println("Course " + code + " : " + name);
            }
        }
    }
}
