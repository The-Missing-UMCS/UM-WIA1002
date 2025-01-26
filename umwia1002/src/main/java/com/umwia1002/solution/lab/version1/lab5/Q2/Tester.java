package com.umwia1002.solution.lab.version1.lab5.Q2;

import java.util.Scanner;

public class Tester {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList<String> nameList = new SinglyLinkedList<>();
        setNameList(nameList);
        rename(nameList);
        removeStudent(nameList);
        System.out.println("\nAll students data captured complete. Thank you!");
    }

    public static void setNameList(SinglyLinkedList<String> nameList) {
        System.out.println("Enter your student name list. Enter 'n' to end......");

        int i = 1;
        while (true) {
            System.out.printf("Enter student name %d: ", i++);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
            if(!input.isEmpty()) {
                nameList.add(input);
            }
        }

        System.out.println("\nYou have entered the following students' name :");
        nameList.printList();
        System.out.printf("\nThe number of students entered is: %d\n", nameList.getSize());
    }

    public static void rename(SinglyLinkedList<String> nameList) {
        System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed");
        if (!"r".equalsIgnoreCase(scanner.nextLine().trim())) {
            return;
        }
        String oldName = input("Enter the existing student name that u want to rename : ");
        if(!nameList.contains(oldName)) {
            System.out.printf("Student name '%s' not found.\n", oldName);
            return;
        }
        String newName = input("Enter the new name : ");
        nameList.replace(oldName, newName);

        System.out.println("\nThe new student list is : ");
        nameList.printList();
    }

    public static void removeStudent(SinglyLinkedList<String> nameList) {
        System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed");

        if (!"y".equalsIgnoreCase(scanner.nextLine().trim())) {
            return;
        }

        String nameToRemoved = input("\nEnter a student name to remove : ");
        nameList.removeElement(nameToRemoved);

        System.out.printf("\nThe number of updated students is: %d\n", nameList.getSize());
        System.out.println("\nThe updated student list is : ");
        nameList.printList();
    }

    private static String input(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }
}
